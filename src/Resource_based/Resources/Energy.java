package Resource_based.Resources;

public class Energy extends Resource {
    int cost;
    public Energy(int max,int cost) {
        super(max);
        this.cost=cost;
        cur=max;
    }

    public String Tick(String name){
        setCur(cur+10);
        return "";
    }

}
