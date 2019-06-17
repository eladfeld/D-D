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
        int levelNum = 1;
        File level = null;
        RandomGenerator RandomNums;
        ActionReader PlayerActions;
        if (args.length>1 && args[1].equals("-D")) {
            RandomNums = new DeterNum(Proccesor.tickProccesor(dir + "\\random_numbers.txt"));
            PlayerActions = new DeterAction(Proccesor.moveProccesor(dir + "\\user_actions.txt"));
        }else {
	        RandomNums = new RandomNum();
	        PlayerActions = new FreePlay();
        }
        Presentetion presentetion = (Presentetion) Presentetion.getInstance();
        presentetion.GameStart();
        	gameLogic GL = null;
            while (hasAnotherLevel) {
                String locetion = dir + "\\level " + levelNum + ".txt";
                try {
                    Path path = Paths.get(locetion);
                    lineCount = Files.lines(path).count();
                    level = new File(locetion);
                } catch (IOException e) {
                	hasAnotherLevel = false;
                }if(hasAnotherLevel) {
                    char[][] board = Proccesor.boardProccesor(level, (int) lineCount);
                    if (GL == null) GL = new gameLogic(PlayerActions, RandomNums, board);
                    else GL = new gameLogic(PlayerActions, RandomNums, board, gameLogic.getPlayer());
                    while (GL.isActiveGame()) {
                        GL.gameTick();
                    }
                    if (!gameLogic.getPlayer().isAlive()) {
                        presentetion.GameOver();
                        break;
                    } else {
                        levelNum++;
                        presentetion.levelUp(levelNum);
                    }
                }
            }
        Presentetion.gameFinishd();
    }
}
