package Entity.Player.Rogues;

import Entity.Player.Player;
import Entity.Tile.Tile;
import Entity.Tile.Unit;
import Resource_based.Abilities.FanOfKnives;

import java.util.List;

public abstract class Rogue extends Player {
    FanOfKnives ability;
    public Rogue(int att, int def, String name, int HP,int cost) {
        super(att, def, name, HP,2);
        ability=new FanOfKnives(cost,this);
    }

    @Override
    public String cast(List<Unit> ls) {
        return ability.useAbility(ls);
    }
    @Override
    public void levelUpSpacialAbility(){
        att=att+(lvl*3);
        ability.LevelUp();
    }

    @Override
    public String Tick() {
        return ability.Tick();
    }
}
