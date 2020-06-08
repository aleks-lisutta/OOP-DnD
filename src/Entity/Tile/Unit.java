package Entity.Tile;

import Entity.Enemy.Enemy;
import Entity.Player.Player;
import Resource_based.Health;

import java.util.List;

public abstract class Unit extends Tile {
    public String name;
    public boolean isDead;
    public Health hp;
    public int att;
    public int def;

    public Unit(char c,int att, int def,String name,int HP){
        super(c);
        this.att=att;
        this.def=def;
        isDead=false;
        setHp(HP);
        this.name=name;
    }
    public abstract String move(Tile t) ;
    public String move(TileFrame t){
        return t.reciveMove(this);
    }
    public abstract String kill(Enemy e);


    public String def(Unit u){
        String out=u.name+" attacked "+name+"\n";
        int attRoll=(int)(Math.random()*u.att);
        int defRoll=(int)(Math.random()*def);
        if(attRoll>defRoll) {
            out+=u.name+" hit "+name+" dealing "+(attRoll-defRoll)+" damage.\n";
            hp.setCur(hp.getCur() - (attRoll - defRoll));
        }
        else{
            out+=name+" blocked the attack taking no damage.\n";
        }
        return out;
    }
    public String die(Unit u){
        isDead=true;
        return name+" died.\n";
    }
    public String action(char c){
        return frame.action(this,c);
    }
    public abstract String Tick(Player p);
    public void setHp(int n){
        hp=new Health(n);
    }
    @Override
    public boolean isDead(){
        return isDead;
    }
 //   public String getExp(Unit u){return u.accExp();}//////////////////////////////
 //   public abstract String accExp();/////////////////////////////

}
