package Entity.Tile;

import Entity.Player.Player;

public class Empty extends Tile {
    public static char CHR='.';
    public Empty(){
        super('.');

    }

    @Override
    public String reciveMove(Unit u) {
        swapFrame(u);
        return u.name+" walked to position "+u.frame.pos+"\n";
    }
    @Override
    public boolean isDead(){
        return false;
    }
}
