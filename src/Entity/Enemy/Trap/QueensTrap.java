package Entity.Enemy.Trap;

public class QueensTrap extends Trap {
    public QueensTrap(int x,int y) {
        super('Q',50,10,100,"Queen's Trap",250,x,y);
        setUpVisibility(3,7);
    }
}
