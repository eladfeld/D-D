package Model;

import Controller.Moves.RandomGenerator;

public abstract class GUnit extends gameObject{
    protected String name;
    protected gameObject[][] board;
    protected int currHP ,HP ,DP ,AP;
    protected boolean Alive;

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
       super(x,y );
        this.Alive = true;
        this.name = name;
        this.HP = HP;
        this.currHP = HP;
        this.DP = DP;
        this.AP = AP;
        this.board = board;
    }

    public abstract void turn(RandomGenerator RG);

    public int invoke(int x , int y){
       return board[x][y].invoked(this);
    }

    @Override
    public  void spelled(RandomGenerator RG ,int spellPwr) {
        defence(RG,spellPwr);
    }

    public void attack(gameObject defencer,RandomGenerator RG){
        if(RG.hasNext()) {
            defencer.defence(RG, RG.nextInt(AP));
        }
    }

    public void defence(RandomGenerator RG ,int attack){
        currHP = currHP -(RG.nextInt(DP)-attack);
        if(currHP <= 0 )Alive = false;
    }


}


