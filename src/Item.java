public class Item {

	String name;
	int health, damage;
	int prize;

	Item(int difficulty) {
		name = getRandomName();
		health = (int) ((Math.random() * 8) + 24 + (difficulty * 4));
		damage = (int) ((Math.random() * 6) + 20 + (difficulty * 2));
	}

	private String getRandomName() {
		String[] names = { "Knife", "Golden Axe", "Diamond tree", "free",
				"trre", "hello", "gger" };
		return names[(int) Math.floor(Math.random() * names.length)];
	}

	public String toString() {
		return name;
	}
}
