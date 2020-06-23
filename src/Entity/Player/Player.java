package Entity.Player;

import Entity.Enemy.Bosses.Boss;
import Entity.Enemy.Enemy;
import Entity.Heroic;
import Entity.Tile.*;
import GameControl.Utils;
import Resource_based.Abilities.BossAbility;
import Resource_based.Abilities.PlayerAbility;

import java.util.LinkedList;
import java.util.List;

public abstract class Player extends Unit implements Heroic {
    public int exp;
    public int lvl;
    public int nextExp;
    protected int range;
    protected  PlayerAbility ability;

    public Player(int att, int def, String name, int HP,int range,PlayerAbility ability){
        super('@',att,def,name,HP);
        ability.setPlayer(this);
        lvl=1;
        exp=0;
        nextExp=100;
        this.range=range;
        this.ability=ability;
    }

    public String levelUp(){
        exp=exp-(nextExp);
        lvl+=1;
        setUpAbilityLevel();
        setUpNextLevel();
        return name+" level up to "+lvl+ ".\n details: \n Attack: "+att+" \n Defense: "+def +"\n exp: "+exp
                +"\n next level at: "+nextExp+"\n";
    }
    public String move(Tile t){
        String output=name+" tried to move to position "+t.frame.pos+".\n";
        output+=t.reciveMove(this);
        return output;
    }

    public String die(Unit u){
        chr='X';
        return super.die(u);
    }
    public boolean isDead(){
        return false;
    }
    @Override
    public String reciveMove(Enemy e) {
        String out=def(e);
        if(hp.getCur()<=0) {
            out+=die(e);

        }
        else{
            out+=name+" has "+hp.getCur()+"/"+hp.getMax()+" health left.\n";
        }
        return out;
    }
    public String reciveMove(Player p){
        throw new IllegalArgumentException("the Function acceptUnit is not good");
    }

    public String cast(List<Unit> ls) {
        return ability.useAbility(ls);
    }
    private void setUpNextLevel(){
        nextExp=lvl*50;
    }
    public void setUpAbilityLevel() {
        att = 4 * lvl + att;
        def = lvl + def;
        hp.levelUpHP(lvl);
        levelUpSpacialAbility();
    }
    public void levelUpSpacialAbility(){
        ability.LevelUp();
    }
    public String checkLevelUp(){
        return (exp>=nextExp)? levelUp() : "";
    }

    public String kill(Enemy e){
        exp+=e.EXP;
        String out=name+" gained "+e.EXP+" experience from killing "+e.name+".\n";
        out+=checkLevelUp();
        return out;
    }

    private boolean isMove(char c){
        return c=='a'|c=='s'|c=='d'|c=='q'|c=='w';
    }


    public String action(char c, List<Enemy> L){
        if(isMove(c)) return  super.action(c);
        else{
            List<Unit> inRange=new LinkedList<>();
            for (Enemy e : L){
                if (Utils.RANGE(this.frame, e.frame)<=range)
                    inRange.add(e);
            }
            String out=cast(inRange);
            out+=Tick();
            return out;
        }
    }
    public String receiveCast(BossAbility a) {
      return a.attack(this);
    }
    public String receiveCast(PlayerAbility a) {
        return "no PVP implemented yet";
    }
    public String Tick(){
        return ability.Tick();
    }

    public String injured(int cost,Boss b){
        hp.setCur(hp.getCur()-cost);
        StringBuilder output=new StringBuilder();
        output.append(b.name).append(" hit with his ability ").append(name).append(" dealing ").append(cost).append(" damage.\n");
        if (hp.getCur()==0){
            isDead=true;////
            output.append(b.name).append(" kill ").append(name).append("\n");
            output.append(die(b));
            return output.toString();
        }
        output.append( name).append(" has ").append(hp.getCur()).append("/").append(hp.getMax()).append(" hp left.\n");
        return output.toString();
    }
}
