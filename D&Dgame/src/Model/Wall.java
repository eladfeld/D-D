package Model;

import Controller.Moves.RandomGenerator;

public class Wall extends gameObject{
    public Wall(int x,int y) {
        super(x,y);
        Tile = '#';
    }

    @Override
    public int invoked(GUnit gUnit) {
        return 3;
    }


    public int defence(RandomGenerator RG, int attack) {
    	return -2;
    }

}
