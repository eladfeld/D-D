package Model.Enemies;

import Controller.Moves.RandomGenerator;
import Model.FreeSpace;
import Model.gameObject;
import java.util.LinkedList;
import java.util.List;

public class Trap extends Enemy {
    private int range, reSpawn, visTime;
    private int tickCount = 0;
    private char T;

    //region Getters and Setters
    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getReSpawn() {
        return reSpawn;
    }

    public void setReSpawn(int reSpawn) {
        this.reSpawn = reSpawn;
    }

    public int getVisTime() {
        return visTime;
    }

    public void setVisTime(int visTime) {
        this.visTime = visTime;
    }
    //endregion

    public Trap(int x, int y, String name, int HP, int DP,
                int AP, int expValue, char tile, int range,
                int reSpawn, int visTime, gameObject[][] board) {
        super(x, y, name, HP, DP, AP, expValue, tile, board);
        T = tile;
        this.range = range;
        this.reSpawn = reSpawn;
        this.visTime = visTime;
    }

    @Override //decided how the trap will play (dis/appear, attack, nothing)
    public void turn(RandomGenerator RG) {
        int[] enemy;
        if ((enemy = EnemyNear()) != null)
            attack(board[enemy[0]][enemy[1]], RG);
        else if (tickCount >= reSpawn) {
            reSpawn(RG);
            tickCount = 0;
        } else tickCount++;
        visible(tickCount);
    }

    //sets the visibilty of the trap based on the game clock
    private void visible(int tickCount) {
        if (tickCount >= visTime) Tile = '.';
        else Tile = T;
    }

    //returns ordered pair of a players relative coordinates if the player is distance=1 from trap
    private int[] EnemyNear() {
        if (invoke(x + 1, y) == 2) return new int[]{x + 1, y};
        if (invoke(x - 1, y) == 2) return new int[]{x - 1, y};
        if (invoke(x, y + 1) == 2) return new int[]{x, y + 1};
        if (invoke(x, y - 1) == 2) return new int[]{x, y - 1};
        return null;
    }

    //returns value representing the consequences of an enemy attempting to step into the trap
    public int invoked(Enemy enemy) {
        return 3;
    }

    //finds a free space on the board within range and respawns there
    private void reSpawn(RandomGenerator RG) {
        int topBound = Math.max(y - range, 0);
        int bottomBound = Math.min(y + range, board[0].length - 1);
        int leftBound = Math.max(x - range, 0);
        int rightBound = Math.min(x + range, board.length - 1);
        List<int[]> freeSpaces = new LinkedList<int[]>();
        for (int i = topBound; i <= bottomBound; i++)
            for (int j = leftBound; j <= rightBound; j++)
                if (distanceFrom(j,i) <= range & invoke(j, i) == 1) freeSpaces.add(new int[]{j, i});
        int[] newPlace = {x, y};
        if (freeSpaces.size() > 0)
            newPlace = freeSpaces.get(RG.nextInt(freeSpaces.size()));
        int newX = newPlace[0];
        int newY = newPlace[1];
        board[x][y] = new FreeSpace(x, y);
        x = newX;
        y = newY;
        board[x][y] = this;
    }
}
