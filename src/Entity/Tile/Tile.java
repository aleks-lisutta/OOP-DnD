package Entity.Tile;

public abstract class Tile {
    public Pos pos;
    public char chr;

    public Tile(int x, int y){
        pos=new Pos(x,y);
    }
    public abstract String reciveMove(Unit u);
}
