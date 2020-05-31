package Entity.Tile;

import Resource_based.Health;

public abstract class Unit extends Tile {
    public String name;
    public Health hp;
    public int att;
    public int def;

    public Unit(int x, int y,  int att, int def){
        super(x,y);
        this.att=att;
        this.def=def;
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
        if(hp.getCur()==0) {
            out+=die();
        }
        return out;
    }
    protected String die(){
        chr='X';
        return name+" died.";
    }
}
