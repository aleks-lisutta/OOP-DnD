package Resource_based.Abilities;

import Entity.Enemy.Enemy;
import Entity.Tile.Unit;
import Resource_based.Resources.Energy;

import java.util.List;

public class FanOfKnives extends PlayerAbility {
    Energy energy;
    int cost;
    public FanOfKnives(int cost){
        energy=new Energy(100,cost);
        energy.setCur(energy.getMax());
        this.cost=cost;
    }
    @Override
    public String useAbility(List<Unit> ls) {
        if (!canUse())
            return p.name+" can not use with ability, "+p.name+" need more energy.\n";
        energy.setCur(energy.getCur()-cost);
        if (ls.size()==0)
            return p.name+" used with ability but enemies no exist in your range.\n";
        StringBuilder output=new StringBuilder();
        for(Unit u: ls){
            String check=u.receiveCast(this);
            if (check!=null)
                 output.append(check);
            }
        return output.toString();
    }
    public String attack(Enemy e) {
        int defRoll = (int) (Math.random() * e.def);
        if (p.att > defRoll) {
            return e.injured(p.att - defRoll, p);
        }
        return e.name+" success to def the attack.\n";
    }

    @Override
    protected boolean canUse() {
        return cost<=energy.getCur();
    }

    @Override
    public void LevelUp() {
        energy.setCur(100);
    }

    @Override
    public String Tick() {
       return energy.Tick(p.name);
    }

    @Override
    public String toString(){
        return  "Energy: "+energy.getCur()+"/"+energy.getMax()+"."+(canUse()? " Fan of Knives available" : "");
    }
}
