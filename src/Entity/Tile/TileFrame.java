package Entity.Tile;

import Entity.Heroic;
import GameControl.Board;

import java.util.LinkedList;
import java.util.List;

public class TileFrame {
    public Tile tile;
    protected final Pos pos;
    public final Board board;

    public Pos getPos() {
        return pos;
    }

    public TileFrame(Tile t, Pos p, Board b){
        tile=t;
        pos=p;
        board=b;
    }
    public String reciveMove(Unit u){
        String out=u.move(tile);
        if(tile.isDead() & tile.getChr()!='X'){
            tile=new Empty();
            tile.setFrame(this);
            tile.swapFrame(u);
        }
        return out;
    }


    public String move(Unit u,char c){
        List<TileFrame> targets=board.action(this,c);
        String out="";
        for (TileFrame tf : targets) {
            out+=u.move(tf);
        }
        return out;
    }


    public Board getBoard(){return board;}

    public Tile getTile(){return tile;}

    public void setTile(Tile t){
        tile=t;
    }
    public Integer getx(){return pos.getX();}
    public Integer gety(){return pos.getY();}
    @Override
    public String toString() {
        return tile.toString();
    }
}
