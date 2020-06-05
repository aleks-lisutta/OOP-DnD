package GameControl;
import Entity.Enemy.Monster.*;
import Entity.Enemy.Trap.BonusTrap;
import Entity.Enemy.Trap.DeathTrap;
import Entity.Enemy.Trap.QueensTrap;
import Entity.Tile.Empty;
import Entity.Tile.Tile;
import Entity.Player.Player;
import Entity.Tile.Unit;
import Entity.Tile.Wall;

public class Utils {
    public static Double RANGE(Tile a, Tile b){
        double x=(a.getPosX().doubleValue()+b.getPosX().doubleValue());
        double y=(a.getPosY().doubleValue()+b.getPosY().doubleValue());
        return y/x;
    }
/*    public static boolean isDead(Tile t){
        if(t.chr=='X') return true;
        return false;
    }*/
    public static Tile getTile(char c,int x,int y){
        switch (c){
            case '.':
            case 'C':
            case 'K':
            case 'M':
                return new Empty(x,y);
            case  '#': return  new Wall(x,y);
            case 's': return new Lannister_Solider(x,y);
            case 'k': return new Lannister_Knight(x,y);
            case 'q': return new Queens_Guard(x,y);
            case 'z': return new Wright(x,y);
            case 'b': return new BearWrigh(x,y);
            case 'g': return new GiantWright(x,y);
            case 'w': return new WhiteWalker(x,y);
            case 'B': return new BonusTrap(x,y);
            case 'Q': return new QueensTrap(x,y);
            case 'D': return new DeathTrap(x,y);
            case '@': return null;
            default:throw new IllegalArgumentException(c+" char is illegal");
        }
    }
}
