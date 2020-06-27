package Resource_based.Abilities;

import Entity.Enemy.Enemy;
import Entity.Player.Player;
import Entity.Tile.Unit;

import java.util.List;

public abstract class PlayerAbility{
    Player p;
    public void setPlayer(Player p){this.p=p;}
    public abstract String useAbility(List<Unit> ls);
    protected abstract boolean canUse();
    public abstract void LevelUp();
    public abstract void Tick();
    public abstract String attack(Enemy e);
}
