package Resource_based.Abilities;
import Entity.Enemy.Enemy;
import Entity.Player.Player;
import Entity.Player.Warrior.Warrior;
import Entity.Tile.Unit;
import Resource_based.Resources.Cooldown;
import java.util.List;
import java.util.Random;

public class AvengersShield extends Ability {
    Warrior war;
    Cooldown cool;

    public AvengersShield(int a, Warrior p) {
        cool=new Cooldown(a);
        war=p;
    }

    @Override
    public String useAbility(List<Unit> ls) {
        if (!canUse())
            return war.name+" can attack with ability more then "+cool.getCur()+" turns.\n";
        cool.setCur(cool.getMax());
        if (ls.size()>0){
            Unit u=ls.get(selectNumber(ls.size()));
            return u.receiveCast(this);
        }
        return war.name+" used ability but no have enemies in " +war.name+ "'s range.\n";
    }

    public String attack(Enemy e){
        int defRoll = (int) (Math.random() * e.def);
        int attWar=(int)(0.1*war.hp.getMax());
        if (attWar>defRoll)
        {
            return (e.injured(attWar,war));
        }
        return e.name+" success to def the attack.\n";
    }
    public String attack(Player p){//boss
        return "system but, you can not attack player";
    }

    private int selectNumber(int a){
        Random r=new Random();
        return r.nextInt(a);
    }

    @Override
    protected boolean canUse() {
        return cool.getCur() == 0;
    }

    @Override
    public void LevelUp() {
        cool.LevelUp();
    }

    @Override
    public String Tick() {
         return cool.Tick(war.name);
    }


}
