package Entity.Tile;

public abstract class Tile {
    public Pos pos;
    public char chr;

    public Tile(int x, int y){
        pos=new Pos(x,y);
    }
    public abstract String reciveMove(Unit u);
    public Integer getPosX(){
        return pos.x;
    }
    public Integer getPosY(){
        return pos.y;
    }
    public String toString(){
        return ""+chr;
    }
    public void setPos(int x, int y){
        pos=new Pos(x,y);
    }
}
