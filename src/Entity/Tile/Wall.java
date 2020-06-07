package Entity.Tile;

import Entity.Player.Player;

public class Wall extends Tile {
    public Wall(){
        super('#');
    }

    @Override
    public String reciveMove(Unit u) {
        return u.name+" tried to walk into a wall, nothing happened.\n";
    }
    @Override
    public boolean isDead(){
        return false;
    }
}
