package Entity.Tile;

public class Wall extends Tile {
    public Wall(int x, int y){
        super(x,y);
        chr='#';
    }
    @Override
    public String reciveMove(Unit u) {
        return u.name+" tried to walk into a wall, nothing happened.";
    }
}
