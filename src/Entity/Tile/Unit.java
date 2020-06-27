package Entity.Tile;

import Entity.Enemy.Enemy;
import Resource_based.Abilities.BossAbility;
import Resource_based.Abilities.PlayerAbility;
import Resource_based.Resources.Health;

public abstract class Unit extends Tile {
    protected String name;
    public boolean isDead;//for testing this is public
    protected Health hp;
    protected int att;

    public void setAtt(int att) {
        this.att = att;
    }

    public void setDef(int def) {
        this.def = def;
    }

    protected int def;

    public String getName(){
        return name;
    }

    public Health getHp() {
        return hp;
    }

    public int getAtt() {
        return att;
    }

    public int getDef() {
        return def;
    }

    public Unit(char c, int att, int def, String name, int HP){
        super(c);
        this.att=att;
        this.def=def;
        isDead=false;
        setHp(HP);
        this.name=name;
    }
    public abstract String move(Tile t) ;
    public String move(TileFrame t){
        return t.reciveMove(this);
    }
    public abstract String kill(Enemy e);

    public String def(Unit u){
        String out=u.name+" attacked "+name+"\n";
        int attRoll=(int)(Math.random()*u.att);
        int defRoll=(int)(Math.random()*def);
        if(attRoll>defRoll) {
            out+=u.name+" hit "+name+" dealing "+(attRoll-defRoll)+" damage.\n";
            hp.setCur(hp.getCur() - (attRoll - defRoll));
        }
        else{
            out+=name+" blocked the attack taking no damage.\n";
        }
        return out;
    }
    public String die(Unit u){
        isDead=true;
        return name+" died.\n";
    }
    public String action(char c){
        String out=frame.move(this,c);
        return out;
    }
    public void setHp(int n){
        hp=new Health(n);
    }
    @Override
    public boolean isDead(){
        return isDead;
    }
    public abstract String receiveCast(BossAbility a);
    public abstract String receiveCast(PlayerAbility a);

    public abstract void Tick(); //implement in each player differently




}
