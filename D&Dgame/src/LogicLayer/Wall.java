package LogicLayer;

public class Wall extends gameObject{
    int x,y;
    public Wall(int x,int y) {
        super(x,y);
    }

    @Override
    public int invoked(GUnit gUnit) {
        return 3;
    }

    public String toStirng(){
        return "#";
    }

}
