package Resource_based.Abilities;
import Entity.Enemy.Enemy;
import Entity.Player.Player;
import Entity.Player.Warrior.Warrior;
import Entity.Tile.Unit;
import Resource_based.Resources.Cooldown;
import java.util.List;
import java.util.Random;

public class AvengersShield extends PlayerAbility {
    Cooldown cool;

    public AvengersShield(int a) {
        cool=new Cooldown(a);
    }

    @Override
    public String useAbility(List<Unit> ls ) {
        if (!canUse())
            return p.name+" can attack with ability more then "+cool.getCur()+" turns.\n";
        if (ls.size()>0){
            Unit u=ls.get(selectNumber(ls.size()));
            String output=u.receiveCast(this);
            if (output==null){
                ls.remove(u);
                return useAbility(ls);
            }
            cool.setCur(cool.getMax());
            return output;
        }
        cool.setCur(cool.getMax());
        return p.name+" used ability but no have enemies in " +p.name+ "'s range.\n";
    }

    public String attack(Enemy e){
        int defRoll = (int) (Math.random() * e.def);
        int attWar=(int)(0.1*p.hp.getMax());
        if (attWar>defRoll)
        {
            return (e.injured(attWar,p));
        }
        return e.name+" success to def the attack.\n";
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
         return cool.Tick(p.name);
    }


}
