package GameControl;

import Entity.Enemy.Enemy;
import Entity.Tile.Tile;

public class Tuple{
    Tile tile;
    Enemy enemy;
    Tuple(Tile t, Enemy e){
        tile=t;
        enemy=e;
    }
}
