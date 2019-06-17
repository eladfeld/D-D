package Controller.Moves;


import java.util.Scanner;
public class FreePlay  implements ActionReader {
    @Override
    public boolean hasNext() {
        return true;
    }

        //https://www.youtube.com/watch?v=bWHYjLJZswQ&t=469s
        //good tutorial about key event /key input

    @Override //asks user for next action and returns it
    public String nextAction() {
        Scanner S = new Scanner(System.in);
        String move = S.nextLine();
        return move;

    }
}
