package LogicLayer.Enemies;
import InterfaceLayer.Moves.RandomGenerator;
import LogicLayer.gameObject;

public class Trap extends Enemy {
    int range , reSpawn, visTime;
    int wait = 0;
    boolean visible;

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
                int AP,int expValue , char tile ,int inSight ,
                int range ,int reSpawn , int visTime , gameObject[][] board)
    {
        super(x,y,name,HP,DP,AP,expValue,tile,inSight,board);
        range=range;
        reSpawn=reSpawn;
        visTime=visTime;
        visible = true;
    }

    @Override
    public void gameTick(RandomGenerator RG) {
        if(wait >= visTime)visible = false;
        if(wait >= reSpawn){
            visible = true;
            reSpawn();
            wait = 0;
        }
        else wait++;


    }

    private void reSpawn() {

    }
}
