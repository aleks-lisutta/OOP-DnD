package Entity.Tile;

import Entity.Player.Player;
import GameControl.Board;

public abstract class Tile {
    public TileFrame frame=null;
    public char chr;

    public Tile(char c){
        chr=c;
    }
    public Tile(char c,TileFrame f){
        frame=f;
        chr=c;
    }


    public abstract String reciveMove(Unit u);
    public void setFrame(TileFrame f) {frame=f;}
    public String toString(){
        return ""+chr;
    }
    public abstract boolean isDead();
    public void swapFrame(Tile t){
        TileFrame tmp=frame;
        frame=t.frame;
        frame.setTile(this);
        t.setFrame(tmp);
        t.frame.setTile(t);
    }
}
