package Resource_based.Abilities;

import Entity.Enemy.Bosses.Boss;
import Entity.Enemy.Enemy;
import Entity.Player.Player;
import Entity.Tile.Unit;

import java.util.List;

public class BossAbility {
    Boss b;
    public void SetBoss(Boss b){
        this.b=b;
    }
    public String useAbility(List<Unit> ls){
        StringBuilder output=new StringBuilder();
        for (Unit u: ls){
            output.append(u.receiveCast(this));
        }
        return output.toString();
    }
    public String attack(Player p){
        int defRoll = (int) (Math.random() * p.def);
        int attWar=p.att;
        if (attWar>defRoll)
            return p.injured(attWar-defRoll,b);
        return p.name+" success to def the attack.\n";
    }
}
