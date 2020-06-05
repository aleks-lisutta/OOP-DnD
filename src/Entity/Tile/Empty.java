package Entity.Tile;

public class Empty extends Tile {
    public static char CHR='.';
    public Empty(int x,int y){
        super('.');
        setPos(x,y);
    }
    @Override
    public String reciveMove(Unit u) {
        swapPos(u);
        return u.name+" walked to position "+u.pos;
    }
    @Override
    public boolean isDead(){
        return false;
    }
}
