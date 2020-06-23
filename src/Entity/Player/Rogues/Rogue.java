package Entity.Player.Rogues;

import Entity.Player.Player;
import Entity.Tile.Tile;
import Entity.Tile.Unit;
import Resource_based.Abilities.FanOfKnives;

import java.util.List;

public abstract class Rogue extends Player {
    public Rogue(int att, int def, String name, int HP,int cost) {
        super(att, def, name, HP,2,new FanOfKnives(cost));
    }
    @Override
    public void levelUpSpacialAbility(){
        att=att+(lvl*3);
        super.levelUpSpacialAbility();
    }
}
