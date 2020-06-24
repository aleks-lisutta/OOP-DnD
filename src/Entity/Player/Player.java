package Entity.Player;

import Entity.Enemy.Bosses.Boss;
import Entity.Enemy.Enemy;
import Entity.Heroic;
import Entity.Tile.*;
import GameControl.Controller;
import GameControl.Utils;
import Resource_based.Abilities.BossAbility;
import Resource_based.Abilities.PlayerAbility;

import java.util.LinkedList;
import java.util.List;

public abstract class Player extends Unit implements Heroic {
    private static final char DEFAULT_CHAR='@';
    private static final char DEAD_CHAR='X';
    private static final int START_NEXT_EXP=100;
    private static final int NEXT_EXP_MODIFIER=50;
    private static final int ATT_MODIFIER=4;
    private static final int DEF_MODIFIER=1;
    public int exp;
    public int lvl;
    public int nextExp;
    protected int range;
    protected  PlayerAbility ability;

    public Player(int att, int def, String name, int HP,int range,PlayerAbility ability){
        super(DEFAULT_CHAR,att,def,name,HP);
        ability.setPlayer(this);
        lvl=1;
        exp=0;
        nextExp=START_NEXT_EXP;
        this.range=range;
        this.ability=ability;
    }

    public String levelUp(){
        String out="";
        while(exp>=nextExp){
            exp=exp-(nextExp);
            lvl+=1;
            setUpAbilityLevel();
            setUpNextLevel();
            out+="\n--------------------------------------\n"+name+" leveled up to level: "+lvl+ ".\n details: \n Attack: "+att+" \n Defense: "+def +"\n exp: "+exp
                    +"\n next level at: "+nextExp+"\n--------------------------------------\n";
        }
        return out;
    }
    public String move(Tile t){
        String output=name+" tried to move to position "+t.frame.pos+".\n";
        output+=t.reciveMove(this);
        return output;
    }

    public String die(Unit u){
        chr=DEAD_CHAR;
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
        throw new IllegalArgumentException("PVP is not yet supported.\n");
    }

    public String cast(List<Unit> ls) {
        return ability.useAbility(ls);
    }
    private void setUpNextLevel(){
        nextExp=lvl*NEXT_EXP_MODIFIER;
    }
    public void setUpAbilityLevel() {
        att = ATT_MODIFIER * lvl + att;
        def = DEF_MODIFIER*lvl + def;
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
        return c== Controller.LEFT|c==Controller.DOWN|c==Controller.RIGHT|c==Controller.UP|c==Controller.WAIT;
    }


    public String action(char c, List<Enemy> L){
        if(isMove(c)) return  super.action(c);
        else if(c==Controller.ABILITY){
            List<Unit> inRange=new LinkedList<>();
            for (Enemy e : L){
                if (Utils.RANGE(this.frame, e.frame)<=range)
                    inRange.add(e);
            }
            String out=cast(inRange);
            out+=Tick();
            return out;
        }
        else return "illegal action please try again.\n";
    }
    public String receiveCast(BossAbility a) {
      return a.attack(this);
    }
    public String receiveCast(PlayerAbility a) {
        return "PVP is not yet supported.\n";
    }
    public String Tick(){
        return ability.Tick();
    }

    public String injured(int cost,Boss b){
        hp.setCur(hp.getCur()-cost);
        StringBuilder output=new StringBuilder();
        output.append(b.name).append(" hit ").append(name).append(" with his ability, dealing ").append(cost).append(" damage.\n");
        if (hp.getCur()==0){
            isDead=true;////
            output.append(b.name).append(" kill ").append(name).append("\n");
            output.append(die(b));
            return output.toString();
        }
        output.append( name).append(" has ").append(hp.getCur()).append("/").append(hp.getMax()).append(" hp left.\n");
        return output.toString();
    }

    public String stats(){
        StringBuilder out=new StringBuilder();
        out.append("Name: ").append(name).append("\nHealth: ").append(hp.getCur()).append("/").append(hp.getMax()).append("\nLevel: ");
        out.append(lvl).append("\nExperience: ").append(exp).append("\nAttack: ").append(att).append("\nDefence: ").append(def).append("\n").append(ability.toString());
        return out.toString();
    }
}
