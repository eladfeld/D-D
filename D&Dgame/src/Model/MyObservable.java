package Model;
import View.MyObserver;

public interface MyObservable {
	//public void notify(String s);
	public void notify(MyObserver observer, GUnit assailant, gameObject defender, int atk, int def);
}