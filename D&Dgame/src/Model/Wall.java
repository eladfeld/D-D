package Model;

import Controller.Moves.RandomGenerator;

public class Wall extends gameObject{
    int x,y;
    public Wall(int x,int y) {
        super(x,y);
        Tile = '#';
    }

    @Override
    public int invoked(GUnit gUnit) {
        return 3;
    }

    @Override
    public void defence(RandomGenerator RG, int attack) {
    }

}
