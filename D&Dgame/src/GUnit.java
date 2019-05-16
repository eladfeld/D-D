public abstract class GUnit extends GUnit{
    String name;
    int y , x ,currHP ,HP ,DP ,AP;
    boolean isAlive;


    public Player(int x, int y,String name ,int HP ,int DP , int AP ){
        super(x,y);
        isAlive = true;
        name = name;
        HP = HP;
        currHP = HP;
        level = 1;
        exp = 0;
        DP = DP;
        AP = AP;
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
        if(isAlive)return "@";
        return "X";
    }
    public abstract void specialAb();
}

}
