package Controller.Moves;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class keyInput extends KeyAdapter {

    FreePlay freePlay;

    public keyInput(FreePlay freePlay){
        this.freePlay = freePlay;
    }

    public void keyPressed(KeyEvent event){
        //char key = 
        		event.getKeyChar();

    }

}
