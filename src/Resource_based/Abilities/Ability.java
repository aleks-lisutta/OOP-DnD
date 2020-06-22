package Resource_based.Abilities;

import Entity.Enemy.Enemy;
import Entity.Player.Player;
import Entity.Tile.Tile;
import Entity.Tile.Unit;
import Resource_based.Resources.Resource;

import java.util.List;

public abstract class Ability {
    public Ability(){
    }
    public abstract String useAbility(List<Unit> ls);
    protected abstract boolean canUse();
    public abstract void LevelUp();
    public abstract String Tick();
    public abstract String attack(Enemy e);
    public abstract String attack(Player p);
}
