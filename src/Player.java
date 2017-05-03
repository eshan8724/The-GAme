import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	ArrayList<Item> inventory = new ArrayList<Item>();

	Scanner kb = new Scanner(System.in);
	String playerName;// = kb.nextLine();

	/**
	 * Find out if the player is carrying an item
	 * 
	 * @param name
	 *            The name of the item you are checking for
	 * @return boolean True if the player is carrying the item
	 */
	public boolean hasItem(String name) {
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).name.equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}

	public void setPlayerName(String name) {
		playerName = "Knight " + name;
	}

	public void addItem(Item e) {
		inventory.add(e);
	}

/**
 * this creates my plyers inventory
 */
	public void printInventory() {
		for (int i = 0; i < inventory.size(); i++) {
			System.out.println(inventory.get(i).name);			
		}
	}
}
