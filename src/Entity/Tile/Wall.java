package Entity.Tile;

public class Wall extends Tile {
    public Wall(int x,int y){
        super('#');
        setPos(x,y);
    }
    @Override
    public String reciveMove(Unit u) {
        return u.name+" tried to walk into a wall, nothing happened.";
    }
    @Override
    public boolean isDead(){
        return false;
    }
}
