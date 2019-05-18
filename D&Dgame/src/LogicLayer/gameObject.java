package LogicLayer;

import InterfaceLayer.Moves.RandomGenerator;

public abstract class gameObject {
    private int x;
    private int y;

    //region Getters and Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    //endregion

    public gameObject(int x,int y){
        x=x;
        y=y;
    }

    public abstract int invoked(GUnit gUnit);

    public String toString(){
        return ".";
    }

    public abstract void defence(RandomGenerator RG , int attack);

    public  void spelled(RandomGenerator RG ,int spellPwr){

    }
}
