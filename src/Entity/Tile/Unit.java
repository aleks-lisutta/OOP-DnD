package Entity.Tile;

import Resource_based.Health;

public abstract class Unit extends Tile {
    public String name;
    public boolean isDead;
    public Health hp;
    public int att;
    public int def;

    public Unit(char c,int att, int def,String name,int HP){
        super(c);
        this.att=att;
        this.def=def;
        isDead=false;
        setHp(HP);
        this.name=name;
    }
    public String move(Tile t){
        return t.reciveMove(this);
    }

    @Override
    public String reciveMove(Unit u) {
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
        if(hp.getCur()==0) {
            out+=die(u);
        }
        else{
            out+=name+" has "+hp.getCur()+"/"+hp.getMax()+" health left.\n";
        }
        return out;
    }
    protected String die(Unit u){
        isDead=true;
        swapPos(u);
        return name+" died.";
    }
    public void setHp(int n){
        hp=new Health(n);
    }
    @Override
    public boolean isDead(){
        return isDead;
    }
 //   public String getExp(Unit u){return u.accExp();}//////////////////////////////
 //   public abstract String accExp();/////////////////////////////
}
