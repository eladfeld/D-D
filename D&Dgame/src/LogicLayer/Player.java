package LogicLayer;

public abstract class Player extends GUnit {

    int exp;
    int level;

    //region Getters and Setters
    public boolean isAlive() {
        return Alive;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    //endregion

    public Player(int x, int y, String name , int HP , int DP , int AP , gameObject[][] board){
        super(x,y,name,HP,DP,AP,board);
        Alive = true;
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
        if(Alive)return "@";
        return "X";
    }

}
