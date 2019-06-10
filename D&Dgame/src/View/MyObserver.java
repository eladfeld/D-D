package View;
import Model.GUnit;
import Model.gameObject;

public interface MyObserver {

    public  void update(String update);
    public void update (GUnit assailant, gameObject defender, int atk, int def);
    public void playerChoseError();
}
