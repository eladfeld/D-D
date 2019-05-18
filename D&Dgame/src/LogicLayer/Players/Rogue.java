package LogicLayer.Players;

import InterfaceLayer.Moves.RandomGenerator;
import LogicLayer.gameObject;

import java.util.LinkedList;
import java.util.List;

public class Rogue extends Player {

    private int currEnergy;
    private int cost;

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



    public Rogue(int x, int y, String name, int HP, int DP, int AP, gameObject[][] board,int cost) {
        super(x, y, name, HP, DP, AP, board);
        cost=cost;
        currEnergy=100;
    }

    @Override
    public void special(RandomGenerator RG) {
        if(currEnergy < cost){
            //generate an aproprate message here!!
        }
        else{
            currEnergy = currEnergy - cost;
            List<gameObject> enemies = searchForEnemies();
            for (gameObject go: enemies) go.spelled(RG,RG.nextInt(getAP()));
        }


    }
    private List<gameObject> searchForEnemies() {   //need to test!!!!
        List<gameObject> output = new LinkedList<gameObject>();
        int upperBound = Math.max(getY()-1 ,0);
        int lowerBoubd = Math.min(getY()+1,getBoard().length);
        int leftBound = Math.max(getX()-1,0);
        int rightBound = Math.min(getX()+1,getBoard()[0].length);
        for (int i = upperBound;i <= lowerBoubd; i++){
            for(int j =leftBound;j <=rightBound;j++){
                if((i != getY() | j!=getX()) && invoke(j,i)==2)output.add(getBoard()[i][j]);
            }
        }
        return output;
    }
}
