package Model;

import Controller.Moves.RandomGenerator;
import Model.Enemies.Enemy;
import Model.Players.Player;

public class FreeSpace extends gameObject {

	public FreeSpace(int x, int y){
       super(x,y);
       Tile = '.';
    }

    @Override
    public int invoked(Player player) {
        return 1;
    }

    @Override
    public int invoked(Enemy enemy) {
        return 1;
    }


    public int defence(RandomGenerator RG, int attack) {
    	return -1;
    }

    @Override
    public void spelled(RandomGenerator RG, int spellPwr) {
    }


}
