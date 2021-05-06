package battleship;

public class Battleship {
	private Display display;
	private Input input;
	private Game game;
	private int gameMode;
	// row and col can be set from input
	int row = 5;
	int col = 5;



	public Battleship() {
		// need row and col for display
		this.display = new Display(row, col);
		this.input = new Input();
	}

	public void play(int gameMode) {
		String winner;
		// write here input for row and col to change size

		this.game = new Game(row, col);
		display.clearScreen();
		if (gameMode == 1) {
			System.out.println(gameMode);
			winner = game.playerVsPlayer(input, display);
		} else {
			System.out.println(gameMode);
			winner = game.playerVsAI(input, display);
		}

		display.printGameOver(winner);
		input.waitForEnter();
	}

	public void showMenu() {
		while (true) {
			display.printMenu();

			int nextState = input.getMenuInput();

			switch (nextState) {
				case 1:
					gameMode = input.getGameMode();
					play(gameMode);
					break;
				case 2:
					showHighScores();
					break;

				case 0:
				default:
					display.sayGoodbye();
					System.exit(0);
					break;
			}
		}
	}

	public void showHighScores() {

	}


}
