package Model;

import Controller.Moves.RandomGenerator;

public class Wall extends gameObject{
    public Wall(int x,int y) {
        super(x,y);
        Tile = '#';
    }

    @Override
    public int invoked(gameObject gUnit) {
        return 3;
    }


    public int defence(RandomGenerator RG, int attack) {
    	return -2;
    }

    @Override
    public void spelled(RandomGenerator RG, int spellPwr) {
    }

}
