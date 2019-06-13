package Model;

import Controller.Moves.RandomGenerator;
import Model.Enemies.Enemy;
import Model.Players.Player;

public class Wall extends gameObject{
    public Wall(int x,int y) {
        super(x,y);
        Tile = '#';
    }

    @Override
    public int invoked(Player player) {
        return 3;
    }

    @Override
    public int invoked(Enemy enemy) {
        return  3;
    }

    public int defence(RandomGenerator RG, int attack) {
    	return -2;
    }

    @Override
    public void spelled(RandomGenerator RG, int spellPwr) {
    }

}
