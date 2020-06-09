package Entity.Player.Rogues;

import Entity.Player.Player;
import Entity.Tile.Unit;

import java.util.List;

public abstract class Rogue extends Player {
    public Rogue(int att, int def, String name, int HP) {
        super(att, def, name, HP);
    }

    @Override
    public String cast(List<Unit> ls) {
        return null;
    }

    @Override
    public String Tick() {
        return null;
    }
}
