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

    //returns value representing the consequences of a player attempting to step into this's place
    public abstract int invoked(Player player);
   
    //returns value representing the consequences of an enemy attempting to step into this's place
    public abstract int invoked(Enemy enemy);

    //defends this in response to an attack and returns how strong the defense was
    public abstract int defence(RandomGenerator RG , int attack);

    public abstract  int lost();

    public String toString(){
        return Tile.toString();
    }

    public abstract boolean spelled(RandomGenerator RG ,int spellPwr);

    protected  String getName(){
        return Tile.toString();
    }
}
