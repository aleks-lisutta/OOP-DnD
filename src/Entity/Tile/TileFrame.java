package Entity.Tile;

public class TileFrame {
    public Tile tile;
    public TileFrame(Tile t){
        tile=t;
    }
    public Tile getTile(){return tile;}
    public void setTile(Tile t){
        tile=t;
    }
}
