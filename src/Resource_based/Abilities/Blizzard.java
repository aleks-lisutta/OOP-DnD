package Resource_based.Abilities;

import Entity.Enemy.Enemy;
import Entity.Tile.Unit;
import Resource_based.Resources.Mana;

import java.util.List;
import java.util.Random;

public class Blizzard extends PlayerAbility {
    public Mana mana;
    int cost;
    int hitsCount;
    int spellPower;
    int lvl;
    public Blizzard(int M,int cost,int hit,int sp){
        mana=new Mana(M,cost);
        this.cost=cost;
        hitsCount=hit;
        spellPower=sp;
        lvl=1;
    }

    @Override
    public String useAbility(List<Unit> ls) {
        if (!canUse())
            return p.name+" can attack with ability more then "+" turns.\n";
        mana.use();
        if (ls.size()>0){
            int hits=0;
            StringBuilder output=new StringBuilder();
            output.append(p.name).append(" used with ability attack\n");
            while (ls.size()>0 & hits<hitsCount)
            {
                Unit u=ls.get(selectNumber(ls.size()));
                String check=u.receiveCast(this);
                if (check==null)
                {
                    ls.remove(u);
                }
                else {
                    output.append(check);
                    if (u.isDead())
                        ls.remove(u);
                    hits += 1;
                }
            }
            return output.toString();
        }
        return p.name+" used with ability but dont have enemies in his range.\n";
    }

    public String attack(Enemy e) {
        int defRoll = (int) (Math.random() * e.def);
        if (spellPower > defRoll) {
            String output=(e.injured(spellPower,p));
            return output;
        }
        return e.name+" success to def the attack.\n";
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
        lvl+=1;
        spellPower=spellPower+10*lvl;
    }

    @Override
    public String Tick() {
        return mana.Tick(p.name);
    }

    @Override
    public String toString(){
        return  "Mana: "+mana.getCur()+"/"+mana.getMax()+"."+(canUse()? " Blizzard available" : "");
    }
}
