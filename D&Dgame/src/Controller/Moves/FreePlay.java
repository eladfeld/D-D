package Controller.Moves;

import java.util.Scanner;
public class FreePlay  implements ActionReader {
    @Override
    public boolean hasNext() {
        return true;
    }

    // https://www.youtube.com/watch?v=bWHYjLJZswQ
    // a very good tutorial about key event and event handler within the game!
    //try to implement it in out game!!

    @Override
    public String nextAction() {
        Scanner S = new Scanner(System.in);
        String move = S.nextLine();
        S.close();
        return move;

    }
}
