package Model;

import Controller.Moves.RandomGenerator;

public class FreeSpace extends gameObject {

	public FreeSpace(int x, int y){
       super(x,y);
       Tile = '.';
    }


    @Override
    public void defence(RandomGenerator RG, int attack) {

    }

    @Override
	public int invoked(GUnit gUnit) {
		// TODO Auto-generated method stub
		return 0;
	}

}
