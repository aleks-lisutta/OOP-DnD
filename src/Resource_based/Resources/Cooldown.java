package Resource_based.Resources;

public class Cooldown extends Resource {
    public Cooldown(int max) {
        super(max);
    }

    public void Tick() {
        setCur(cur-1);
    }

}
