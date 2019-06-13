package View;

import Model.GUnit;
import Model.gameLogic;
import Model.gameObject;
import Model.Players.Player;

import java.util.Scanner;

public class Presentetion implements MyObserver{

	private static String message="";


    private Presentetion(){}

    public static void gameFinishd() {
        System.out.println(
                "you have finish the game!\n" +
                "credits: \n" +
                "Script writing : Elad Feldman \n" +
                "Graphic disign : Tzuri Tesuba \n" +
                "Logic and architecture : Tzuri Teshuba\n" + "" +
                "                         Elad Feldman");
    }

    public void playerChoseError(){
        System.out.println("You need to insert a digits to select your right Player");
    }


    public void GameStart(){
        String choosePlayer = "Select player:\n" +
                "1. Jon Snow\t\tHealth: 300\t\tAttack damage: 30\t\tDefense: 4\n" +
                "\t\tLevel: 1\t\tExperience: 0/50\t\tAbility cooldown: 6\t\tRemaining: 0\n" +
                "2. The Hound\t\tHealth: 400\t\tAttack damage: 20\t\tDefense: 6\n" +
                "\t\tLevel: 1\t\tExperience: 0/50\t\tAbility cooldown: 4\t\tRemaining: 0\n" +
                "3. Melisandre\t\tHealth: 160\t\tAttack damage: 10\t\tDefense: 1\n" +
                "\t\tLevel: 1\t\tExperience: 0/50\t\tSpellPower: 15\t\tMana: 75/300\n" +
                "4. Thoros of Myr\t\tHealth: 250\t\tAttack damage: 25\t\tDefense: 3\n" +
                "\t\tLevel: 1\t\tExperience: 0/50\t\tSpellPower: 20\t\tMana: 37/150\n" +
                "5. Arya Stark\t\tHealth: 150\t\tAttack damage: 40\t\tDefense: 2\n" +
                "\t\tLevel: 1\t\tExperience: 0/50\t\tEnergy: 100/100\n" +
                "6. Bronn\t\tHealth: 250\t\tAttack damage: 35\t\tDefense: 3\n" +
                "\t\tLevel: 1\t\tExperience: 0/50\t\tEnergy: 100/100";

        System.out.println(choosePlayer);
    }
    private static class PresentetionHolder {
        private final static Presentetion INSTANCE = new Presentetion();
    }
    public static void PlayerChosen(String name){
        System.out.println("You have chosen to play with: "  + name +
                            "\n Use w/s/a/d to move.\n" +
                                    "Use e for special ability or q to pass.");
    }

    public static MyObserver getInstance() {
        return PresentetionHolder.INSTANCE;
    }

    @Override
    public void update(String update) {
//    	message = message + update;
        System.out.println(update);
    }

    public void update(GUnit assailant, GUnit defender, int atk, int def) {
        update(battleReport(assailant, defender, atk, def));
    }
    private String stats(GUnit g) {
    	String s = g.getName()+" :     Health: "+g.getCurrHP() +"/" +g.getHP() +"     Attack: "+g.getAP()+"     Defence: "+g.getDP() ;
    	return s;
    }

    private String playerStats() {
    	return gameLogic.getPlayer().SpecialStats();
    }

    private String battleReport(GUnit assailant, GUnit defender, int attack, int defence) {
    	String s = assailant.getName() +" engaged in battle with " + defender.getName()+" :"+'\n';
    	s = s+stats(assailant)+'\n'+ stats(defender)+ '\n';
    	s = s+ playerStats()+'\n';
    	s  = s + assailant.getName() + " rolled " +attack +" attack points." + '\n';
    	s = s + defender.getName() + " rolled " + defence + " defence ponits" + '\n';
    	int damage = attack - defence;
    	if (damage < 0) damage = 0;
    	s = s + assailant.getName() + " hit " + defender.getName() + "  for " + damage +  " damage."+'\n';
    	if(defender.isAlive()==false) s=s+defender.getName()+ " has died.";
    	return s;
    }

    public String GameOver() {
    	System.out.println("GAME OVER!\n" +
                "do you wish to play again?\n" +
                "insert Y - yes , N - no \n" +
                " Y/N ?");
        Scanner S = new Scanner(System.in);
        String ans = S.nextLine();
        return ans;
    }

	@Override
	public void update(GUnit assailant, gameObject defender, int atk, int def) {
		update(assailant, (GUnit)defender, atk, def);
		
	}
	
	public void ShowGame() {
		Player p = gameLogic.getPlayer();
		System.out.println(lifeBar(p.getCurrHP(), p.getHP()));
		//System.out.println(gameLogic.boardToString(p.getBoard()));
		System.out.println(stats(p)+ playerStats());
	}
    public static String lifeBar(int currHP , int HP){
        int Hpresentage = (100*currHP)/HP;
        String output = "";
        for(int i = 0;i<100-Hpresentage-1;i++){
            output = output + ".";
        }
        output = output + "]";
        for(int i=0; i<Hpresentage -1;i++){
            output = "|" + output;
        }
        output= "[" + output;
        return  output.substring(0,48) + (int)Hpresentage + "%" + output.substring(51);

    }
}
