public class Stage {

	Enemy[] enemies = new Enemy[3];
	Item[] prize = new Item[1];
/**
 * this creates a difficulty for my stage and it rises each stage
 * @param difficulty
 */
	Stage(int difficulty) {
		for (int i = 0; i < enemies.length; i++) {
			enemies[i] = new Enemy(difficulty + i);
		}
		for (int i = 0; i < prize.length; i++) {
			prize[i] = new Item(difficulty + i);
		}
	}

}
