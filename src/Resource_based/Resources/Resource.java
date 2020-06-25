package Resource_based.Resources;

public abstract class Resource {
    int max;
    int cur;
    public Resource(int max){
        this.max=max;
    }

    public int getMax(){
        return max;
    }
    public void setMax(int nu){
        if(nu>1) max=nu;
        else max=1;
    }
    public int getCur(){
        return cur;
    }
    public void setCur(int nu){
        cur=nu;
        if(cur>max) cur=max;
        if(cur<0) cur=0;
    }
}
