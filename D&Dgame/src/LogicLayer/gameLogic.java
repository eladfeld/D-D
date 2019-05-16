package LogicLayer;

import InterfaceLayer.Moves.*;
import java.io.File;
import java.util.LinkedList;
import java.util.List;


public class gameLogic {
   ActionReader  playerMove;
   RandomGenerator enemyMove;
   gameObject[][] board;
   List<GUnit> actors;

   public boolean isActiveGame() {
      return activeGame;
   }

   boolean activeGame;
   public gameLogic(ActionReader AR , RandomGenerator RG ,File level , int height){
      actors = new LinkedList<GUnit>();
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
      for(int i =0 ;i < actors.size();i++ ){

      }
   }
}
