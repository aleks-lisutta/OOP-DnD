package Resource_based.Resources;

public class Mana extends Resource {
    public Mana(int max) {
        super(max);
    }

    public void Tick(int lvl){
        setCur(cur+lvl);
    }

}
