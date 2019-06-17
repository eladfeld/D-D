package Model.Enemies;


import Controller.Moves.RandomGenerator;
import Model.FreeSpace;
import Model.gameObject;

public class Monster extends Enemy {

    int visionRange; //how far away the monster can see a player

    public Monster(int x, int y, String name, int HP, int DP, int AP, int expValue, char tile, int visionRange, gameObject[][] board) {
        super(x, y, name, HP, DP, AP, expValue, tile, board);
        this.visionRange = visionRange;
    }

    //returns a value determing the consequences of an enemy stepping into this monster's place
    public int invoked(Enemy enemy) {
        return 3;
    }

    @Override   //determines the proper move for the monster
    public void turn(RandomGenerator RG) {
        gameObject player = searchForPlayer();
        int dx, dy, Px, Py;
        if (player != null) { //player in range
            Px = player.getX();
            Py = player.getY();
            if (distanceFrom(Px, Py) == 1.0) attack(player, RG);
            else {
                dx = x - Px;
                dy = y - Py;
                if (Math.abs(dx) > Math.abs(dy)) {
                    if (dx > 0) move(-1, 0);
                    else move(1, 0);
                } else {
                    if (dy > 0) move(0, -1);
                    else move(0, 1);
                }
            }
        } else { //player not in range
            int[] move = XYComponents(RG.nextInt(5));
            dx = move[0];
            dy = move[1];
            move(dx, dy);
        }
    }

    private gameObject searchForPlayer() {   //need to test!!!!
        int topBound = Math.max(y - visionRange, 0);
        int bottomBound = Math.min(y + visionRange, board[0].length - 1);
        int leftBound = Math.max(x - visionRange, 0);
        int rightBound = Math.min(x + visionRange, board.length - 1);
        for (int i = topBound; i <= bottomBound; i++)
            for (int j = leftBound; j <= rightBound; j++)
                if ((i != y | j != x) & distanceFrom(j, i) <= visionRange & invoke(j, i) == 2) return board[j][i];
        return null;
    }

    //moves the monster
    public void move(int dx, int dy) {
        if (canMove(dx, dy) == 1) {
            board[x][y] = new FreeSpace(x, y);
            board[x + dx][y + dy] = this;
            x = x + dx;
            y = y + dy;
        }
    }

    //determines if move is legal
    public int canMove(int dx, int dy) {
        int output;
        if (dx == dy) output = 3;
        else output = invoke(x + dx, y + dy);
        return output;

    }

    //receives a number 0-4 and returns an ordered pair (x,y)
    public int[] XYComponents(int move) {
        int[] output = new int[2];
        output[0] = 0;
        output[1] = 0;
        //represents {dx,dy}
        switch (move) {
            case 1:
                output[0] = -1;
                break; //left
            case 2:
                output[0] = 1;
                break; //right
            case 3:
                output[1] = 1;
                break; //down
            case 4:
                output[1] = -1;
                break; //up
        }
        return output;
    }


}
