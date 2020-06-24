package Resource_based.Resources;

public class Mana extends Resource {
    int lvl;
    int cost;
    public Mana(int max,int cost) {
        super(max);
        setCur(max/4);
        this.cost=cost;
        lvl=1;
    }

    public String Tick(String name){
        setCur(cur+lvl);
        return "";
    }
    public void LevelUp(){
        max+=(25*lvl);
        cur+=(max/4);
    }
    public void use(){
        cur=cur-cost;
    }

}
