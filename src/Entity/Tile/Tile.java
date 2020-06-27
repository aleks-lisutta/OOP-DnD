package Entity.Tile;

import Entity.Enemy.Enemy;
import Entity.Player.Player;

public abstract class Tile {
    protected TileFrame frame=null;
    protected char chr;

    public void setChr(char chr) {
        this.chr = chr;
    }

    public TileFrame getFrame() {
        return frame;
    }

    public char getChr() {
        return chr;
    }



    public Tile(char c){
        chr=c;
    }
    public Tile(char c,TileFrame f){
        frame=f;
        chr=c;
    }
    public abstract String reciveMove(Enemy u);
    public abstract String reciveMove(Player u);
    public void setFrame(TileFrame f) {frame=f;}
    public String toString(){
        return ""+chr;
    }
    public abstract boolean isDead();
    public void swapFrame(Tile t){
        TileFrame tmp=frame;
        frame=t.getFrame();
        frame.setTile(this);
        t.setFrame(tmp);
        t.getFrame().setTile(t);
    }

}
