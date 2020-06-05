package Entity.Tile;

public class TileFrame {
    public Tile tile;
    public Pos pos;
    public TileFrame(Tile t, Pos p){
        tile=t;
        pos=p;
    }
    public String reciveMove(Unit u){
        String out= u.move(tile);
        if(tile.isDead()) tile=new Empty(tile.getPosX(),tile.getPosY());
        return out;
    }
    public Tile getTile(){return tile;}
    public void setTile(Tile t){
        tile=t;
    }

    @Override
    public String toString() {
        return tile.toString();
    }
}
