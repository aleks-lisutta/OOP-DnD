package Entity.Enemy.Trap;

import Entity.Tile.TileFrame;

public class DeathTrap extends Trap {

    public DeathTrap() {
        super('D',100,20,250,"Death Trap",500);
        setUpVisibility(1,10);
    }
}
