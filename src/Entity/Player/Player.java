package Entity.Player;

import Entity.Heroic;
import Entity.Tile.Tile;
import Entity.Tile.Unit;

public abstract class Player extends Unit implements Heroic {
    public int exp;
    public int lvl;
    public int nextExp;


    public Player(int att, int def,String name, int HP){
        super('@',att,def,name,HP);
        lvl=1;
        exp=0;
        nextExp=100;
    }
    public String levelUp(){
        exp=exp-(nextExp);
        lvl+=1;
        setUpAbilityLevel();
        String output=name+" level up to "+lvl+ ", details: \n Attack: "+att+"     Defense: "+def +"exp: "+exp
                +" exp to next level: "+nextExp+"\n";
        setUpNextLevel();
        return output;
    }
    public String move(Tile t){
        String output=name+" tried to move to position "+t.pos+".\n";
        output+=t.reciveMove(this);
        output+=checkLevelUp();
        return output;
    }
    protected String die(Unit u){
        chr='X';
        return super.die(u);
    }
    private void setUpNextLevel(){
        nextExp=lvl*50;
    }
    public void setUpAbilityLevel() {
        att = 4 * lvl + att;
        def = lvl + def;
        hp.levelUpHP(hp.getMax());
    }
    public String checkLevelUp(){
        return (exp>=nextExp)? levelUp() : "";
    }
}
