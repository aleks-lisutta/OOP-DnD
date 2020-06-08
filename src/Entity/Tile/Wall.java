package Entity.Tile;

import Entity.Enemy.Enemy;
import Entity.Player.Player;

public class Wall extends Tile {
    public Wall(){
        super('#');
    }

    @Override
    public boolean isDead(){
        return false;
    }
    public String reciveMove(Enemy e){
        return "";
    }
    public String reciveMove(Player p){
        return p.name+" tried to walk into a wall, nothing happened.\n";
    }
}
