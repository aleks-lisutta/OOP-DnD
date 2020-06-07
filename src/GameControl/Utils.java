package GameControl;
import Entity.Enemy.Enemy;
import Entity.Enemy.Monster.*;
import Entity.Enemy.Trap.BonusTrap;
import Entity.Enemy.Trap.DeathTrap;
import Entity.Enemy.Trap.QueensTrap;
import Entity.Tile.*;
import Entity.Player.Player;

public class Utils {
    public static Double RANGE(TileFrame a, TileFrame b){
        double x=(a.getx().doubleValue()-b.getx().doubleValue());
        double y=(a.gety().doubleValue()-b.gety().doubleValue());
        return Math.sqrt(x*x+y*y);
    }
    public static Tuple getTile(char c){
        switch (c){
            case '.':
            case 'C':
            case 'K':
            case 'M':
                return new Tuple(new Empty(),null);
            case  '#': return new Tuple(new Wall(),null);
            case 's': return new Tuple(new Lannister_Solider(),new Lannister_Solider());
            case 'k': return new Tuple(new Lannister_Knight(),new Lannister_Knight());
            case 'q': return new Tuple(new Queens_Guard(),new Queens_Guard());
            case 'z': return new Tuple(new Wright(),new Wright());
            case 'b': return new Tuple(new BearWrigh(),new BearWrigh());
            case 'g': return new Tuple(new GiantWright(),new GiantWright());
            case 'w': return new Tuple(new WhiteWalker(),new WhiteWalker());
            case 'B': return new Tuple(new BonusTrap(),new BonusTrap());
            case 'Q': return new Tuple(new QueensTrap(),new QueensTrap());
            case 'D': return new Tuple(new DeathTrap(),new DeathTrap());
            case '@': return new Tuple(null,null);
            default:throw new IllegalArgumentException(c+" char is illegal");
        }
    }

}
