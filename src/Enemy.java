public class Enemy {

	int health, damage;
	String name;

	Enemy(int difficulty) {
		name = getRandomName();
		health = (int) ((Math.random() * 2) + 8 + (difficulty * 4));
		damage = (int) ((Math.random() * 2) + 4 + (difficulty * 2));
	}
/**
 * this is my random name generator it 
 * @returns a name 
 */
	private String getRandomName() {
		String[] names = { "Eshan", "Mr,Prowse", "smith", "blouga", "trre",
				"hello", "gger", "agris", "sukhnaZ", ""};
		return names[(int) Math.floor(Math.random() * names.length)];
	}

	public String toString() {
		return name;
	}

}
