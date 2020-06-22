package Resource_based.Resources;

public class Energy extends Resource {
    int cost;
    public Energy(int max,int cost) {
        super(max);
        this.cost=cost;
        cur=max;
    }

    public String Tick(String name){
        if (cur>=cost-10)
            return name+" can use with ability next turn.";
        setCur(cur+10);
        return name+ " current energy: "+cur+",  cost ability: "+cost;
    }

}
