package Tests;
import Entity.Enemy.Enemy;
import Entity.Player.Player;
import Entity.Tile.Empty;
import Entity.Tile.Pos;
import Entity.Tile.TileFrame;
import GameControl.Board;
import GameControl.Utils;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

class EnemyTest {

    Enemy e;
    Player p;
    @BeforeEach
    public void InitTest(){
        int n=new Random().nextInt(Utils.playerMap.size());
        p=Utils.getPlayer(n);
        e=Utils.getEnemy(5);
    }
    @Test
    void receiveMove1(){
        e.def=0;
        p.att=5000;
        e.reciveMove(p);
        Assert.assertTrue(e.isDead);
    }
    @Test
    void receiveMove2(){
        e.def=50000;
        p.att=0;
        Assert.assertTrue(e.reciveMove(p).contains(" has "+e.hp.getCur()+"/"+e.hp.getMax()+" health left."));
    }

    @Test
    void abilityKill() {
        e.frame=new TileFrame(e,new Pos(2,2),new Board());
        e.abilityKill();
        Assert.assertSame(e.frame.tile.getClass(),Empty.class);
    }

    @Test
    public void Injured(){
        e.hp.setCur(15);
        e.frame=new TileFrame(e,new Pos(2,2),new Board());
        e.injured(15,p);
        Assert.assertTrue(e.isDead);
    }
    @Test
    public void def1(){
        Enemy e=Utils.getEnemy(4);
        p.def=0;
        p.setHp(10);
        e.att=1000;
        p.def(e);
        Assert.assertEquals(0,p.hp.getCur());
    }
    @Test
    public void def2(){
        Enemy e=Utils.getEnemy(4);
        p.def=1000;
        e.att=0;
        Assert.assertTrue(p.def(e).contains("blocked the attack taking no damage."));
    }
}