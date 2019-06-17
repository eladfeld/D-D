package Model.Enemies;

import Controller.Moves.RandomGenerator;
import Model.GUnit;
import Model.Players.Player;
import Model.gameObject;

public abstract class Enemy extends GUnit {
    int expValue;

    //region Getters and Setters
    public int getExpValue() {
        return expValue;
    }

    public void setExpValue(int expValue) {
        this.expValue = expValue;
    }
    //endregion

    public Enemy(int x, int y, String name, int HP, int DP, int AP, int expValue, char tile, gameObject[][] board) {
        super(x, y, name, HP, DP, AP, board);
        this.expValue = expValue;
        this.Tile = tile;

    }
    //retruns value determing the consequeces of stepping into another place on the game board
    public int invoke(int x, int y) {
        return board[x][y].invoked(this);
    }

    @Override //returns value representing the consequences of an enemy stepping into this's place
    public int invoked(Enemy enemy) {
        return 3;
    }

    @Override //returns value representing the consequences of a player stepping into this's place
    public int invoked(Player player) {
        return 2;
    }

    public abstract void turn(RandomGenerator RG);

    //returns the euclidean distance between this and the given gameObject
    protected Double distanceFrom(int Px , int Py) {
        int dx = x - Px;
        int dy = y - Py;
        int radicand = (dx * dx) + (dy * dy);
        return Math.sqrt(radicand);
    }

    @Override
    public int lost() {
        if(currHP > 0)return -1;
        else return expValue;
    }
}


