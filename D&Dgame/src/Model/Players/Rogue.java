package Model.Players;

import Controller.Moves.ActionReader;
import Controller.Moves.RandomGenerator;
import Model.gameObject;

import java.util.LinkedList;
import java.util.List;

public class Rogue extends Player {

    private int currEnergy;
    private int cost;

    //returns players current stats
    public String toString() {
        String s = super.toString() + "     Energy: " + currEnergy + "/" + 100;
        return s;
    }

    //region Getters and Setters

    public int getCurrEnerg() {
        return currEnergy;
    }

    public void setCurrEnerg(int currEnerg) {
        this.currEnergy = currEnerg;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    //endregion


    public Rogue(int x, int y, String name, int HP, int DP, int AP, gameObject[][] board, int cost) {
        super(x, y, name, HP, DP, AP, board);
        this.cost = cost;
        currEnergy = 100;
    }

    @Override //activates Rogue's special ability fan of knives
    public void special(RandomGenerator RG) {
        if (currEnergy < cost) {
            notify("Need to gain more energy before performing fan of knives!");
        } else {
            currEnergy = currEnergy - cost;
            List<gameObject> enemies = searchForEnemies();
            notify(name + " use fan of knives : ");
            for (gameObject go : enemies){
                go.spelled(RG, AP);
                int enemyLost = go.lost();
                if(enemyLost > -1){
                    exp = exp + enemyLost;
                    notify("and died!");
                    notify(name + " gained " + enemyLost + " EXP!");
                    while (exp >= 50 * level)
                        levelUp();
                }
            }
        }
    }


    @Override //requests input from user/generator and plays accordingly
    public void turn(ActionReader AR, RandomGenerator RG) {
        super.turn(AR, RG);
        currEnergy = Math.min(currEnergy + 10, 100);
    }

    @Override //updates players stats upon leveling up
    public void levelUp() {
        super.levelUp();
        currEnergy = 100;
        AP = AP + (3 * level);
        notify("Level Up: +" + (10 * level) + " HP     +" + (8 * level) + " attack     +" + (2 * level) + " defence");
    }

    //returns list of all enemies within striking range for special ability
    private List<gameObject> searchForEnemies() {   //need to test!!!!
        List<gameObject> output = new LinkedList<gameObject>();
        int topBound = Math.max(y - 1, 0);
        int bottomBound = Math.min(y + 1, board[0].length - 1);
        int leftBound = Math.max(x - 1, 0);
        int rightBound = Math.min(x + 1, board.length - 1);
        for (int i = topBound; i <= bottomBound ; i++)
            for (int j = leftBound; j <= rightBound; j++)
                if ((i != y | j != x) && invoke(j, i) == 2) output.add(board[j][i]);
        return output;
    }
}


