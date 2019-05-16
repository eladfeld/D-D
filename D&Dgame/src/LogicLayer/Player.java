package LogicLayer;

public abstract class Player extends GUnit {

    int exp;
    int level;
    public Player(int x, int y,String name ,int HP ,int DP , int AP){
        super(x,y,name,HP,DP,AP);
        exp = 0;
        level = 1;
    }

    public void levelUp(){
        exp = exp - level*50;
        level++;
        HP = HP + 10*level;
        currHP = HP;
        AP = AP + level*5;
        DP = DP + level*2;

    }
    public String toString(){
        return "@";
    }
}
