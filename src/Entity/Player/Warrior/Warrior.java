package Entity.Player.Warrior;

import Entity.Player.Player;
import Entity.Tile.Tile;
import Entity.Tile.Unit;


import java.util.List;

public abstract class Warrior extends Player {

    public Warrior(int att,int def,String name, int HP){
        super(att,def,name,HP);
    }

    @Override
    public String cast(List<Tile> ls) {
        return null;
    }

    @Override
    public String Tick() {
        return null;
    }
}
