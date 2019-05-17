package LogicLayer.Enemies;

import InterfaceLayer.Moves.RandomGenerator;
import LogicLayer.*;

public class Enemy extends GUnit {
    int expValue;
    private char tile;
    int inSight;
    public Enemy(int x, int y,String name ,int HP ,int DP , int AP , int expValue , char tile, gameObject[][] board ){
        super(x,y,name,HP,DP,AP,board);
        expValue=expValue;
        inSight=inSight;
        tile=tile;

    }

    public void gameTick(RandomGenerator RG) {

    }

    @Override
    public int invoked(GUnit gUnit) {
        return 0;
    }
}

