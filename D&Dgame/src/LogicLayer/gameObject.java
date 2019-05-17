package LogicLayer;

public abstract class gameObject {
    int x;
    int y;

    //region Getters and Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    //endregion

    public gameObject(int x,int y){
        x=x;
        y=y;
    }
   public String toString(){
        return ".";
   }

    public abstract int invoked(GUnit gUnit);
}
