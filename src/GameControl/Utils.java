package GameControl;
import Entity.Tile.Empty;
import Entity.Tile.Tile;
import Entity.Player.Player;
import Entity.Tile.Wall;

public class Utils {
    public static Double RANGE(Tile a, Tile b){
        double x=(a.getPosX().doubleValue()+b.getPosX().doubleValue());
        double y=(a.getPosY().doubleValue()+b.getPosY().doubleValue());
        return y/x;
    }
    public static boolean isDead(Player p){
        return false;///////////////////////////////////////////////////////////////
    }
    public static Tile getTile(char c ,int x, int y){
        switch (c){
            case '.': return new Empty(x,y);
            case  '#': return  new Wall(x,y);
            case '@': return null;
            default:throw new IllegalArgumentException(c+" char is illegal");
        }
    }
}
