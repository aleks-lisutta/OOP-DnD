package Entity.Enemy.Trap;

public class DeathTrap extends Trap {

    public DeathTrap(int x,int y) {
        super('D',100,20,250,"Death Trap",500,x,y);
        setUpVisibility(1,10);
    }
}
