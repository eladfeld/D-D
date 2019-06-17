package Controller.Moves;

import java.util.Random;
//generates pseudo random numbers
public class RandomNum implements RandomGenerator {
    @Override
    public int nextInt(int n) {
        Random R = new Random();
        return R.nextInt(n);
    }

    @Override
    public boolean hasNext() {
        return true;
    }
}
