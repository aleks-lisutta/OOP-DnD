package GameControl;

import Entity.Enemy.Enemy;
import Entity.Tile.Tile;

public class Tuple<T,E>{
    T t;
    E e;
    Tuple(T t, E e){
        this.t=t;
        this.e=e;
    }

    @Override
    public String toString(){
        return t.toString()+" , "+e.toString();
    }
}
