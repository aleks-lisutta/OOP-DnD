package Entity.Enemy;

import Entity.Player.Player;
import Entity.Tile.Tile;
import Entity.Tile.TileFrame;
import Entity.Tile.Unit;

public abstract class Enemy extends Unit {
    public int EXP;

    public Enemy(char c, int att, int def, int EXP, String name, int HP) {
        super(c,att,def,name,HP);
        this.EXP=EXP;
    }
    public void OnEnemyTurn(){}

    public String accExp() {
        return "";
    }

    public String reciveMove(Unit p) {
        String out=super.reciveMove(p);
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

}
