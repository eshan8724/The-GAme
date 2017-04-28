import java.io.Serializable;
import java.util.Scanner;

/**
 * first github change
 * @author 501055002
 *
 */
public class Main implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int levelCount = 3, stageCount = 3;
	static Stage[][] stages = new Stage[levelCount][stageCount];
	static Player player = new Player();
	static int total = 0;
	static int myStage = 0;
	static int myLevel = 0;

	public static void main(String[] args) {
		initializeStages();
		Main game = new Main();
		game.start();
	}

	public void start() {
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

	private static void levelandStages() {
		// TODO Auto-generated method stub
		for (int i = 0; i < stages.length; i++) {
			for (int j = 0; j < stages[j].length; j++) {
				System.out.println("your first prize " + stages[0][j].prize[0]);
				System.out.println("has a damage of "
						+ stages[i][j].prize[0].damage);
				System.out.println("has health of "
						+ stages[i][j].prize[0].health);
				System.out.println("your first enemie is "
						+ stages[i][j].enemies[0] + " enemie code one");
				System.out.println("has a health of "
						+ stages[i][j].enemies[0].health);
				System.out.println("does a damage of "
						+ stages[i][j].enemies[0].damage);
				System.out.println("your first enemie is "
						+ stages[i][j].enemies[1] + " enemie code two");
				System.out.println("has a health of "
						+ stages[i][j].enemies[1].health);
				System.out.println("does a damage of "
						+ stages[i][j].enemies[1].damage);
				System.out.println("your first enemie is "
						+ stages[i][j].enemies[2] + " enemie code three");
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

	private static void fight() {
		// TODO Auto-generated method stub
		System.out.println("how do you wish to attack first enter enemy code");
		Scanner kb = new Scanner(System.in);
		String yes = kb.nextLine();
		if (yes.equalsIgnoreCase("one")) {
			int enemie1 = stages[myLevel][myStage].enemies[0].health;
			enemie1 = stages[myLevel][myStage].enemies[0].health
					- stages[myLevel][myStage].prize[0].damage;
			if (enemie1 < 0) {
				total = stages[myLevel][myStage].prize[0].health
						- (stages[myLevel][myStage].enemies[1].damage + stages[myLevel][myStage].enemies[2].damage);
				System.out
						.println("you have killed the first enieme but faced a damge of "
								+ total);
				System.out.println("choose your next enemie from above ");
				yes = kb.nextLine();
				if (yes.equalsIgnoreCase("two")) {
					int enemie2 = stages[myLevel][myStage].enemies[2].health;
					enemie2 = stages[myLevel][myStage].enemies[2].health
							- stages[myLevel][myStage].prize[0].damage;
					if (enemie2 < 0) {
						total = stages[myLevel][myStage].enemies[1].damage;
						System.out
								.println("you have killed the first enieme but faced a damge of "
										+ total);
						System.out
								.println("choose your next enemie from above ");
						yes = kb.nextLine();
					}
				}

			}
			if (yes.equalsIgnoreCase("one")) {
				int enemie3 = stages[myLevel][myStage].enemies[0].health;
				enemie3 = stages[myLevel][myStage].enemies[0].health
						- stages[myLevel][myStage].prize[0].damage;
				if (enemie3 < 0) {
					total = stages[myLevel][myStage].prize[0].health
							- (stages[myLevel][myStage].enemies[1].damage + stages[myLevel][myStage].enemies[2].damage);
					System.out
							.println("you have killed the first enieme but faced a damge of "
									+ total);
					System.out.println("choose your next enemie from above ");
					yes = kb.nextLine();
				}
			}
		}
	}

	private static void initializeStages() {
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
