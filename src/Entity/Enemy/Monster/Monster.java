package Entity.Enemy.Monster;

import Entity.Enemy.Enemy;
import Entity.Player.Player;
import Entity.Tile.Tile;
import Entity.Tile.TileFrame;
import GameControl.Utils;

import java.util.List;
import java.util.Random;

public abstract class Monster extends Enemy {
    public int vision_range;
    public boolean lock;

    public Monster(char c,int att, int def, int EXP,String name,int HP,int v) {
        super(c,att,def,EXP,name,HP);
        vision_range=v;
    }
    public char RandomMove(){
        Random red=new Random();
        switch (red.nextInt(4)){
            case 0: return 'w';
            case 1:return 'd';
            case 2: return 'a';
            case 3:return 's';
            default: return 'q';
        }
    }
    private String hunt(Player p){
        String out="";
        double x=frame.pos.x-p.frame.pos.x;
        double y=frame.pos.y-p.frame.pos.y;
        if(Math.abs(x)<Math.abs(y)){
            if(y>0) out+=super.action('a');
            else out+=super.action('d');
        }
        else{
            if(x>0) out+=super.action('w');
            else out+=super.action('s');
        }
        return out;
    }
    @Override
    public String Turn(Player p) {
        String out="";
        if(Utils.RANGE(p.frame,this.frame)<vision_range){
            out+=hunt(p);
        }
        else{
            char c=RandomMove();
            out+=super.action(c);
        }
        return out;
    }
}
