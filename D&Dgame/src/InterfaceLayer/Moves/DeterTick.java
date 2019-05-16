package InterfaceLayer.Moves;

public class DeterTick implements RandomGenerator {
    int[] Random;
    int index;
    public DeterTick(int[] Random){
        Random=Random;
        index=-1;
    }

    public int nextInt(int n) {
        index++;
        return Random[index];
    }
}
