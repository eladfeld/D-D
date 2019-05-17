package InterfaceLayer.Moves;
import InterfaceLayer.Moves.ActionReader;

import java.util.Scanner;
public class FreePlay implements ActionReader {
    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public String nextAction() {
        Scanner S = new Scanner(System.in);
        String move = S.nextLine();
        S.close();
        return move;

    }
}
