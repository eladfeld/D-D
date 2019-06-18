package Controller.Moves;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class FreePlay extends KeyAdapter implements ActionReader {
    public Character move;
    @Override
    public boolean hasNext() {
        return true;
    }

        //https://www.youtube.com/watch?v=bWHYjLJZswQ&t=469s
        //good tutorial about key event /key input

        public void keyPressed(KeyEvent event){
            int i = event.getKeyChar();
            System.out.println(i);
        }
    @Override //asks user for next action and returns it
    public String nextAction() {
        Scanner S = new Scanner(System.in);
        String move = S.nextLine();
        return move;

        //        try {
//            int char = (int)RawConsoleInput.read(false);
//            System.out.println(char);
//            RawConsoleInput.resetConsoleMode();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "s";

    }
}
