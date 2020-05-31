package Entity.Player;

import Entity.Heroic;
import Entity.Tile.Tile;
import Entity.Tile.Unit;

public abstract class Player extends Unit implements Heroic {
    public int exp;
    public int lvl;
    public int nextExp;


    public Player(int x, int y, int att, int def){
        super(x,y,att,def);
        chr='@';
        lvl=1;
        exp=0;
        nextExp=100;
    }
    public String move(Tile t){
        String output="player try to move.\n";
        output+=t.reciveMove(this);
        return output;

    }
}
