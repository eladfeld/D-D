package Model;

import Controller.Moves.RandomGenerator;
import Model.Enemies.Enemy;
import Model.Players.Player;

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

    public abstract int invoked(Player player);

    public abstract int invoked(Enemy enemy);

    public abstract int defence(RandomGenerator RG , int attack);

    public String toString(){
        return Tile.toString();
    }

    public abstract void spelled(RandomGenerator RG ,int spellPwr);

}
