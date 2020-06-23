package Resource_based.Abilities;

import Entity.Enemy.Enemy;
import Entity.Player.Hunter.Hunter;
import Entity.Player.Player;
import Entity.Tile.Unit;
import GameControl.Utils;
import Resource_based.Resources.Arrows;


import java.util.List;
import java.util.Random;
import java.util.function.DoubleToIntFunction;

public class Shoot extends PlayerAbility {
    Arrows arr;
    public Shoot(){
        arr=new Arrows(10);
        arr.setCur(arr.getMax());
    }
    @Override
    public String useAbility(List<Unit> ls) {
        if (!canUse())
            return p.name+" does not have a arrows.\n";
        if (ls.size()==0)
            return "does not exist enemies in his range.\n";
        Unit u=selectClosest(ls,p);

        String output=u.receiveCast(this);
        if (output==null){
            ls.remove(u);
            return useAbility(ls);
        }
        arr.use();
        return u.receiveCast(this);
    }
    public String attack(Enemy e){
        int defRoll = (int) (Math.random() * e.def);
        if (p.att>defRoll){
            return e.injured(p.att-defRoll, p);
        }
        return e.name+" success to def the attack.\n";
    }
    private Unit selectClosest(List<Unit> units,Player p){
        Unit output=units.get(0);
        double MinRange=Utils.RANGE(output.frame,p.frame);
        if (MinRange==1)
            return output;
        for (Unit u: units){
            double range=Utils.RANGE(u.frame,p.frame);
            if (range==1)
                return u;
            if (range<MinRange)
            {
                MinRange=range;
                output=u;
            }
        }
        return output;
    }

    @Override
    protected boolean canUse() {
        return arr.getCur()>0;
    }

    @Override
    public void LevelUp() {
        arr.LevelUp();
    }

    @Override
    public String Tick() {
        return arr.Tick(p.name);
    }
}
