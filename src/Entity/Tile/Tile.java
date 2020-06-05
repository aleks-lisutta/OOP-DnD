package Entity.Tile;

public abstract class Tile {
    public Pos pos;
    public char chr;

    public Tile(char c){
        pos=new Pos(-1,-1);
        chr=c;
    }
    public Tile(char c,int x,int y){
        pos=new Pos(x,y);
        chr=c;
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
    public void setPos(Pos p){
        pos=new Pos(p.x,p.y);
    }
    public void swipPos(Tile t){
        Pos temp=pos;
        pos=t.pos;
        t.pos=temp;
    }
}
