package LogicLayer.Enemies;


import LogicLayer.Enemies.Enemy;
import InterfaceLayer.Moves.RandomGenerator;

import LogicLayer.*;
import LogicLayer.Players.Player;

public class Monster extends Enemy {
	
	int visionRange;
	
    public Monster(int x, int y, String name, int HP, int DP, int AP, int expValue, char tile, int visionRange, gameObject[][] board) {
        super(x, y, name, HP, DP, AP,expValue, tile, board);
        this.visionRange=visionRange;
    }

    public int invoked(Player player){
        return 2;
    }
    public int invoked(Enemy enemy){
        return 1;

    }
    
    public void turn(RandomGenerator RG, Player player) {
    	int distance = distance(this,player);
    	if( distance==1) {attack(player);}
    	else if(distance<=visionRange) {
    		int dx = this.getX()-player.getX();
    		int dy = this.getY()-player.getY();	
    		if(Math.abs(dx)>Math.abs(dy)) {
    			if(dx>0) move(-1,0);
    			else move(1,0);
    		}
    		else {
    			if( dy>0) move(0,1);
    			else move(0,-1);
    		}
    	}
    	
    }
    public void attack(Player player) {
    	
    }
    public void move(int dx, int dy) {
    	if canMove(dx,dy) {
    		this.setX(getX()+dx);
    		this.setY(getY()+dy);
    	}
    }
    
    
    public int interactWith(int dx, int dy) {
    	if()
    }
    
    public int[] shortestPath(int PX, int PY) {
    	
    }
     

}
