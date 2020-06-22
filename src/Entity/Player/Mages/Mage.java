package Entity.Player.Mages;

import Entity.Player.Player;
import Entity.Tile.Tile;
import Entity.Tile.Unit;
import Resource_based.Abilities.Blizzard;

import java.util.List;

public abstract class Mage extends Player {
    Blizzard ability;
    public Mage(int att, int def, String name, int HP, int range, int manaPool,int cost, int sp, int hit) {
        super(att, def, name, HP,range);
        ability=new Blizzard(this, manaPool, cost,hit,sp);
    }

    @Override
    public void levelUpSpacialAbility(){
        ability.LevelUp();
    }

    @Override
    public String cast(List<Unit> ls) {
        return ability.useAbility(ls);
    }
    @Override
    public String Tick() {
        return ability.Tick();
    }
}
