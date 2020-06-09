package Entity.Tile;

import Entity.Heroic;
import GameControl.Board;

import java.util.LinkedList;
import java.util.List;

public class TileFrame {
    public Tile tile;
    public final Pos pos;
    public final Board board;
    public TileFrame(Tile t, Pos p, Board b){
        tile=t;
        pos=p;
        board=b;
    }
    public String reciveMove(Unit u){
        String out=u.move(tile);
        if(tile.isDead()){
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

    public String cast(Heroic h,char c){
        List<TileFrame> TF =board.action(this,c);
        List<Tile> targets=new LinkedList<>();
        String out="";
        for(TileFrame tf: TF){
            targets.add(tf.tile);
        }
        out+=h.cast(targets);

        return out;
    }

    public Board getBoard(){return board;}

    public Tile getTile(){return tile;}
    public void setTile(Tile t){
        tile=t;
    }
    public Integer getx(){return pos.x;}
    public Integer gety(){return pos.y;}
    @Override
    public String toString() {
        return tile.toString();
    }
}
