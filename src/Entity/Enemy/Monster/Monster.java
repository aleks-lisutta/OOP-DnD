package Entity.Enemy.Monster;

import Entity.Enemy.Enemy;

import java.util.Random;

public class Monster extends Enemy {
    public int vision_range;
    public boolean lock;

    public Monster(char c,int att, int def, int EXP,String name,int HP,int v,int x,int y) {
        super(c,att,def,EXP,name,HP,x,y);
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
}
