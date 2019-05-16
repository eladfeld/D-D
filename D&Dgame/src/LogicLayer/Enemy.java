package LogicLayer;

public class Enemy extends GUnit {
    int expValue;
    char tile;
    int inSight;
    public Enemy(int x, int y,String name ,int HP ,int DP , int AP , int expValue , char tile, int inSight ){
        super(x,y,name,HP,DP,AP);
        expValue=expValue;
        inSight=inSight;
        tile=tile;
    }


    }

