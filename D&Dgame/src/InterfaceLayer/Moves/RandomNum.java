package InterfaceLayer.Moves;
import InterfaceLayer.Moves.RandomGenerator;

import java.util.Random;
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
