package Model;

import Controller.Moves.RandomGenerator;

public class FreeSpace extends gameObject {

	public FreeSpace(int x, int y){
       super(x,y);
       Tile = '.';
    }



    public int defence(RandomGenerator RG, int attack) {
    	return -1;
    }

    @Override
    public void spelled(RandomGenerator RG, int spellPwr) {
    }

    //@Override
    //should not be overriden, invoked is abstract method for gameObject
	public int invoked(GUnit gUnit) {
		// TODO Auto-generated method stub
		return 0;
	}

}
