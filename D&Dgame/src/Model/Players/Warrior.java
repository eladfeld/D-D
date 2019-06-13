package Model.Players;

import Controller.Moves.RandomGenerator;
import Model.gameObject;

public class Warrior extends Player {

    private final int cooldown;
    private int remaining;

    public String SpecialStats() {
    	String s="Level: "+level+"     Experience: "+exp+"     Ability Cooldown: "+cooldown+"     Remaining: "+remaining;
    	return s;
    }
    public Warrior(int x, int y, String name , int HP , int DP , int AP , gameObject[][] board,int cooldown){
        super(x,y,name,HP,DP,AP,board);
        this.cooldown = cooldown;
        this.remaining = cooldown;
    }
    
    @Override
    public void special(RandomGenerator RG) {
        if(remaining <= 0 ) {
            currHP = Math.min(HP, currHP + (2*DP));
            remaining = cooldown;
            VIEW.update(name +" healed");
        }else {
        	VIEW.update("you most cool down before healing !");
        }

    }
    
    @Override
    public void personalEndOfTurn() {
    	if( remaining > 0) remaining--;
    }
    @Override
    public void personalLevelUp() {
    	remaining = 0;
    	HP = HP + (5*level);
    	DP = DP + level;
    }

    public void levelUp(){
        super.levelUp();
        remaining = 0;
        HP = HP + 5* level;
        DP = DP + level;
    }
    public String getPlayerStatus(){
        return super.getPlayerStatus() + "          Ability cooldown : " +cooldown +
                "           remaining : " + remaining;
    }

}
