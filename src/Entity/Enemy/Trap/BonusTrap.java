package Entity.Enemy.Trap;

import Entity.Player.Player;
import Entity.Tile.TileFrame;

public class BonusTrap extends Trap {

    public BonusTrap() {
        super('B',1,1,250,"Bonus Trap",1);
        setUpVisibility(1,5);
    }

}
