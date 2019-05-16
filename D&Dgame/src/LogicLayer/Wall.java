package LogicLayer;

public class Wall extends gameObject{
    int x,y;
    public Wall(int x,int y) {
        super(x,y);
    }
    public String toStirng(){
        return "#";
    }
}
