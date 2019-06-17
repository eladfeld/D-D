package Controller.Moves;

//represents predetermined list of pseudo-random numbers
public class DeterNum implements RandomGenerator {
    private int[] Random;
    private int index;
    public DeterNum(int[] Random){
        this.Random=Random;
        index=-1;
    }
    
    //returns next  predetermined "random" number
    public int nextInt(int n) {
        index++;
        return Random[index]%n;
    }

    @Override
    public boolean hasNext() {
        return index < Random.length -1;
    }
}
