import java.io.Serializable;
import java.util.Scanner;

/**
 * first github change hello write what my game does here before next assesment
 * 
 * @author 501055002 to get changes right click on the project and go to team
 *         and pull My game is knight of the tree in here you are a knight and
 *         attempt to save the queen this is my main method and this is where
 *         all my majic happens here and all my levels and stges are made and
 *         the game is started yeeee aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
 */
public class Main implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int levelCount = 3, stageCount = 3;
	Stage[][] stages = new Stage[levelCount][stageCount];
	Player player = new Player();
	int total = 0;
	int myStage = 0;
	int myLevel = 0;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Main game = new Main();
		game.start();
	}

	/**
	 * this contains all my starting stuff it returns my welcome and story and
	 * asks if you plyed before and sends you to level 1 and stage on if you did
	 * not
	 */
	public void start() {
		initializeStages();
		Scanner kb = new Scanner(System.in);// This is my global input
		System.out.println(stages[0][0].enemies[2]);
		System.out
				.println("Welcome to Knights of the Tree you become lone Knight that protects the london tree");
		System.out.println("Have you played this game before");
		System.out.println("Yes");
		System.out.println("No");
		String sg = kb.nextLine();
		if (sg.equalsIgnoreCase("yes")) {
			// TODO filesystems
		} else {
			System.out.println("What is your knight name:");
			player.setPlayerName(kb.nextLine());
			System.out
					.println(player.playerName
							+ " there is a war about to happen in the tree the don of england is attacking "
							+ "\nus he  might kill us all he already stopped some food companies from bring "
							+ "\nfood into the tree  and you are the last knight that can help us please help "
							+ "\nus I will reward you with 50 pounds of gold and diamonds.Will you help her:");
			String yes = kb.nextLine();
			if (yes.equalsIgnoreCase("yes")) {
				// start level one using a method
				levelandStages();
			} else {
				// create a way to restart

			}
		}
	}

	/**
	 * this contains a for loop which goes through each my levels and stages it
	 * opens all of them as you pass through them and also prints out all my
	 * eneimeis and the prize recived
	 */
	private void levelandStages() {
		// TODO Auto-generated method stub
		for (int i = 0; i < stages.length; i++) {
			for (int j = 0; j < stages[i].length; j++) {
				System.out.println("PRIZE: " + stages[i][j].prize[0]);
				System.out.println("\nYou do a damage of "
						+ stages[i][j].prize[0].damage);
				System.out.println("Your health is "
						+ stages[i][j].prize[0].health + "\n");
				System.out.println("your first enemie is "
						+ stages[i][j].enemies[0] + " ENEMY CODE: \"one\" ");
				System.out.println("has a health of "
						+ stages[i][j].enemies[0].health);
				System.out.println("does a damage of "
						+ stages[i][j].enemies[0].damage);
				System.out.println("your second enemie is "
						+ stages[i][j].enemies[1] + " ENEMY CODE: \"two\"");
				System.out.println("has a health of "
						+ stages[i][j].enemies[1].health);
				System.out.println("does a damage of "
						+ stages[i][j].enemies[1].damage);
				System.out.println("your third enemie is "
						+ stages[i][j].enemies[2] + " ENEMY CODE: \"three\"");
				System.out.println("has a health of "
						+ stages[i][j].enemies[2].health);
				System.out.println("does a damage of "
						+ stages[i][j].enemies[2].damage);
				myStage = j;
				myLevel = i;
				fight();
			}
		}
	}

	/**
	 * this opens diffrent methods for each enemie
	 */
	private void fight() {
		// TODO Auto-generated method stub
		System.out.println("who do you wish to attack first enter enemy code");
		Scanner kb = new Scanner(System.in);
		String yes = kb.nextLine();
		if (yes.equalsIgnoreCase("one")) {
			one();			
		}else if(yes.equalsIgnoreCase("two")){
			two();
		}else if(yes.equalsIgnoreCase("three")){
			three();
		}
	}

	/**
	 * this is all the options if you chose the first eneime
	 */
	private void one() {
		Scanner kb = new Scanner(System.in);
		int enemie1 = stages[myLevel][myStage].enemies[0].health
				- stages[myLevel][myStage].prize[0].damage;

		total = stages[myLevel][myStage].prize[0].health
				- (stages[myLevel][myStage].enemies[1].damage + stages[myLevel][myStage].enemies[2].damage);
		if (enemie1 < 0) {
			if (total > 0) {
				System.out
						.println("you have killed your first enemie but faced a damge of "
								+ total);
				System.out
						.println("choose your next enemy from above type enemie code");
				String a = kb.nextLine();
				if (a.equalsIgnoreCase("two")) {
					int enemie2 = stages[myLevel][myStage].enemies[1].health
							- stages[myLevel][myStage].prize[0].damage;
					total = stages[myLevel][myStage].prize[0].health
							- (stages[myLevel][myStage].enemies[2].damage);
					if (enemie2 > 0) {
						System.out
								.println("You were not able to destroy the enemie he/she has a health of "
										+ enemie2);
						System.out.println("you now only have a health of "
								+ total);
						// TODO make a way if the charcter dosent die to allow
						// it to continue
					} else if (total < 0) {
						System.out
								.println("you have faced to much damage you did well; you will now be taken back to the home screen");
						start();
					} else {
						System.out
								.println("you have killed the second enemie but faced a damage of "
										+ total);
						int enemie3 = stages[myLevel][myStage].enemies[2].health
								- stages[myLevel][myStage].prize[0].damage;
						if (enemie3 > 0) {
							total = stages[myLevel][myStage].prize[0].health
									- (stages[myLevel][myStage].enemies[2].damage);
							// continue playing
						} else {
							System.out
									.println("you have made it to the next level");
						}
					}
				} else if (a.equalsIgnoreCase("three")) {
					// TODO make it so if they chose three to allow them
				}
			} else if (total < 0)
				System.out
						.println("you have faced to much damage you did well; you will now be taken back to the home screen");
			//start();
		} else if (enemie1 > 0) {
			System.out
					.println("You were not able to destroy the enemie he/she has a health of"
							+ enemie1);
			System.out.println("you now only have a health of " + total);
			// TODO make it so the eneime is still alive and faces damage of so
			// kinda like the start but make the total the same
		}
	}

	private void two() {
		Scanner kb = new Scanner(System.in);
		int enemie2 = stages[myLevel][myStage].enemies[1].health
				- stages[myLevel][myStage].prize[0].damage;

		total = stages[myLevel][myStage].prize[0].health
				- (stages[myLevel][myStage].enemies[0].damage + stages[myLevel][myStage].enemies[2].damage);
		if (enemie2 < 0) {
			if (total > 0) {
				System.out
						.println("you have killed your first enemie but faced a damge of "
								+ total);
				System.out
						.println("choose your next enemy from above type enemie code");
				String a = kb.nextLine();
				if (a.equalsIgnoreCase("one")) {
					int enemie1 = stages[myLevel][myStage].enemies[0].health
							- stages[myLevel][myStage].prize[0].damage;
					total = stages[myLevel][myStage].prize[0].health
							- (stages[myLevel][myStage].enemies[2].damage);
					if (enemie1 > 0) {
						System.out
								.println("You were not able to destroy the enemie he/she has a health of"
										+ enemie1);
						System.out.println("you now only have a health of "
								+ total);
						// TODO make a way if the charcter dosent die to allow
						// it to continue
					} else if (total < 0) {
						System.out
								.println("you have faced to much damage you did well; you will now be taken back to the home screen");
						//start();
					} else {
						System.out
								.println("you have killed the second enemie but faced a damage of "
										+ total);
						int enemie3 = stages[myLevel][myStage].enemies[2].health
								- stages[myLevel][myStage].prize[0].damage;
						if (enemie3 > 0) {
							total = stages[myLevel][myStage].prize[0].health
									- (stages[myLevel][myStage].enemies[2].damage);
							// continue playing
						} else {
							System.out
									.println("you have made it to the next level");
						}
					}
				} else if (a.equalsIgnoreCase("three")) {
					// TODO make it so if they chose three to allow them
				}
			} else if (total < 0)
				System.out
						.println("you have faced to much damage you did well; you will now be taken back to the home screen");
			//start();
		} else if (enemie2 > 0) {
			System.out
					.println("You were not able to destroy the enemie he/she has a health of"
							+ enemie2);
			System.out.println("you now only have a health of " + total);
			// TODO make it so the eneime is still alive and faces damage of so
			// kinda like the start but make the total the same
		}
	}

	private void three() {
		Scanner kb = new Scanner(System.in);
		int enemie3 = stages[myLevel][myStage].enemies[2].health
				- stages[myLevel][myStage].prize[0].damage;

		total = stages[myLevel][myStage].prize[0].health
				- (stages[myLevel][myStage].enemies[0].damage + stages[myLevel][myStage].enemies[1].damage);
		if (enemie3 < 0) {
			if (total > 0) {
				System.out
						.println("you have killed your first enemie but faced a damge of "
								+ total);
				System.out
						.println("choose your next enemy from above type enemie code");
				String a = kb.nextLine();
				if (a.equalsIgnoreCase("one")) {
					int enemie1 = stages[myLevel][myStage].enemies[0].health
							- stages[myLevel][myStage].prize[0].damage;
					total = stages[myLevel][myStage].prize[0].health
							- (stages[myLevel][myStage].enemies[1].damage);
					if (enemie1 > 0) {
						System.out
								.println("You were not able to destroy the enemie he/she has a health of"
										+ enemie1);
						System.out.println("you now only have a health of "
								+ total);
						// TODO make a way if the charcter dosent die to allow
						// it to continue
					} else if (total < 0) {
						System.out
								.println("you have faced to much damage you did well; you will now be taken back to the home screen");
						//start();
					} else {
						System.out
								.println("you have killed the second enemie but faced a damage of "
										+ total);
						int enemie2 = stages[myLevel][myStage].enemies[2].health
								- stages[myLevel][myStage].prize[0].damage;
						if (enemie2 > 0) {
							total = stages[myLevel][myStage].prize[0].health
									- (stages[myLevel][myStage].enemies[2].damage);
							// continue playing
						} else {
							System.out
									.println("you have made it to the next level");
						}
					}
				} else if (a.equalsIgnoreCase("two")) {
					// TODO make it so if they chose three to allow them
				}
			} else if (total < 0)
				System.out
						.println("you have faced to much damage you did well; you will now be taken back to the home screen");
			//start();
		} else if (enemie3 > 0) {
			System.out
					.println("You were not able to destroy the enemie he/she has a health of"
							+ enemie3);
			System.out.println("you now only have a health of " + total);
			// TODO make it so the eneime is still alive and faces damage of so
			// kinda like the start but make the total the same
		}
	}

	/**
	 * this creates my stages
	 */
	private void initializeStages() {
		// Setup random characters
		for (int i = 0; i < stages.length; i++) {
			for (int j = 0; j < stages[i].length; j++) {
				stages[i][j] = new Stage((i * 2) + j);
			}
		}
		// Assign specific character names
		// stages[levelCount - 1][stageCount - 1].Enemies[2].name =
		// "Final Boss";
	}

}
