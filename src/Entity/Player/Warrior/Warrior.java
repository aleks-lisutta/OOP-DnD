package Entity.Player.Warrior;

import Entity.Player.Player;
import Entity.Tile.Tile;
import Entity.Tile.Unit;
import GameControl.Utils;
import Resource_based.Abilities.AvengersShield;


import java.util.LinkedList;
import java.util.List;
import java.util.function.DoubleToIntFunction;

public abstract class Warrior extends Player {
    AvengersShield ability;

    public Warrior(int att,int def,String name, int HP,int ab){
        super(att,def,name,HP,3);
        ability=new AvengersShield(ab,this);
    }

    @Override
    public String cast(List<Unit> ls) {
        return ability.useAbility(ls);
    }
    @Override
    public void levelUpSpacialAbility(){
        hp.SetPool(hp.getMax()+5*lvl);
        att=att+2*lvl;
        def+=1;
    }

    @Override
    public String Tick() {
        ability.Tick();
        return "";
    }
}
