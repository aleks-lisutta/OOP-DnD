package Entity.Player.Mages;

import Entity.Player.Player;
import Entity.Tile.Unit;

import java.util.List;

public abstract class Mage extends Player {
    public Mage(int att, int def, String name, int HP) {
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
