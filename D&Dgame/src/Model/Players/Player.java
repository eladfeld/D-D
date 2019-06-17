package Model.Players;

import Controller.Moves.ActionReader;
import Controller.Moves.RandomGenerator;
import Model.Enemies.Enemy;
import Model.FreeSpace;
import Model.GUnit;
import Model.gameObject;

public abstract class Player extends GUnit {

    protected int exp;
    protected int level;

    //region Getters and Setters

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    //endregion

    public Player(int x, int y, String name, int HP, int DP, int AP, gameObject[][] board) {
        super(x, y, name, HP, DP, AP, board);
        this.exp = 0;
        this.level = 1;
    }

    @Override
    public int lost() {
        return -1;
    }

    @Override
    public void attack(gameObject defender, RandomGenerator RG) {
        super.attack(defender, RG);
        int enemyLost = defender.lost();
        if(enemyLost > -1){
            exp = exp + enemyLost;
            VIEW.update(name + " gained " + enemyLost + " EXP!");
            while(exp >= 50 * level)
                levelUp();
        }
    }

    public void turn(RandomGenerator RG){};

    public int invoke(int x , int y){
        return board[x][y].invoked(this);
    }
    @Override
    public int invoked(Player player){
        return 3;
    }

    @Override
    public int invoked(Enemy enemy){
        return 2;
    }

    public void turn(ActionReader AR, RandomGenerator RG) {
        String action = "";
        if (AR.hasNext()) action = AR.nextAction();
        switch (action) {
            case "w":
                moveUp(RG);
                break;
            case "a":
                moveLeft(RG);
                break;
            case "d":
                moveRight(RG);
                break;
            case "s":
                moveDown(RG);
                break;
            case "e":
                special(RG);
                break;
        }
    }

    public void moveLeft(RandomGenerator RG) {
        int interaction = invoke(x - 1, y);
        switch (interaction) {
            case 1:
                board[x][y] = new FreeSpace(x, y);
                board[x - 1][y] = this;
                x--;
                break;
            case 2:
                attack(board[x - 1][y], RG);
                break;
            case 3:
                break;
        }
    }

    public void moveRight(RandomGenerator RG) {
        int interaction = invoke(x + 1, y);
        switch (interaction) {
            case 1:
                board[x][y] = new FreeSpace(x, y);
                board[x + 1][y] = this;
                x++;
                break;
            case 2:
                attack(board[x + 1][y], RG);
                break;
            case 3:
                break;//skips turns
        }
    }

    public void moveUp(RandomGenerator RG) {
        int interaction = invoke(x, y - 1);
        switch (interaction) {
            case 1:
                board[x][y] = new FreeSpace(x, y);
                board[x][y - 1] = this;                
                y--;
                break;
            case 2:
                attack(board[x][y - 1], RG);
                break;
            case 3:
                break;
        }
    }

    public void moveDown(RandomGenerator RG) {
        int interaction = invoke(x, y + 1);
        switch (interaction) {
            case 1:
                board[x][y] = new FreeSpace(x, y);
                board[x][y + 1] = this;
                y++;
                break;
            case 2:
                attack(board[x][y + 1], RG);
                break;
            case 3:
                break;
        }
    }


    public abstract void special(RandomGenerator RG);

    public void levelUp() {
        VIEW.update(name + " leveled up from level " + level +" to " + (level+1));
        exp = exp - (level * 50);
        level++;
        HP = HP + 10 * level;
        currHP = HP;
        AP = AP + level * 5;
        DP = DP + level * 2;
    }


    public String toString() {
        if (Alive) return "@";
        return "X";
    }

    public String getPlayerStatus() {
        return name + "             Health: " + currHP +
                "          Attack damage:" + AP + "         Defence:" +
                DP + '\n' + "           level: " + level + "          Experience" +
                exp + "/" + level * 50;
    }
    public abstract String SpecialStats();

    protected double ocDistance(int Ex , int Ey){
        return Math.sqrt((x-Ex)*(x-Ex) + (y-Ey)*(y-Ey));
    }

}

