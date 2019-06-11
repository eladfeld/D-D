package Controller;

import Controller.Moves.*;
import Model.gameLogic;
import View.Presentetion;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class gameControl {
    public static void main(String[] args) throws Exception {

        String dir = args[0];
        long lineCount = 0;
        boolean hasAnotherLevel = true;
        //change levelNum back to 1 before submision
        //level 0 for testing purposes
        int levelNum = 1;
        File level = null;
        RandomGenerator RandomNums;
        ActionReader PlayerActions;
        if (args.length > 1) {
            RandomNums = new DeterNum(Proccesor.tickProccesor(dir + "\\random_numbers.txt"));
            PlayerActions = new DeterAction(Proccesor.moveProccesor(dir + "\\user_actions.txt"));
        }else {
	        RandomNums = new RandomNum();
	        PlayerActions = new FreePlay();
        }
        Presentetion presentetion = (Presentetion) Presentetion.getInstance();
        presentetion.GameStart();
//Deterministic mode does not account for being asked to play again        
//        String playAgain = "y";
//        while (playAgain.equalsIgnoreCase("y")) {
        	gameLogic GL = null;
            while (hasAnotherLevel) {
                String locetion = dir + "\\level " + levelNum + ".txt";
                try {
                    Path path = Paths.get(locetion);
                    lineCount = Files.lines(path).count();
                    level = new File(locetion);
                } catch (IOException e) {
                    break;
                }
                char[][] board = Proccesor.boardProccesor(level, (int) lineCount);
                //change levelNum==1 before submitting
                if (GL == null) GL = new gameLogic(PlayerActions, RandomNums, board);
                else GL = new gameLogic(PlayerActions, RandomNums, board, gameLogic.getPlayer());
                while (GL.isActiveGame()) {
                    presentetion.ShowGame();
                    GL.gameTick();
                }
                if (!gameLogic.getPlayer().isAlive()) {
//                    playAgain = presentetion.GameOver();
                	presentetion.GameOver();
                    break;
                } else levelNum++;
            }
//        }   //(closer bracket from the while loop asking to play again)
        Presentetion.gameFinishd();
    }
}
