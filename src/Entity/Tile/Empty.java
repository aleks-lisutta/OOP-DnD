package Entity.Tile;

public class Empty extends Tile {

    public Empty(int x,int y){
        super('.');
        setPos(x,y);
    }
    @Override
    public String reciveMove(Unit u) {
        swipPos(u);
        return u.name+" walked to position "+u.pos;
    }
}
