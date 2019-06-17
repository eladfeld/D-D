package Model;


import Controller.Moves.RandomGenerator;
import View.MyObserver;
import View.Presentetion;

public abstract class GUnit extends gameObject implements MyObservable{
    protected String name;
    protected gameObject[][] board;
    protected int currHP ,HP ,DP ,AP;
    protected boolean Alive;
    protected static final MyObserver VIEW = Presentetion.getInstance();

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

    @Override //when attacked by Mage with special
    public  void spelled(RandomGenerator RG ,int spellPwr) {
        int defence = defence(RG,spellPwr);
        notify(name + " was hit with " + Math.max(0, spellPwr - defence) + " points");
    }

    //attacking another game Unit
    public void attack(gameObject defender,RandomGenerator RG){
        if(RG.hasNext()) {
            String defenderPreAttackState = defender.toString();
        	int attack = RG.nextInt(AP);
            int defence = defender.defence(RG, attack);
            battleReport(this,defender,defenderPreAttackState, attack, defence);
            if(defender.lost() != -1) notify(defender.getName() + " have died!");
        }
    }
    //notifies observer of battle information
    public void battleReport( GUnit assailant, gameObject defender,String defenderState, int atk, int def) {
    	VIEW.battleReport(assailant.name, defender.getName() ,assailant.toString() , defenderState, atk, def);
    }
    //notifies observer with relevent message
    public void notify(String s){
    	VIEW.update(s);
    }

    //defends game unit from attack and returns how much of the attack it defended itself from
    public int defence(RandomGenerator RG ,int attack){
    	int defence = RG.nextInt(DP);
    	if(defence<attack) setCurrHP(currHP - attack + defence);
        if(currHP <= 0 ) {
        	Alive = false;
        	currHP=0;
        }
        return defence;
    }
    public String toString(){
        return name + "\t\tHealth: " + currHP +"/"+HP + "\t\tAttack damage: " +AP
                + "\t\tDefense: " + DP;
    }
}


