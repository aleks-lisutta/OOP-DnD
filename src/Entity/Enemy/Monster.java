package Entity.Enemy;

import Entity.Player.Player;
import GameControl.Controller;
import GameControl.Utils;

import java.util.Random;

public class Monster extends Enemy {
    public int vision_range;

    public Monster(char c,int att, int def, int EXP,String name,int HP,int v) {
        super(c,att,def,EXP,name,HP);
        vision_range=v;
    }
    public char RandomMove(){
        Random red=new Random();
        switch (red.nextInt(4)){
            case 0: return Controller.UP;
            case 1:return Controller.RIGHT;
            case 2: return Controller.LEFT;
            case 3:return Controller.DOWN;
            default: return Controller.WAIT;
        }
    }
    private String hunt(Player p){
        String out="";
        double x=frame.pos.x-p.frame.pos.x;
        double y=frame.pos.y-p.frame.pos.y;
        if(Math.abs(x)<Math.abs(y)){
            if(y>0) out+=super.action(Controller.LEFT);
            else out+=super.action(Controller.RIGHT);
        }
        else{
            if(x>0) out+=super.action(Controller.UP);
            else out+=super.action(Controller.DOWN);
        }
        return out;
    }
    @Override // override again in boss
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
