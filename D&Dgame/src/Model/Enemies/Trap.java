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
        range=range;
        reSpawn=reSpawn;
        visTime=visTime;
        visible = true;
    }

    @Override
    public void turn(RandomGenerator RG) {
        if(wait >= visTime)visible = false;
        if(wait >= reSpawn){
            visible = true;
            reSpawn(RG);
            wait = 0;
        }
        else wait++;


    }
    public int invoked(Enemy enemy){
        return 1;
    }

    private void reSpawn(RandomGenerator RG) {
        int newX = x;
        int newY = y;
        int interaction = 3;
        while(interaction != 1) {
            if (RG.hasNext()) newX =y + RG.nextInt(2 * range) - range;
            if (RG.hasNext()) newY =y + RG.nextInt(2 * range) - range;
            interaction = invoke(newX,newY);
        }
        wait=0;
        visible =true;
        board[x][y] = new FreeSpace(x,y);
        x = newX;
        y = newY;
        board[x][y] = this;
    }

}
