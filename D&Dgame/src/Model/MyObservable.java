package Model;
import View.MyObserver;

public interface MyObservable {
	//message notification
	public void notify(MyObserver observer, String s);
	//battle notification
	public void notify(MyObserver observer, GUnit assailant, gameObject defender, int atk, int def);
}