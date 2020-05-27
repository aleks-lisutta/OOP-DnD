package Entity.Tile;

public abstract class Unit extends Tile {
    public String name;
    public int att;
    public int def;

    public Unit(int x, int y,  int att, int def){
        super(x,y);
        this.att=att;
        this.def=def;
    }
    public String move(Tile t){
        return t.reciveMove(this);
    }
}
