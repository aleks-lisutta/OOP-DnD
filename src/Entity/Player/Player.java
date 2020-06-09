package Entity.Player;

import Entity.Enemy.Enemy;
import Entity.Heroic;
import Entity.Tile.*;
import Resource_based.Resources.Resource;

import java.util.List;

public abstract class Player extends Unit implements Heroic {
    public int exp;
    public int lvl;
    public int nextExp;


    public Player(int att, int def, String name, int HP){
        super('@',att,def,name,HP);
        lvl=1;
        exp=0;
        nextExp=100;
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
    }
    public String checkLevelUp(){
        return (exp>=nextExp)? levelUp() : "";
    }

    public String kill(Enemy e){
        exp+=e.EXP;
        String out=name+" gained "+e.EXP+" experience from killing "+e.name+".\n";
        out+=checkLevelUp();
        return out;
    }

}
