package Model.Players;
import Model.GUnit;

import Controller.Moves.RandomGenerator;
import Model.gameObject;
import java.util.*;


public class Mage extends Player {
    private int spellPwr,MP ,currMana,cost,hitTimes, range;
    public String SpecialStats() {
    	return "Level: "+level+"     Experience: "+exp+"      Spell Power: "+spellPwr+"     Mana: "+currMana+"/"+MP;
    }
    //region Getters and Setters
    public int getSpellPwr() {
        return spellPwr;
    }

    public void setSpellPwr(int spellPwr) {
        this.spellPwr = spellPwr;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public int getCurrMana() {
        return currMana;
    }

    public void setCurrMana(int currMana) {
        this.currMana = currMana;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getHitTimes() {
        return hitTimes;
    }

    public void setHitTimes(int hitTimes) {
        this.hitTimes = hitTimes;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
    //endregion

    public Mage(int x, int y, String name , int HP , int DP , int AP , gameObject[][] board,
                int spellPwr , int MP, int cost , int hitTimes , int range){
        super(x,y,name,HP,DP,AP,board);
        this.spellPwr=spellPwr;
        this.MP=MP;
        this.currMana=MP;
        this.cost=cost;
        this.hitTimes=hitTimes;
        this.range=range;
    }

    @Override
    public void personalLevelUp() {
        MP = MP + 25*level;
        currMana = Math.min(currMana+MP/4,MP);
        spellPwr = spellPwr + 10* level;
    }

    @Override
    public void special(RandomGenerator RG) {
        if(currMana < cost){
            //generate an aproprate message here!!
        }else{
            currMana = currMana - cost;
            int hits = 0;
            int toHit = -1;
            List<gameObject> enemies= searchForEnemies();
            while(hits<hitTimes & enemies.size()>0) {
            if(RG.hasNext()) toHit = RG.nextInt(enemies.size()-1);
            enemies.get(toHit).spelled(RG ,spellPwr);
            hits++;
            }
        }
        //check function
    }
    @Override
    public void personalEndOfTurn() {
    	currMana = Math.min(MP, currMana + 1);
    }

    private List<gameObject> searchForEnemies() {   //need to test!!!!
        List<gameObject> output = new LinkedList<gameObject>();
        int upperBound = Math.max(y-range ,0);
        int lowerBound = Math.min(y+range,board.length);
        int leftBound = Math.max(x-range,0);
        int rightBound = Math.min(x+range,board[0].length);
        for (int i = upperBound;i <= lowerBound; i++){
            for(int j =leftBound;j <=rightBound;j++){
                if(invoke(j,i)==2 && ((GUnit)board[j][i]).isAlive())output.add(board[i][j]);
                //invoke=2  <===> enemy ==>GUnit
                //necesary casting!
            }
        }
        return output;
    }
}
