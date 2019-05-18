package LogicLayer.Players;

import InterfaceLayer.Moves.RandomGenerator;
import LogicLayer.Enemies.Enemy;
import LogicLayer.gameObject;
import java.util.*;


public class Mage extends Player {
    private int spellPwr,MP ,currMana,cost,hitTimes, range;

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
                int spellPwr , int MP, int currMana, int cost , int hitTimes , int range){
        super(x,y,name,HP,DP,AP,board);
        spellPwr=spellPwr;
        MP=MP;
        currMana=currMana;
        cost=cost;
        hitTimes=hitTimes;
        range=range;
    }

    @Override
    public void levelUp() {
        super.levelUp();
        MP = MP + 25*getLevel();
        currMana = Math.min(currMana+MP/4,MP);
        spellPwr = spellPwr + 10* getLevel();
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
            while(hits<hitTimes & enemies.size()>0)
            if(RG.hasNext())toHit =RG.nextInt(enemies.size())-1;
            enemies.get(toHit).spelled(RG ,spellPwr);
        }

    }

    private List<gameObject> searchForEnemies() {   //need to test!!!!
        List<gameObject> output = new LinkedList<gameObject>();
        int upperBound = Math.max(getY()-range ,0);
        int lowerBoubd = Math.min(getY()+range,getBoard().length);
        int leftBound = Math.max(getX()-range,0);
        int rightBound = Math.min(getX()+range,getBoard()[0].length);
        for (int i = upperBound;i <= lowerBoubd; i++){
            for(int j =leftBound;j <=rightBound;j++){
                if(invoke(j,i)==2)output.add(getBoard()[i][j]);
            }
        }

        return output;

    }
}
