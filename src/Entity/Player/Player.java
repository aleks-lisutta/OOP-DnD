package Entity.Player;

import Entity.Enemy.Enemy;
import Entity.Heroic;
import Entity.Tile.*;
import GameControl.Utils;
import Resource_based.Abilities.Ability;
import Resource_based.Resources.Resource;

import java.util.LinkedList;
import java.util.List;

public abstract class Player extends Unit implements Heroic {
    public int exp;
    public int lvl;
    public int nextExp;
    protected int range;


    public Player(int att, int def, String name, int HP,int range){
        super('@',att,def,name,HP);
        lvl=1;
        exp=0;
        nextExp=100;
        this.range=range;
    }

    public String levelUp(){
        exp=exp-(nextExp);
        lvl+=1;
        setUpAbilityLevel();
        String output=name+" level up to "+lvl+ ".\n details: \n Attack: "+att+" \n Defense: "+def +"\n exp: "+exp
                +"\n next level at: "+nextExp+"\n";
        setUpNextLevel();
        return output;
    }
    public String move(Tile t){
        String output=name+" tried to move to position "+t.frame.pos+".\n";
        output+=t.reciveMove(this);
        return output;
    }

    public String die(Unit u){
        chr='X';
        return super.die(u);
    }
    public boolean isDead(){
        return false;
    }
    @Override
    public String reciveMove(Enemy e) {
        String out=def(e);
        if(hp.getCur()<=0) {
            out+=die(e);

        }
        else{
            out+=name+" has "+hp.getCur()+"/"+hp.getMax()+" health left.\n";
        }
        return out;
    }
    public String reciveMove(Player p){
        throw new IllegalArgumentException("the Function acceptUnit is not good");
    }

    private void setUpNextLevel(){
        nextExp=lvl*50;
    }
    public void setUpAbilityLevel() {
        att = 4 * lvl + att;
        def = lvl + def;
        hp.levelUpHP(lvl);
        levelUpSpacialAbility();
    }
    public abstract void levelUpSpacialAbility();
    public String checkLevelUp(){
        return (exp>=nextExp)? levelUp() : "";
    }

    public String kill(Enemy e){
        exp+=e.EXP;
        String out=name+" gained "+e.EXP+" experience from killing "+e.name+".\n";
        out+=checkLevelUp();
        return out;
    }

    private boolean isMove(char c){
        return c=='a'|c=='s'|c=='d'|c=='q'|c=='w';
    }


    public String action(char c, List<Enemy> L){
        if(isMove(c)) return  super.action(c);
        else{
            List<Unit> inRange=new LinkedList<>();
            for (Enemy e : L){
                if (Utils.RANGE(this.frame, e.frame)<=range)
                    inRange.add(e);
            }
            String out=cast(inRange);
            out+=Tick();
            return out;
        }
    }
    public String receiveCast(Ability a){
        return "";
    }

}
