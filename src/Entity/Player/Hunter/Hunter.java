package Entity.Player.Hunter;

import Entity.Player.Player;
import Entity.Tile.Tile;
import Entity.Tile.Unit;
import Resource_based.Abilities.Shoot;
import Resource_based.Resources.Arrows;

import java.util.List;

public abstract class Hunter extends Player {
    Shoot ability;
    public Hunter(int att, int def, String name, int HP,int range) {
        super(att, def, name, HP,range);
        ability=new Shoot(this);
    }

    @Override
    public String cast(List<Unit> ls) {
        return ability.useAbility(ls);
    }

    @Override
    public String Tick() {
        return ability.Tick();
    }
    @Override
    public void levelUpSpacialAbility(){
        att=att+2*lvl;
        def+=1;
        ability.LevelUp();
    }
}
