package Model;

public interface MyObservable {
    //message notification
    void notify(String s);

    //battle notification
    void battleReport(GUnit assailant, gameObject defender,String defenderState, int atk, int def);
}