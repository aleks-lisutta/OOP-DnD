package Entity.Enemy;

import Entity.Tile.Tile;
import Entity.Tile.Unit;

public class Enemy extends Unit {
    int EXP;

    public Enemy(char c,int att, int def, int EXP,String name,int HP,int x,int y) {
        super(c,att,def,name,HP);
        this.EXP=EXP;
        setPos(x,y);
    }
    public void OnEnemyTurn(){}

    public String reciveMove(Enemy e) {
        return "";
    }


    public String accExp() {
        return "";
    }
}
