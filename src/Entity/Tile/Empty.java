package Entity.Tile;

import Entity.Enemy.Enemy;
import Entity.Player.Player;

public class Empty extends Tile {
    public static final char CHR='.';
    public Empty(){
        super(CHR);

    }

    @Override
    public String reciveMove(Enemy e) {
        swapFrame(e);
        return "";
    }
    public String reciveMove(Player p) {
        swapFrame(p);
        return p.name+" walked to position "+p.frame.pos+"\n";
    }

    @Override
    public boolean isDead(){
        return false;
    }
}
