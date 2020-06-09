package Resource_based.Resources;

public class Arrows extends Resource {
    int tick=0;

    public Arrows(int max) {
        super(max);
    }

    public void Tick(int lvl){
        if(tick==10){
            setCur(cur+lvl);
            tick=0;
        }
        else tick++;
    }

}
