package Controller.Moves;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class keyInput extends KeyAdapter {

    FreePlay freePlay;

    public keyInput() {
    }

    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();
        System.out.println(key);
    }

}
