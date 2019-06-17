package Model.Players;

import Controller.Moves.ActionReader;
import Controller.Moves.RandomGenerator;
import Model.gameObject;

public class Warrior extends Player {

    private final int cooldown;
    private int remaining;

    //returns stats specific to the player
    public String SpecialStats() {
    	String s="Level: "+level+"     Experience: "+exp+"     Ability Cooldown: "+cooldown+"     Remaining: "+remaining;
    	return s;
    }
    public Warrior(int x, int y, String name , int HP , int DP , int AP , gameObject[][] board,int cooldown){
        super(x,y,name,HP,DP,AP,board);
        this.cooldown = cooldown;
        this.remaining = 0;
    }
    
    @Override // activates warrior special ability
    public void special(RandomGenerator RG) {
        if(remaining <= 0 ) {
            int tmp = currHP;
            currHP = Math.min(HP, currHP + (2*DP));
            remaining = cooldown;
            notify( name +" healed " + (currHP - tmp) + " health points" );
        }else {
        	notify("you most cool down before healing !");
        }

    }

    @Override //requests move input from user/generator and plays accordingly
    public void turn(ActionReader AR, RandomGenerator RG) {
        super.turn(AR, RG);
        if(remaining > 0) remaining--;
    }

    //updates the players stats
    public void levelUp(){
        super.levelUp();
        remaining = 0;
        HP = HP + 5* level;
        DP = DP + level;
        notify( "Level Up: +"+(15*level)+" HP     +"+(5*level)+" attack     +"+(3*level)+" defence  ");
    }

    //returns the players stats
    public String toString(){
        return super.toString() + "          Ability cooldown : " +cooldown +
                "           remaining : " + remaining;
    }
}
