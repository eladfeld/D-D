package Controller.Moves;

public class DeterNum implements RandomGenerator {
    private int[] Random;
    private int index;
    public DeterNum(int[] Random){
        Random=Random;
        index=-1;
    }

    public int nextInt(int n) {
        index++;
        return Random[index]%n;
    }

    @Override
    public boolean hasNext() {
        return index < Random.length -1;
    }
}
