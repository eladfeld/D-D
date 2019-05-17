package LogicLayer;

import InterfaceLayer.Moves.*;
import LogicLayer.Enemies.Enemy;

import java.io.File;
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
        board = levelProccesor( char[][] level);
        player = askForPlayerType(AR);
    }

    private Player askForPlayerType(ActionReader ar) {
        int choose;
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

            return output;
        }

        private gameObject[][] levelProccesor ( char[][] board){
            char c;
            int width = board.length;
            int length = board[0].length;
            GameObject[][] output = new GameObject[width][length];
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < length; j++) {
                    c = board[i][j];
                    GameObject GO;
                    swicth(c) {
                        case '.':
                            GO = new FreeSpace(i, j);
                        case '#':
                            GO = new Wall(i, j);
                        case '@':
                            GO = new Player(i, j);
                        case 'X':
                            GO = new DeadPlayer(i, j);

                        case 's':
                            GO = new Monster(i, j, "Lannister Soldier", 80, 3, 8, 25, c, 3);
                        case 'k':
                            GO = new Monster(i, j, "Lannister Knight", 200, 8, 14, 50, c, 4);
                        case 'q':
                            GO = new Monster(i, j, "Queen's Guard", 400, 15, 20, 100, c, 5);
                        case 'z':
                            GO = new Monster(i, j, "Wright", 600, 15, 30, 100, c, 3);
                        case 'b':
                            GO = new Monster(i, j, "Bear Wright", 1000, 30, 75, 250, c, 4);
                        case 'g':
                            GO = new Monster(i, j, "Giant Wright", 1500, 40, 100, 500, c, 5);
                        case 'w':
                            GO = new Monster(i, j, " White Walker", 2000, 50, 150, 1000, c, 6);
                        case 'M':
                            GO = new Monster(i, j, "The Mountain", 1000, 25, 60, 500, c, 6);
                        case 'C':
                            GO = new Monster(i, j, "Queen Cersei", 100, 10, 10, 1000, c, 1);
                        case 'K':
                            GO = new Monster(i, j, "Night's King", 5000, 150, 300, 5000, c, 8);

                        case 'B':
                            GO = new Trap(i, j, "Bonus Trap", 1, 1, 1, c, 26);
                        case 'Q':
                            GO = new QueensTrap(i, j);
                        case 'D':
                            GO = new DeathTrap(i, j);
                    }
                    output[i][j] = GO;
                    if (GO.isEnemy()) {
                    } //add to enemy list
                }
            }
            //need to implement!!!!
            return null;
        }

        public void gameTick () {
            player.gameTick();
            for (int i = 0; i < enemies.size(); i++) {
                Enemy enemy = enemies.get(i);
                if (enemy.isAlive()) enemy.gameTick(enemyMove);
                else enemies.remove(i);
            }
            activeGame = player.isAlive();

        }
    }
}
