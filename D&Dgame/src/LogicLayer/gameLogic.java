package LogicLayer;

import InterfaceLayer.Moves.*;
import java.io.File;
import java.util.LinkedList;
import java.util.List;


public class gameLogic {
   private ActionReader playerMove;
   private RandomGenerator enemyMove;
   private gameObject[][] board;
   private List<GUnit> enemies;
   private Player player = null;
   private boolean activeGame;

   public boolean isActiveGame() {
      return activeGame;
   }


   public gameLogic(ActionReader AR, RandomGenerator RG, char[][] level) {
      enemies = new LinkedList<GUnit>();
      activeGame = true;
      playerMove = AR;
      enemyMove = RG;
//      board=levelProccesor(char[][] level);
      player = askForPlayerType(AR);
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

//      private gameObject[][] levelProccesor ( char[][] board){
//         //need to implement!!!!
//         return null;
//      }

      public void gameTick(){
         player.gameTick();
         for (int i = 0; i < enemies.size(); i++) {
            GUnit enemy = enemies.get(i);
            if (enemy.isAlive) enemy.gameTick();
            else enemies.remove(i);
         }
         activeGame = player.isAlive;
   }
}
