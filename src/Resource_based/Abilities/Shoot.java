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

public class Shoot extends Ability {
    Arrows arr;
    Hunter hun;
    public Shoot(Hunter h){
        hun=h;
        arr=new Arrows(10*hun.lvl);
        arr.setCur(arr.getMax());
    }
    @Override
    public String useAbility(List<Unit> ls) {
        if (!canUse())
            return hun.name+" does not have a arrows.\n";
        if (ls.size()==0)
            return "does not exist enemies in his range.\n";
        Unit u=selectClosest(ls);

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
        if (hun.att>defRoll){
            return e.injured(hun.att-defRoll, hun);
        }
        return e.name+" success to def the attack.\n";
    }
    public String attack(Player p){
        return "system but, you can not attack player";
    }
    private Unit selectClosest(List<Unit> units){
        Unit output=units.get(0);
        double MinRange=Utils.RANGE(output.frame,hun.frame);
        if (MinRange==1)
            return output;
        for (Unit u: units){
            double range=Utils.RANGE(u.frame,hun.frame);
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
        return arr.Tick(hun.name);
    }
}
