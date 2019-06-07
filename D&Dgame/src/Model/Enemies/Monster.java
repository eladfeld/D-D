package Model.Enemies;


import Model.FreeSpace;
import Model.GUnit;
import Model.Players.Player;
import Controller.Moves.RandomGenerator;

import Model.gameObject;

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
        return 3;

    }
    
    
    public void turn(RandomGenerator RG, Player player) {
    	int dx, dy;
    	Double distance = this.distanceFrom(player);
    	if( distance.equals(1.0)) {attack((GUnit)player, RG);}
    	else if(distance<=visionRange) {
    		dx = x - player.getX();
    		dy = y - player.getY();
    		if(Math.abs(dx)>Math.abs(dy)) {
    			if(dx>0) move(-1,0);
    			else move(1,0);
    		}
    		else {
    			if( dy>0) move(0,1);
    			else move(0,-1);
    		}
    	}
    	else {
    		do {
    		int[] move = XYComponents(RG.nextInt(5)%5);
    		dx = move[0];
    		dy = move[1];
    		}
    		while(invoke(x + dx ,y + dy ) != 1);
    	}
    	
    	
    }


    public void move(int dx, int dy) {
    	board[x][y]= new FreeSpace(x,y);
    	board[x + dx][y + dy] = this;
    	x = x + dx;
    	y = y + dy;

    }
    
    
    public int canMove(int dx, int dy) {
    	int output;
    	if(dx==dy)output = 0;
    	else output = invoke(x + dx, y + dy);
    	return output;
    	
    }
    

    public int[] XYComponents(int move) {
    	int[] output = new int[2]; 
    	//{0,0} by default   
    	//represents {dx,dy}
    	switch(move) {
    	case 1: output[0]=-1;
    	case 2: output[1]=1;
    	case 3: output[0]=1;
    	case 4: output[1]=-1;
    	}
    	return output;
    }
     

}
