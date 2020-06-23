package Entity.Player.Mages;

import Entity.Player.Player;
import Entity.Tile.Tile;
import Entity.Tile.Unit;
import Resource_based.Abilities.Blizzard;

import java.util.List;

public abstract class Mage extends Player {
    public Mage(int att, int def, String name, int HP, int range, int manaPool,int cost, int sp, int hit) {
        super(att, def, name, HP,range,new Blizzard( manaPool, cost,hit,sp));
    }

}
