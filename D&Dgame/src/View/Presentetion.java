package View;

import Model.GUnit;
import Model.Players.Player;
import Model.gameLogic;
import Model.gameObject;

public class Presentetion implements MyObserver{

    private Presentetion(){}

    private final static Presentetion INSTANCE = new Presentetion();

    public static MyObserver getInstance() {
        return INSTANCE;
    }

    //shows game credits
    public static void gameFinishd() {
        System.out.println(
                "you have finish the game!\n" +
                "credits: \n" +
                "Script writing : Elad Feldman \n" +
                "Graphic disign : Tzuri Tesuba \n" +
                "Logic and architecture : Tzuri Teshuba\n" + "" +
                "                         Elad Feldman");
    }

    //notifies user of illegal input for player choice
    public void playerChoseError(){
        System.out.println("You need to insert a digits to select your right Player");
    }

    //shows player select screen
    public void GameStart(){
        String choosePlayer = "Select player:\n" +
                "1. Jon Snow\t\tHealth: 300\t\tAttack damage: 30\t\tDefense: 4\n" +
                "\t\tLevel: 1\t\tExperience: 0/50\t\tAbility cooldown: 6\t\tRemaining: 0\n" +
                "2. The Hound\t\tHealth: 400\t\tAttack damage: 20\t\tDefense: 6\n" +
                "\t\tLevel: 1\t\tExperience: 0/50\t\tAbility cooldown: 4\t\tRemaining: 0\n" +
                "3. Melisandre\t\tHealth: 160\t\tAttack damage: 10\t\tDefense: 1\n" +
                "\t\tLevel: 1\t\tExperience: 0/50\t\tSpellPower: 15\t\t\tMana: 75/300\n" +
                "4. Thoros of Myr\tHealth: 250\t\tAttack damage: 25\t\tDefense: 3\n" +
                "\t\tLevel: 1\t\tExperience: 0/50\t\tSpellPower: 20\t\t\tMana: 37/150\n" +
                "5. Arya Stark\t\tHealth: 150\t\tAttack damage: 40\t\tDefense: 2\n" +
                "\t\tLevel: 1\t\tExperience: 0/50\t\tEnergy: 100/100\n" +
                "6. Bronn\t\tHealth: 250\t\tAttack damage: 35\t\tDefense: 3\n" +
                "\t\tLevel: 1\t\tExperience: 0/50\t\tEnergy: 100/100";

        System.out.println(choosePlayer);
    }

    public void levelUp(int levelNum) {
        System.out.println("You have finish level " + (levelNum-1) + " level " + levelNum + " begin");
    }

    //confirms to user the player he chose and what the game controls are
    public static void PlayerChosen(String name){
        System.out.println("You have chosen to play with: "  + name +
                            "\n Use w/s/a/d to move.\n" +
                                    "Use e for special ability or q to pass.");
    }


    @Override //updates the user with the provided message
    public void update(String update) {
        System.out.println(update);
    }

    //updates the user of battle stats
    public void update(GUnit assailant, GUnit defender, int atk, int def) {
        update(battleReport(assailant, defender, atk, def));
    }

    @Override    //updates the user of battle stats
    public void update(GUnit assailant, gameObject defender, int atk, int def) {
        update(assailant, (GUnit)defender, atk, def);

    }
    //notifies the user of his current stats
    private String stats(GUnit g) {
    	String s = g.getName()+" :     Health: "+g.getCurrHP() +"/" +g.getHP() +"     Attack: "+g.getAP()+"     Defence: "+g.getDP() ;
    	return s;
    }
    //notifies user of his current stats specific to his player choice
    private String playerStats() {
    	return gameLogic.getPlayer().SpecialStats();
    }

    //returns string describing the events that took place during a battle
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
    
    //Game over!
    public void GameOver() {
    	System.out.println("Game Over!");
    }



	public void ShowGame() {
		Player p = gameLogic.getPlayer();
		System.out.println(lifeBar(p.getCurrHP(), p.getHP()));
		//System.out.println(gameLogic.boardToString(p.getBoard()));
		System.out.println(stats(p)+ playerStats());
	}
	
	//returns a visually comfortable representation of the players currHP/HP
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
