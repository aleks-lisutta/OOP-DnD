package Entity.Player;

import Entity.Tile.Unit;

import java.util.List;

public class TestPlayer extends Player {
    static final int a=7;
    static final int d=3;
    public TestPlayer(int x, int y) {
        super(x, y, a, d);
    }

    @Override
    public String cast(List<Unit> ls) {
        return null;
    }

    @Override
    public String reciveMove(Unit u) {
        return null;
    }
}
