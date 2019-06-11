package Model.Players;

import Controller.Moves.RandomGenerator;
import Model.gameObject;

import java.util.LinkedList;
import java.util.List;

public class Rogue extends Player {

    private int currEnergy;
    private int cost;
    
    public String SpecialStats() {
    	String s = "Level: "+level+"     Experience: "+exp+"     Energy: "+currEnergy;
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

    @Override
    public void special(RandomGenerator RG) {
        if (currEnergy < cost) {
            //generate an aproprate message here!!
        } else {
            currEnergy = currEnergy - cost;
            List<gameObject> enemies = searchForEnemies();
            for (gameObject go : enemies) go.spelled(RG, RG.nextInt(AP));
        }
    }
    @Override
    public void personalEndOfTurn() {
    	currEnergy = Math.min(currEnergy + 10, 100);
    }
    @Override
    public void personalLevelUp() {
    	currEnergy = 100;
    	AP = AP + (3*level);
    }

    private List<gameObject> searchForEnemies() {   //need to test!!!!
        List<gameObject> output = new LinkedList<gameObject>();
        int upperBound = Math.max(y - 1, 0);
        int lowerBound = Math.min(y + 1, board.length);
        int leftBound = Math.max(x - 1, 0);
        int rightBound = Math.min(x + 1, board[0].length);
        for (int i = upperBound; i <= lowerBound; i++) {
            for (int j = leftBound; j <= rightBound; j++) {
                if ((i != y | j != x) && invoke(j, i) == 2) output.add(board[i][j]);
            }
        }
        return output;
    }
}


