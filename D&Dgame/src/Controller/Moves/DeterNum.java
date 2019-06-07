package Controller.Moves;

public class DeterNum implements RandomGenerator {
    int[] Random;
    int index;
    public DeterNum(int[] Random){
        Random=Random;
        index=-1;
    }

    public int nextInt(int n) {
        index++;
        return Random[index];
    }

    @Override
    public boolean hasNext() {
        return index < Random.length -1;
    }
}
