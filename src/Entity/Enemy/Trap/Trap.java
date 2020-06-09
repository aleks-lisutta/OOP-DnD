package Entity.Enemy.Trap;

import Entity.Enemy.Enemy;
import Entity.Player.Player;
import Entity.Tile.Empty;
import Entity.Tile.Tile;
import Entity.Tile.TileFrame;
import Entity.Tile.Unit;
import GameControl.Utils;

import java.beans.Visibility;
import java.util.DoubleSummaryStatistics;

public abstract class Trap extends Enemy {
    public int tickCounter;
    public int visibility;
    public int inVisibility;
    public char chr2;
    public boolean visible;
    public Trap(char c, int att, int def, int EXP, String name, int HP) {
        super(c, att, def,EXP,name,HP);
        chr2= Empty.CHR;
        visible=true;
        tickCounter=1;
    }
    public void setUpVisibility(int a, int b){
        visibility=a;
        inVisibility=b;
    }

    public String attack(Player p){
        String output=" Range from "+p.name+" to "+name +" <2 , "+name+" attempting to attack " +p.name +"\n";
        return output+p.reciveMove(this);
    }
    public void swapChar(){
        char temp=chr;
        chr=chr2;
        chr2=temp;
    }
    public String reciveMove(Player p){
        return visible ? super.reciveMove(p) : p.name+" can not move to Tile in position:" +frame.pos+" there are a inVisibility Trap.";
    }

    @Override
    public String Turn(Player p) {
        if (Utils.RANGE(frame,p.frame)<3) {
            visible = true;
            tickCounter = 0;
            return attack(p);
        }
        return setStatus();
    }
    public String setStatus(){
        if (visible &tickCounter>visibility){
            tickCounter=tickCounter-visibility;
            visible=false;
            swapChar();
            return  name+" changed Position, now "+name+ " is inVisibility. \n";
        }
        else if (!visible & tickCounter>inVisibility)
        {
            tickCounter=tickCounter-inVisibility;
            visible=true;
            swapChar();
            return  name+" changed Position, now "+name+ " is Visibility. \n";
        }
        tickCounter+=1;
        return "";
    }
}
