package Model;

import Controller.Moves.*;
import Model.Enemies.*;
import Model.Players.Mage;
import Model.Players.Player;
import Model.Players.Rogue;
import Model.Players.Warrior;
import View.MyObserver;
import View.Presentetion;

import java.util.LinkedList;
import java.util.List;


public class gameLogic {
    private ActionReader playerMove;
    private RandomGenerator RandomNum;
    private gameObject[][] board;
    private List<Enemy> enemies;
    private static Player player = null;
    private boolean activeGame;

    public static Player getPlayer() {
    	return player;
    }
    public boolean isActiveGame() {
        return activeGame;
    }


    public gameLogic(ActionReader AR, RandomGenerator RG, char[][] level) {
        enemies = new LinkedList<Enemy>();
        activeGame = true;
        playerMove = AR;
        RandomNum = RG;
        askForPlayerType(AR);
        board = levelProccesor(level);
        player.setBoard(board);

    }
    public gameLogic(ActionReader AR, RandomGenerator RG, char[][] level, Player player) {
        enemies = new LinkedList<Enemy>();
        activeGame = true;
        playerMove = AR;
        RandomNum = RG;
        gameLogic.player = player;
        board = levelProccesor(level);
        player.setBoard(board);

    }

    private void askForPlayerType(ActionReader ar) {
        int choose = 0;
        try {
            choose = Integer.parseInt(ar.nextAction());
        } catch (Exception e) {
            e.printStackTrace();
        }
        switch (choose) {

        	//case 0 for testing purposes
        	case 0:
	            player = new Warrior(0, 0, "T-Baby", 100, 10, 500, board, 60);
	            break;
        	
            case 1:
                player = new Warrior(0, 0, "Jon Snow", 300, 4, 30, board, 6);
                break;
            case 2:
                player = new Warrior(0, 0, "The hound", 400, 6, 20, board, 4);
                break;

            case 3:
                player = new Mage(0, 0, "Malisandre", 160, 1, 10, board, 40, 300, 30, 5, 6);
                break;
            case 4:
                player = new Mage(0, 0, "Thoros of Myr", 250, 3, 25, board, 15, 150, 50, 3, 3);
                break;
            case 5:
                player = new Rogue(0, 0, "arya stark", 150, 2, 40, board, 20);
                break;
            case 6:
                player = new Rogue(0, 0, "Bronn", 250, 3, 35, board, 60);
                break;
        }
        Presentetion.PlayerChosen(player.getPlayerStatus());
    }

    private gameObject[][] levelProccesor(char[][] board) {
        char c;
        int width = board.length;
        int length = board[0].length;
        gameObject[][] output = new gameObject[width][length];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                c = board[i][j];
                gameObject GO = null;
                boolean isEnemy = false;
                switch (c) {
                    case '.':
                        GO = new FreeSpace(i, j);
                        break;
                    case '#':
                        GO = new Wall(i, j);
                        break;
                    case '@':
                        player.x = i;
                        player.y = j;
                        GO = player;
                        break;
                    //have function receive parameter for player so it knows how to point at it
                    case 'X':
                        //need to understand what to do here!!!
                        break;

                    case 's':
                        GO = new Monster(i, j, "Lannister Soldier", 80, 3, 8, 25, c, 3, output);
                        isEnemy = true;
                        break;
                    case 'k':
                        GO = new Monster(i, j, "Lannister Knight", 200, 8, 14, 50, c, 4, output);
                        isEnemy = true;
                        break;
                    case 'q':
                        GO = new Monster(i, j, "Queen's Guard", 400, 15, 20, 100, c, 5, output);
                        isEnemy = true;
                        break;
                    case 'z':
                        GO = new Monster(i, j, "Wright", 600, 15, 30, 100, c, 3, output);
                        isEnemy = true;
                        break;
                    case 'b':
                        GO = new Monster(i, j, "Bear Wright", 1000, 30, 75, 250, c, 4, output);
                        isEnemy = true;
                        break;
                    case 'g':
                        GO = new Monster(i, j, "Giant Wright", 1500, 40, 100, 500, c, 5, output);
                        isEnemy = true;
                        break;
                    case 'w':
                        GO = new Monster(i, j, " White Walker", 2000, 50, 150, 1000, c, 6, output);
                        isEnemy = true;
                        break;
                    case 'M':
                        GO = new Monster(i, j, "The Mountain", 1000, 25, 60, 500, c, 6, output);
                        isEnemy = true;
                        break;
                    case 'C':
                        GO = new Monster(i, j, "Queen Cersei", 100, 10, 10, 1000, c, 1, output);
                        isEnemy = true;
                        break;
                    case 'K':
                        GO = new Monster(i, j, "Night's King", 5000, 150, 300, 5000, c, 8, output);
                        isEnemy = true;
                        break;

                    case 'B':
                        GO = new Trap(i, j, "Bonus Trap", 1, 1, 1, 250, c, 5, 6, 2, output);
                        isEnemy = true;
                        break;
                    case 'Q':
                        GO = new Trap(i, j, "Queen's Trap", 250, 10, 50, 100, c, 4, 5, 6, output);
                        isEnemy = true;
                        break;
                    case 'D':
                        GO = new Trap(i, j, "Death Trap", 500, 20, 100, 250, c, 6, 10, 3, output);
                        isEnemy = true;
                        break;
                }
                output[i][j] = GO;
                if (isEnemy) enemies.add((Enemy) GO); //adds to enemy list
            }
        }
        return output;
    }

    public void gameTick() {
        MyObserver observer = Presentetion.getInstance();
        observer.update(boardToString(board));
        player.turn(playerMove, RandomNum);
        for (int i = 0; i < enemies.size(); i++) {
            GUnit enemy = enemies.get(i);
            if (enemy.isAlive()) enemy.turn(RandomNum);
            else {
            	board[enemy.getX()][enemy.getY()]=new FreeSpace(enemy.getX(),enemy.getY());
            	enemies.remove(i);
            }
        
        }
        activeGame = player.isAlive() & enemies.size()>0; //player is alive and enemies are also alive
    }

    public static String boardToString(gameObject[][] board) {
        String output = "";
        gameObject GO;
        for (int j = 0; j < board[0].length; j++) {
        	for (int i = 0; i < board.length; i++) {	
                if(board[i][j].isVisible()) 
                	output = output + board[i][j];
                else output = output + ".";
            }
            output += "\n";
        }
        return output;
    }
    
    
}