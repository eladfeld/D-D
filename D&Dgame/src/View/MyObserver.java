package View;
public interface MyObserver {

	//receives message 
    void update(String update);
    void playerChoseError();
    //receives the relevent information regarding a battle
    void battleReport(String name, String name1, String toString, String toString1, int atk, int def);

    void playerChosen(String name);
}
