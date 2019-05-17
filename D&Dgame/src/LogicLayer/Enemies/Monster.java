package LogicLayer;

import LogicLayer.Enemies.Enemy;

public class Monster extends Enemy {

    public Monster(int x, int y, String name, int HP, int DP, int AP, int expValue, char tile, gameObject[][] board) {
        super(x, y, name, HP, DP, AP, expValue, tile, board);
    }

    public int invoked(Player player){
        return 2;
    }
    public int invoked(Enemy enemy){
        return 1;

    }

}
