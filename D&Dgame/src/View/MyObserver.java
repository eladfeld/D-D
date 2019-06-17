package View;
import Model.GUnit;
import Model.gameObject;

public interface MyObserver {

	//receives message 
    public  void update(String update);
    //receives the relevent information regarding a battle
    public void update (GUnit assailant, gameObject defender, int atk, int def);
    public void playerChoseError();
}
