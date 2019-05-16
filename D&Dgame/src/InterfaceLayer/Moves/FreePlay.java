package InterfaceLayer.Moves;
import InterfaceLayer.Moves.ActionReader;

import java.util.Scanner;
public class FreePlay implements ActionReader {
    @Override
    public String nextAction() {
        Scanner S = new Scanner(System.in);
        String move = S.nextLine();
        return move;

    }
}
