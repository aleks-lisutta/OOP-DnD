package Entity.Enemy.Trap;

import Entity.Tile.TileFrame;

public class QueensTrap extends Trap {
    public QueensTrap() {
        super('Q',50,10,100,"Queen's Trap",250);
        setUpVisibility(3,7);
    }
}
