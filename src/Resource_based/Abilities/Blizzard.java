package Resource_based.Abilities;

import Entity.Enemy.Enemy;
import Entity.Player.Mages.Mage;
import Entity.Player.Player;
import Entity.Tile.Unit;
import Resource_based.Resources.Mana;

import java.util.List;
import java.util.Random;

public class Blizzard extends Ability {
    public Mage mage;
    public Mana mana;
    int cost;
    int hitsCount;
    int spellPower;
    public Blizzard(Mage m,int M,int cost,int hit,int sp){
        mage=m;
        mana=new Mana(M,cost);
        this.cost=cost;
        hitsCount=hit;
        spellPower=sp;
    }

    @Override
    public String useAbility(List<Unit> ls) {
        if (!canUse())
            return mage.name+" can attack with ability more then "+" turns.\n";
        mana.use();
        if (ls.size()>0){
            int hits=0;
            StringBuilder output=new StringBuilder();
            output.append(mage.name).append(" used with ability attack\n");
            while (ls.size()>0 & hits<hitsCount)
            {
                Unit u=ls.get(selectNumber(ls.size()));
                output.append(u.receiveCast(this));
                if (u.isDead())
                    ls.remove(u);
                hits+=1;
            }
            return output.toString();
        }
        return mage.name+" used with ability but dont have enemies in his range.\n";
    }

    public String attack(Enemy e) {
        int defRoll = (int) (Math.random() * e.def);
        if (spellPower > defRoll) {
            String output=(e.injured(spellPower,mage));
            return output;
        }
        return e.name+" success to def the attack.\n";
    }
    public String attack(Player p){//boss
        return "system bug, you cant attack player.";
    }

    private int selectNumber(int a){
        Random r=new Random();
        return r.nextInt(a);
    }

    @Override
    protected boolean canUse() {
        return mana.getCur()>=cost;
    }

    @Override
    public void LevelUp() {
        mana.LevelUp();
        spellPower=spellPower+10*mage.lvl;
    }

    @Override
    public String Tick() {
        return mana.Tick(mage.name);
    }
}
