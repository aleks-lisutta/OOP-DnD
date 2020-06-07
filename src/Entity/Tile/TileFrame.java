package Entity.Tile;

import GameControl.Board;

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
    private boolean isMove(char c){
        return c=='a'|c=='s'|c=='d'|c=='w';
    }
    public String action(Unit u,char c){
        List<TileFrame> targets=board.action(this,c);
        String out="";
        if(isMove(c)) {
            for (TileFrame tf : targets) {
                out+=u.move(tf);
            }
        }
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
