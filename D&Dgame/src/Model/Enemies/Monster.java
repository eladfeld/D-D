package Model.Enemies;


import Model.FreeSpace;
import Model.GUnit;
import Model.gameLogic;
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
    
    @Override   
    public void turn(RandomGenerator RG) {
    	Player player = gameLogic.getPlayer();
    	int dx, dy;
    	Double distance = distanceFrom(player);
    	if( distance.equals(1.0)) {
    		attack((GUnit)player, RG);
    		}
    	else if(distance<=visionRange) {
    		dx = x - player.getX();
    		dy = y - player.getY();
    		if(Math.abs(dx)>Math.abs(dy)) {
    			if(dx>0) move(-1,0);
    			else move(1,0);
    		}
    		else {
    			if( dy>0) move(0,-1);
    			else move(0,1);
    		}
    	}
    	else { //player not in range
    		int[] move = XYComponents(RG.nextInt(5));
    		dx = move[0];
    		dy = move[1];
    		move(dx, dy);
    	}    	
    }


    public void move(int dx, int dy) {
    	if(canMove(dx,dy)==1) {
	    	board[x][y]= new FreeSpace(x,y);
	    	board[x + dx][y + dy] = this;
	    	x = x + dx;
	    	y = y + dy;
    	}
    }
    
    
    public int canMove(int dx, int dy) {
    	int output;
    	if(dx==dy)output = 3;
    	else output = invoke(x + dx, y + dy);
    	return output;
    	
    }
    

    public int[] XYComponents(int move) {
    	int[] output = new int[2];
    	output[0]=0;
    	output[1]=0;  
    	//represents {dx,dy}
    	switch(move) {
    	case 1: output[0]=-1; break; //left
    	case 2: output[0]=1;  break; //right
    	case 3: output[1]=1;  break; //down
    	case 4: output[1]=-1; break; //up
    	}
    	return output;
    }
     

}
