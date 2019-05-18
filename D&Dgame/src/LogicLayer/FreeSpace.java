package LogicLayer;

public class FreeSpace extends gameObject {

	public FreeSpace(int x, int y){
       super(x,y);
    }
   public String toString(){
        return ".";
   }
	@Override
	public int invoked(GUnit gUnit) {
		// TODO Auto-generated method stub
		return 0;
	}

}
