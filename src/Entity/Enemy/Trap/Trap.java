package Entity.Enemy.Trap;

import Entity.Enemy.Enemy;
import Entity.Tile.Tile;
import Entity.Tile.Unit;

import java.util.DoubleSummaryStatistics;

public abstract class Trap extends Enemy {
    public int now;
    public int visibility;
    public int inVisibility;
    public char chr2;
    public boolean visible;
    public Trap(char c,int att, int def, int EXP,String name,int HP,int x,int y) {
        super(c, att, def,EXP,name,HP,x,y);
        chr2='.';
        visible=true;
    }
    public void setUpVisibility(int a, int b){
        visibility=a;
        inVisibility=b;
    }
    public String SetStatus(){
        now+=1;
        if (visible &now>visibility){
            now=now-visibility;
            visible=false;
            swipChar();
            return  name+" changed Position, now "+name+ " is inVisibility.";
        }
        else if (!visible & now>inVisibility)
        {
            now=now-inVisibility;
            visible=true;
            swipChar();
            return  name+" changed Position, now "+name+ " is Visibility.";
        }
        return "";
    }
    public String move(Tile a){
        return SetStatus();
    }
    public void swipChar(){
        char temp=chr;
        chr=chr2;
        chr2=temp;
    }
    public String reciveMove(Unit u){
        return visible ? super.reciveMove(u) : u.name+" can not move to Tile in position:" +pos+" there are a inVisibility Trap.";
    }

}
