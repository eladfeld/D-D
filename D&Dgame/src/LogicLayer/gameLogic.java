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


   public gameLogic(ActionReader AR , RandomGenerator RG ,char[][] level , int height){
      enemies = new LinkedList<GUnit>();
      activeGame = true;
      playerMove=AR;
      enemyMove=RG;
      board=levelProccesor(char[][] level);
      player = askForPlayerType(AR);
   }

   private Player askForPlayerType(ActionReader ar) {
      int choose;
      try{
         choose = Integer.parseInt(ar.nextAction());
      }catch (Exception e){
         e.printStackTrace();
      }


      Player output = null;
      switch (choose){
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

   private gameObject[][] levelProccesor(char[][] board) {
      char c;
	  int width =  board.length;
	  int length = board[0].length;
	  GameObject[][] output = new GameObject[width][length];
      for(int i=0 ; i<width ; i++) {
    	  for(int j=0 ; j<length ; j++) {
    		  c = board[i][j];
    		  GameObject GO;
    		  swicth(c){
    			  case '.': GO = new FreeSpace(i,j);
    			  case '#': GO =  new Wall(i,j);
    			  case '@': GO =  new Player(i,j);
    			  case 'X': GO =  new DeadPlayer(i,j);
    			  
    			  case 's': GO =  new LannisterSoldier(i,j);
    			  case 'k': GO =  new LannisterKnight(i,j);
    			  case 'q': GO =  new QueensGuard(i,j);
    			  case 'z': GO =  new Wright(i,j);
    			  case 'b': GO =  new BearWright(i,j);
    			  case 'g': GO =  new GiantWright(i,j);
    			  case 'w': GO =  new WhiteWalker(i,j);
    			  case 'M': GO =  new TheMountain(i,j);
    			  case 'C': GO =  new QueenCersei(i,j);
    			  case 'K': GO =  new NightsKing(i,j);
    			  
    			  case 'B': GO =  new BonusTrap(i,j);
    			  case 'Q': GO =  new QueensTrap(i,j);
    			  case 'D': GO =  new DeathTrap(i,j);
    		  }
    	  }
      }
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
