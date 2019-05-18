package LogicLayer.Players;

import InterfaceLayer.Moves.RandomGenerator;
import LogicLayer.gameObject;

public class Warrior extends Player {

    private int cooldown;
    private int remaining;

    public Warrior(int x, int y, String name , int HP , int DP , int AP , gameObject[][] board,int cooldown){
        super(x,y,name,HP,DP,AP,board);
        cooldown = cooldown;
        remaining = cooldown;
    }

    @Override
    public void special(RandomGenerator RG) {
        if(remaining <= 0 ) {
            if (getDP() * 2 + getCurrHP() <= getHP()) setCurrHP(getDP() * 2 + getHP());
            else setCurrHP(getHP());
            remaining = cooldown;
        }
    }

    public void levelUp(){
        super.levelUp();
        remaining = 0;
        setHP(getHP() + 5* getLevel());
        setDP(getDP() + getLevel());
    }
    public String getPlayerStatus(){
        return super.getPlayerStatus() + "          Ability cooldown : " +cooldown +
                "           remaining : " + remaining;
    }
}
