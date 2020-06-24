package Entity.Player.Hunter;

import Entity.Player.Player;
import Entity.Tile.Tile;
import Entity.Tile.Unit;
import Resource_based.Abilities.Shoot;
import Resource_based.Resources.Arrows;

import java.util.List;

public class Hunter extends Player {
    public Hunter(int att, int def, String name, int HP,int range) {
        super(att, def, name, HP,range,new Shoot());
    }

    @Override
    public void levelUpSpacialAbility(){
        att=att+2*lvl;
        def+=1;
        super.levelUpSpacialAbility();
    }
}
