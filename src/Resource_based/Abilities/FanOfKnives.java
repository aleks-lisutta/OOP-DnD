package Resource_based.Abilities;

import Entity.Enemy.Enemy;
import Entity.Player.Player;
import Entity.Player.Rogues.Rogue;
import Entity.Tile.Unit;
import Resource_based.Resources.Energy;

import java.util.List;

public class FanOfKnives extends Ability {
    Rogue rog;
    Energy energy;
    int cost;
    public FanOfKnives(int cost,Rogue r){
        rog=r;
        energy=new Energy(100,cost);
        energy.setCur(energy.getMax());
        this.cost=cost;
    }
    @Override
    public String useAbility(List<Unit> ls) {
        if (!canUse())
            return rog.name+" can not use with ability, "+rog.name+" need more energy.\n";
        energy.setCur(energy.getCur()-cost);
        if (ls.size()==0)
            return rog.name+" used with ability but enemies no exist in your range.\n";
        StringBuilder output=new StringBuilder();
        for(Unit u: ls){
            output.append(u.receiveCast(this));
            }
        return output.toString();
    }
    public String attack(Enemy e) {
        int defRoll = (int) (Math.random() * e.def);
        if (rog.att > defRoll) {
            return e.injured(rog.att - defRoll, rog);
        }
        return e.name+" success to def the attack.\n";
    }
    public String attack(Player p){
        return "system but, you can not attack player";
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
       return energy.Tick(rog.name);
    }
}
