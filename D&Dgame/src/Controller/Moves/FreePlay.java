package Controller.Moves;


import java.util.Scanner;
public class FreePlay  implements ActionReader {
    @Override
    public boolean hasNext() {
        return true;
    }


    @Override //asks user for next action and returns it
    public String nextAction() {
        Scanner S = new Scanner(System.in);
        String move = S.nextLine();
        //S.close();
        return move;

    }
}
