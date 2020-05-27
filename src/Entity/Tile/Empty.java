package Entity.Tile;

public class Empty extends Tile {
    public Empty(int x, int y){
        super(x,y);
        chr='.';
    }
    @Override
    public String reciveMove(Unit u) {
        Pos t=u.pos;
        u.pos=pos;
        pos=t;
        return u.name+" walked to position "+u.pos;
    }
}
