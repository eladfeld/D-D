package LogicLayer;

import InterfaceLayer.Moves.RandomGenerator;

public abstract class GUnit extends gameObject{
    String name;
    gameObject[][] board;
    int y , x ,currHP ,HP ,DP ,AP;
    boolean Alive;

    //region Getters and Setters
    public gameObject[][] getBoard() {
        return board;
    }

    public void setBoard(gameObject[][] board) {
        this.board = board;
    }

    public boolean isAlive() {
        return Alive;
    }

    public void setAlive(boolean alive) {
        Alive = alive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrHP() {
        return currHP;
    }

    public void setCurrHP(int currHP) {
        this.currHP = currHP;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getDP() {
        return DP;
    }

    public void setDP(int DP) {
        this.DP = DP;
    }

    public int getAP() {
        return AP;
    }

    public void setAP(int AP) {
        this.AP = AP;
    }


    //endregion


    public GUnit(int x, int y,String name ,int HP ,int DP , int AP , gameObject[][] board ){
       super(x,y);
        Alive = true;
        name = name;
        HP = HP;
        currHP = HP;
        DP = DP;
        AP = AP;
        board = board;
    }
    public int invoke(int x , int y){
       return board[x][y].invoked(this);
    }

}


