package LogicLayer.Enemies;

import InterfaceLayer.Moves.RandomGenerator;
import LogicLayer.*;
import LogicLayer.Players.Player;

public abstract class Enemy extends GUnit {
    int expValue;
    private char tile;
    int inSight;

    //region Getters and Setters
    public int getExpValue() {
        return expValue;
    }

    public void setExpValue(int expValue) {
        this.expValue = expValue;
    }

    public char getTile() {
        return tile;
    }

    public void setTile(char tile) {
        this.tile = tile;
    }

    public int getInSight() {
        return inSight;
    }

    public void setInSight(int inSight) {
        this.inSight = inSight;
    }
    //endregion

    public Enemy(int x, int y, String name , int HP , int DP , int AP , int expValue , char tile, gameObject[][] board ){
        super(x,y,name,HP,DP,AP,board);
        expValue=expValue;
        inSight=inSight;
        tile=tile;

    }

    @Override
    public int invoked(GUnit gUnit) {
        return 0;
    }
    public int invoked(Enemy enemy){
        return 3;
    }
    public int invoked(Player player){
        return 2;
    }
    public abstract void turn(RandomGenerator RG);
    protected Double distanceFrom(gameObject GO) {
    	int dx = getX()-GO.getX();
    	int dy = getX()-GO.getY();
    	int radicand = (dx*dx)+(dy*dy);
    	return Math.sqrt(radicand);
    }

}


