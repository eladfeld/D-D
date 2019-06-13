package Model.Players;

import Controller.Moves.ActionReader;
import Controller.Moves.DeterAction;
import Controller.Moves.DeterNum;
import Controller.Moves.RandomGenerator;
import Model.Enemies.Enemy;
import Model.gameLogic;
import org.junit.Assert;
import org.junit.Test;

public class RogueTest {

    //tests battle between player and enemy
    gameLogic GL = null;

    @Test
    public  void testAttack() {
        //@Before
        char[][] level = {{'@', '.'}, {'L', '.'}};
        int[] numbers = {20, 10, 30, 5};
        RandomGenerator RG = new DeterNum(numbers);
        String[] actions = {"7", "d", "q", "q", "q", "q"};
        gameLogic GL = new gameLogic(new DeterAction(actions), RG, level);
        Player player = gameLogic.getPlayer();
        Enemy monster = gameLogic.getEnemies().get(0);
        player.attack(monster, RG);
        monster.attack(player, RG);
        //@Test
        try {
            Assert.assertEquals("Monster health should be: 90 \n actual result: " + monster.getCurrHP(), 90, monster.getCurrHP(), 0);
            Assert.assertEquals("Mage health should be: 75 \n actual result: " + player.getCurrHP(), 75, player.getCurrHP(), 0);
            System.out.println("Attack Test Passed");
        } catch (Exception e) {
            System.out.println("Attack Test Failed");
        }
        //@After

    }
    @Test
    public  void testMove() {
        //@Before
        char[][] level = {{'@', '.'}, {'L', '.'}};
        int[] numbers = {0, 0, 0, 0};
        RandomGenerator RG = new DeterNum(numbers);
        String[] actions = {"7", "d", "q", "q", "q", "q"};
        ActionReader AR = new DeterAction(actions);
        gameLogic GL = new gameLogic(new DeterAction(actions), RG, level);
        Player player = gameLogic.getPlayer();
        Enemy monster = gameLogic.getEnemies().get(0);
        player.turn(AR, RG);
        monster.turn(RG);//monster should ignore the '0' and chase the player
        //@Test
        try {
            Assert.assertEquals(0, player.getX(), 0);
            Assert.assertEquals(1, monster.getX(), 0);
            System.out.println("Move Test Passed");
        } catch (Exception e) {
            System.out.println("Move Test Failed");
        }
    }


    @Test
    public void specialStats() {
    }

    @Test
    public void getCurrEnerg() {
    }

    @Test
    public void setCurrEnerg() {
    }

    @Test
    public void getCost() {
    }

    @Test
    public void setCost() {
    }

    @Test
    public void special() {
    }

    @Test
    public void turn() {
    }

    @Test
    public void levelUp() {
    }
}