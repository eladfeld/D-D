package LogicLayer;

import InterfaceLayer.Moves.*;
import java.io.File;
import java.util.LinkedList;
import java.util.List;


public class gameLogic {
   private ActionReader  playerMove;
   private RandomGenerator enemyMove;
   private gameObject[][] board;
   private List<GUnit> enemies;
   private Player player = null;
   private boolean activeGame;

   public boolean isActiveGame() {
      return activeGame;
   }


   public gameLogic(ActionReader AR , RandomGenerator RG ,File level , int height){
      enemies = new LinkedList<GUnit>();
      activeGame = true;
      playerMove=AR;
      enemyMove=RG;
      board=levelProccesor(level , height);
   }

   private gameObject[][] levelProccesor(File level , int height) {
      //need to implement!!!!
      return null;
   }

   public void gameTick() {
      player.gameTick();
      for(int i =0 ;i < enemies.size();i++ ){
         GUnit enemy = enemies.get(i);
         if(enemy.isAlive)enemy.gameTick();
         else enemies.remove(i);
      }
      activeGame = player.isAlive;
   }
}
