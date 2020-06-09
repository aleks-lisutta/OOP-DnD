package Resource_based.Resources;

public class Energy extends Resource {
    public Energy(int max) {
        super(max);
    }

    public void Tick(){
        setCur(cur+10);
    }

}
