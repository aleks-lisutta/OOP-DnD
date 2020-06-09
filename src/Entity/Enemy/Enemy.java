package Entity.Enemy;

import Entity.Player.Player;
import Entity.Tile.*;

public abstract class Enemy extends Unit {
    public int EXP;

    public Enemy(char c, int att, int def, int EXP, String name, int HP) {
        super(c,att,def,name,HP);
        this.EXP=EXP;
    }
    public abstract String Turn(Player p);


    public String reciveMove(Enemy p) {
        return "";
    }
    public String move(Tile t){
        String out=t.reciveMove(this);
        return out;
    }

    public String reciveMove(Player p){
        String out=def(p);
        if(hp.getCur()<=0) {
            out+=die(p);
            out+=p.kill(this);
        }
        else{
            out+=name+" has "+hp.getCur()+"/"+hp.getMax()+" health left.\n";
        }
        return out;
    }

    public String kill(Enemy e){
        return name+" accidentally killed "+e.name;
    }

    public String Tick(){
        return ""; //override this in boss, dont override in monster or trap
    }
}
