package Resource_based.Resources;

public class Health extends Resource {
    public Health(int max){
        super(max);
        this.cur=max;
    }


    public void levelUpHP(int level){
        max=max+level*10;
        cur=max;
    }
    public void SetPool(int a){
        if (a<1)
            max=a;
        else
            throw new IllegalArgumentException("you try to add illegal hp");
    }
}
