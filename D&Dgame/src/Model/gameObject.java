package Model;

import Controller.Moves.RandomGenerator;

public abstract class gameObject {
    protected int x;
    protected int y;
    protected Character Tile;

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

    public gameObject(int x,int y ){
        this.x = x;
        this.y = y;
        Tile = ',';
    }
    public abstract int invoked( GUnit gUnit);

    public abstract int defence(RandomGenerator RG , int attack);

    public String toString(){
        return Tile.toString();
    }

    public abstract void spelled(RandomGenerator RG ,int spellPwr);

}
