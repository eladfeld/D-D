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

    public Enemy(int x, int y, String name , int HP , int DP , int AP , int expValue , char tile, gameObject[][] board ){
        super(x,y,name,HP,DP,AP,board);
        this.expValue=expValue;
        this.Tile=tile;

    }
    
    public int invoke(int x, int y) {
    	return board[x][y].invoked(this);
    }

    @Override
    public int invoked(Enemy enemy){
        return 3;
    }

    @Override
    public int invoked(Player player){
        return 2;
    }

    public abstract void turn(RandomGenerator RG);

    protected Double distanceFrom(gameObject GO) {
    	int dx = x - GO.getX();
    	int dy = y - GO.getY();
    	int radicand = (dx*dx)+(dy*dy);
    	return Math.sqrt(radicand);
    }

}


