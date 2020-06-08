package Entity.Tile;

import Entity.Enemy.Enemy;
import Entity.Player.Player;

public class Empty extends Tile {
    public static char CHR='.';
    public Empty(){
        super('.');

    }

    @Override
    public String reciveMove(Enemy e) {
        swapFrame(e);
        return "";

      //  swapFrame(u);
      //  return u.name+" walked to position "+u.frame.pos+"\n";
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
