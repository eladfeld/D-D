package LogicLayer.Players;

import InterfaceLayer.Moves.RandomGenerator;
import LogicLayer.Enemies.Enemy;
import LogicLayer.GUnit;
import LogicLayer.gameObject;

public abstract class Player extends GUnit {

    private int exp;
    private int level;

    //region Getters and Setters

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
        exp = 0;
        level = 1;
    }
    public void defence(GUnit gUnit, int nextInt) {

    }

    public abstract void special(RandomGenerator RG);

    public void levelUp(){
        exp = exp - level*50;
        level++;
        setHP(getHP() + 10*level);
        setCurrHP(getHP());
        setAP(getAP() + level*5) ;
        setDP(getDP() + level*2);

    }
    @Override
    public int invoked(GUnit gUnit) {
        return 0;
    }

    public int invoked(Enemy enemy) {
        return 2;
    }

    public String toString(){
        if(isAlive())return "@";
        return "X";
    }
    public String getPlayerStatus(){
        return getName() + "             Health: " +getCurrHP() +
                "          Attack damage:" + getAP() + "          Defence:" +
                getDP() + '\n'+  "           level: " + getLevel() + "          Experience" +
                getExp() + "/" + getLevel()*50;
    }

}
