package Model.Players;

import Controller.Moves.ActionReader;
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
        this.remaining = 0;
    }
    
    @Override
    public void special(RandomGenerator RG) {
        if(remaining <= 0 ) {
            int tmp = currHP;
            currHP = Math.min(HP, currHP + (2*DP));
            remaining = cooldown;
            VIEW.update(name +" healed " + (currHP - tmp) + "health points" );
        }else {
        	VIEW.update("you most cool down before healing !");
        }

    }

    @Override
    public void turn(ActionReader AR, RandomGenerator RG) {
        super.turn(AR, RG);
        if(remaining > 0) remaining--;
    }

    public void levelUp(){
        super.levelUp();
        remaining = 0;
        HP = HP + 5* level;
        currHP = HP;
        DP = DP + level;
    }

    public String getPlayerStatus(){
        return super.getPlayerStatus() + "          Ability cooldown : " +cooldown +
                "           remaining : " + remaining;
    }
}
