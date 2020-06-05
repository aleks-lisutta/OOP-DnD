package Entity.Enemy.Trap;

public class BonusTrap extends Trap {

    public BonusTrap(int x,int y) {
        super('B',1,1,250,"Bonus Trap",1,x,y);
        setUpVisibility(1,5);
    }
}
