package Resource_based.Resources;

public class Cooldown extends Resource {
    public Cooldown(int max) {
        super(max);
        setCur(0);
    }

    public String Tick(String name) {
        setCur(cur-1);
        if (cur==0)
            return name+ " can use with ability";
        return name+ " more "+cur+" turns, you can use with ability.";
    }
    public void LevelUp(){setCur(0);}

}
