package Entity.Enemy;

import Entity.Heroic;
import Entity.Player.Player;
import Entity.Tile.Unit;
import GameControl.Utils;
import Resource_based.Abilities.BossAbility;

import java.util.LinkedList;
import java.util.List;

public class Boss extends Monster implements Heroic {
    BossAbility ability;
    int frequency;
    int tick;
    public Boss(char c, int att, int def, int EXP, String name, int HP, int v,int f) {
        super(c, att, def, EXP, name, HP, v);
        frequency=f;
        tick=0;
        ability=new BossAbility();
        ability.SetBoss(this);
    }


    @Override
    public String cast(List<Unit> ls) {
        if (ls==null)
            throw  new IllegalArgumentException("boss accept null");
        if (ls.size()>0) {
            tick=0;
            return ability.useAbility(ls);
        }
        return "";
    }
    public String Turn(Player p){
        if(Utils.RANGE(p.frame,this.frame)<vision_range & tick==frequency){
            List<Unit> u=new LinkedList<>();
            u.add(p);
            String output=cast(u);
            Tick();
            return output;
        }
        return super.Turn(p);
    }

    public String Tick(){
        if (tick<frequency)
            tick++;
        return "";
    }

}
