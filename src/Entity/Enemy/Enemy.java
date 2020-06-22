package Entity.Enemy;

import Entity.Player.Player;
import Entity.Tile.*;
import Resource_based.Abilities.Ability;

public abstract class Enemy extends Unit {
    public int EXP;

    public Enemy(char c, int att, int def, int EXP, String name, int HP) {
        super(c,att,def,name,HP);
        this.EXP=EXP;
    }
    public abstract String Turn(Player p);


    public String reciveMove(Enemy p) {
        return "";
    }
    public String move(Tile t){
        String out=t.reciveMove(this);
        return out;
    }

    public String reciveMove(Player p){
        String out=def(p);
        if(hp.getCur()<=0) {
            out+=die(p);
            out+=p.kill(this);
        }
        else{
            out+=name+" has "+hp.getCur()+"/"+hp.getMax()+" health left.\n";
        }
        return out;
    }
    public void abilityKill(){//we need to check that the controller remove the enemy from list.
        Tile t=new Empty();
        frame.setTile(t);
        t.setFrame(frame);
    }

    public String injured(int cost,Player p){
        hp.setCur(hp.getCur()-cost);
        StringBuilder output=new StringBuilder();
        output.append(p.name).append(" hit with his ability ").append(name).append(" dealing ").append(cost).append(" damage.\n");

        if (hp.getCur()==0){
            isDead=true;
            output.append(p.name).append(" kill ").append(name).append("\n");
            output.append(p.kill(this));
            abilityKill();
            return output.toString();
        }
        output.append( name).append(" has ").append(hp.getCur()).append("/").append(hp.getMax()).append(" hp left.\n");
        return output.toString();
    }

    public  String receiveCast(Ability a){
        return a.attack(this);
    }



    public String kill(Enemy e){
        return name+" accidentally killed "+e.name+".\n";
    }

    public String Tick(){
        return ""; //override this in boss, dont override in monster or trap
    }
}
