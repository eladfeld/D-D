package InterfaceLayer;

import InterfaceLayer.Moves.*;
import LogicLayer.gameLogic;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class gameControl {
public static void main(String[]args)throws Exception
{
    String dir = args[0];

    long lineCount = 0;
    boolean hasAnotherLevel = true;
    int levelNum = 1;
    File level = null;
    ActionReader PlayerActions = new FreePlay();
    RandomGenerator RandomNums = new RandomNum();

    while(hasAnotherLevel){
        String locetion = dir + "\\level " + levelNum + ".txt";
        try {
            Path path = Paths.get(locetion);
            lineCount = Files.lines(path).count();
            level = new File(locetion);
            if(args.length > 1){
               RandomNums = new DeterNum(Proccesor.tickProccesor(dir + "\\random_numberts:txt"));
               PlayerActions = new DeterAction(Proccesor.moveProccesor(dir+ "\\user_actions:txt"));
            }
        } catch (IOException e) {
            System.out.println("Level " + levelNum + " does not exist" + '\n' +  e.getCause());
            e.printStackTrace();
        }
        gameLogic GL = new gameLogic(PlayerActions , RandomNums , level, (int)lineCount);
        while(GL.isActiveGame()){

            /*
            need to add another stop
            one in case the player is dead
            second in case the level is finished
            */
            GL.gameTick();
            System.out.println(GL.toString());
        }
        levelNum++;


    }
}

}
