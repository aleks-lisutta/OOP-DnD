package Resource_based;

public class Health extends Resource {
    public Health(int max){
        super(max);
        this.cur=max;
    }
    public void levelUpHP(int pool){
        max=pool*10;
        cur=max;
    }
}
