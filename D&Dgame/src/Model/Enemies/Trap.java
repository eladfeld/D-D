package Model.Enemies;
import Controller.Moves.RandomGenerator;
import Model.FreeSpace;
import Model.gameObject;

public class Trap extends Enemy {
    private int range , reSpawn, visTime;
    private int wait = 0;
    private boolean visible;

    //region Getters and Setters
    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getReSpawn() {
        return reSpawn;
    }

    public void setReSpawn(int reSpawn) {
        this.reSpawn = reSpawn;
    }

    public int getVisTime() {
        return visTime;
    }

    public void setVisTime(int visTime) {
        this.visTime = visTime;
    }
    //endregion

    public Trap(int x, int y, String name, int HP , int DP ,
                int AP,int expValue , char tile ,int range ,
                int reSpawn , int visTime , gameObject[][] board)
    {
        super(x,y,name,HP,DP,AP,expValue,tile,board);
        this.range=range;
        this.reSpawn=reSpawn;
        this.visTime=visTime;
        visible = true;
    }

    @Override
    public void turn(RandomGenerator RG) {
        if(wait >= visTime)visible = false;
        int[] AP = adjacentPlayer();
        if (AP[0] != 0 || AP[1] != 0 ) attack(board[x+AP[0]][y+AP[1]], RG);
        else if(wait == reSpawn){
            visible = true;
            reSpawn(RG);
        }
        wait = (wait+1) % reSpawn;        
    }
    
    
    //returns relative position of adjacent player
    //returns {0,0} if no player is adjacent
    private int[] adjacentPlayer() {
    	int[] output = {0,0};
    	for(int dx=-1 ; dx<=1 ; dx++) {
    		for(int dy=-1 ; dy<=1 ; dy++) {
    			if((dx != 0 & dy != 0) && invoke(x+dx, y+dy)==2) {
    				output[0]=dx;
    				output[1]=dy;
    			}
    		}
    	}
    		
    	return output;
    }
    public int invoked(Enemy enemy){
        return 1;
    }

    private void reSpawn(RandomGenerator RG) {
        int newX = x;
        int newY = y;
        boolean hasSpawned = false;;
        while(hasSpawned == false) {
        	if (RG.hasNext()) newX =y + RG.nextInt(2 * range) - range;
            if (RG.hasNext()) newY =y + RG.nextInt(2 * range) - range;
            if(isOnBoard(newX, newY)==false) reSpawn(RG);            
            else {
            	 int result = invoke(newX, newY);
            	 if(result==1 || result==3) reSpawn(RG);
            	 else {
            		 board[x][y] = new FreeSpace(x,y);
            		 board[newX][newY] = this;
            		 x = newX;
            		 y = newY;
            		 hasSpawned = true;
            		 visible = true;
            		 wait = 0;
            	 }
            	 
            }        	
            //not sure this function stay
        	//if (RG.hasNext()) newX =y + RG.nextInt(2 * range) - range;
            //if (RG.hasNext()) newY =y + RG.nextInt(2 * range) - range;
          	//if(RG.hasNext())
            //interaction = invoke(newX,newY);
        }
        wait=0;
        visible =true;
        board[x][y] = new FreeSpace(x,y);
        x = newX;
        y = newY;
        board[x][y] = this;
    }
    
    private boolean isOnBoard(int x, int y) {
    	return (y>=0 && y<board.length && x>=0 && x<board[0].length);
    }

}
