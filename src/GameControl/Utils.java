package GameControl;
import Entity.Enemy.Bosses.NightsKing;
import Entity.Enemy.Bosses.QueenCersei;
import Entity.Enemy.Bosses.TheMountain;
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
            case '.': return new Tuple(new Empty(),null);
            case 'C': return new Tuple(new QueenCersei(),new QueenCersei());
            case 'K': return new Tuple(new NightsKing(),new NightsKing());
            case 'M': return new Tuple(new TheMountain(),new TheMountain());
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

   /*
    public static Tuple getTile(char c){
        switch (c){
            case 'C':
            case 'M':
            case 's':
            case 'k':
            case 'q':
            case 'z':
            case 'b':
            case 'g':
            case 'w':
            case 'B':
            case 'Q':
            case 'D':
            case '.': return new Tuple(new Empty(),null);
            case '@': return new Tuple(null,null);
            case  '#': return new Tuple(new Wall(),null);
            case 'K': return new Tuple(new NightsKing(),new NightsKing());
            default:throw new IllegalArgumentException(c+" char is illegal");
        }
    }

    */

}
