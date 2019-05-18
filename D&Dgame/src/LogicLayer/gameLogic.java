package LogicLayer;

import InterfaceLayer.Moves.*;
import LogicLayer.Enemies.*;
import LogicLayer.Players.Player;


import java.util.LinkedList;
import java.util.List;



public class gameLogic {
    private ActionReader playerMove;
    private RandomGenerator enemyMove;
    private gameObject[][] board;
    private List<Enemy> enemies;
    private Player player = null;
    private boolean activeGame;

    public boolean isActiveGame() {
        return activeGame;
    }


    public gameLogic(ActionReader AR, RandomGenerator RG, char[][] level, int height) {
        enemies = new LinkedList<Enemy>();
        activeGame = true;
        playerMove = AR;
        enemyMove = RG;
        player = askForPlayerType(AR);
        board = levelProccesor(level , player);

    }

    private Player askForPlayerType(ActionReader ar) {
        int choose = 0;
        try {
            choose = Integer.parseInt(ar.nextAction());
        } catch (Exception e) {
            e.printStackTrace();
        }


        Player output = null;
        switch (choose) {

            case 1:
                //need to impliment
                break;
            case 2:
                //need to impliment
                break;

            case 3:
                //need to impliment
                break;

            case 4:

                //need to impliment
                break;

        }
        return output;
    }

                private gameObject[][] levelProccesor (char[][] board, Player player){
                    char c;
                    int width = board.length;
                    int length = board[0].length;
                    gameObject[][] output = new gameObject[width][length];
                    for (int i = 0; i < width; i++) {
                        for (int j = 0; j < length; j++) {
                            c = board[i][j];
                            gameObject GO;
                            switch (c) {
                                case '.':
                                    GO = new FreeSpace(i, j);
                                    break;
                                case '#':
                                    GO = new Wall(i, j);
                                case '@':
                                    player.setX(i);
                                    player.setY(j);
                                    GO = player;
                                    break;
                                //have function receive parameter for player so it knows how to point at it
                                case 'X':
                                    //need to understand what to do here!!!
                                    break;

                                case 's':
                                    GO = new Monster(i, j, "Lannister Soldier", 80, 3, 8, 25, c, 3, output);
                                    break;
                                case 'k':
                                    GO = new Monster(i, j, "Lannister Knight", 200, 8, 14, 50, c, 4, output);
                                    break;
                                case 'q':
                                    GO = new Monster(i, j, "Queen's Guard", 400, 15, 20, 100, c, 5, output);
                                    break;
                                case 'z':
                                    GO = new Monster(i, j, "Wright", 600, 15, 30, 100, c, 3, output);
                                    break;
                                case 'b':
                                    GO = new Monster(i, j, "Bear Wright", 1000, 30, 75, 250, c, 4, output);
                                    break;
                                case 'g':
                                    GO = new Monster(i, j, "Giant Wright", 1500, 40, 100, 500, c, 5, output);
                                    break;
                                case 'w':
                                    GO = new Monster(i, j, " White Walker", 2000, 50, 150, 1000, c, 6, output);
                                    break;
                                case 'M':
                                    GO = new Monster(i, j, "The Mountain", 1000, 25, 60, 500, c, 6, output);
                                    break;
                                case 'C':
                                    GO = new Monster(i, j, "Queen Cersei", 100, 10, 10, 1000, c, 1, output);
                                    break;
                                case 'K':
                                    GO = new Monster(i, j, "Night's King", 5000, 150, 300, 5000, c, 8, output);
                                    break;

                                case 'B':
                                    GO = new Trap(i, j, "Bonus Trap", 1, 1, 1, c, 26, output);
                                    break;
                                case 'Q':
                                    GO = new Trap(i, j, "Queen's Trap", 250, 10, 50, 100, c, 4, 5, 6, 2, output);
                                    break;
                                case 'D':
                                    GO = new Trap(i, j, "Death Trap", 500, 20, 100, 250, c, 6, 10, 3, output);
                                    break;
                            }
                            output[i][j] = GO;
                            if (GO.isEnemy()) enemies.add(GO); //adds to enemy list
                        }
                    }
                    return output;
                }

                public void gameTick (){
                    player.gameTick(playerMove ,enemyMove );
                    for (int i = 0; i < enemies.size(); i++) {
                        GUnit enemy = enemies.get(i);
                        if (enemy.Alive) enemy.gameTick(enemyMove);
                        else enemies.remove(i);
                    }
                    activeGame = player.Alive;
                }
            }
        }
    }
}