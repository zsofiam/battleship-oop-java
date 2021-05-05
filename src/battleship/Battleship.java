package battleship;

public class Battleship {
	private Display display;
	private Input input;
	private Game game;
	private int gameMode;
	// row and col can be set from input
	int row = 10;
	int col = 10;



	public Battleship() {
		// need row and col for display
		this.display = new Display(row, col);
		this.input = new Input();
	}

	public void play(int gameMode) {
		// write here input for row and col to change size

		this.game = new Game(row, col);

		if (gameMode == 1) {
			System.out.println(gameMode);
			game.playerVsPlayer(input, display);
		} else {
			System.out.println(gameMode);
			game.playerVsAI();
		}
//		display.printBoardDuringPlacingShips(board.getOcean());
//		display.printBoardDuringShooting(board.getOcean());
//		while (true) {
//			//
//		}
		display.printGameOver(1);
		input.waitForEnter();
	}

	public void showMenu() {
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
		// start new game - choose player vs player | player vs AI
		// display high scores
		// exit
	}

	public void showHighScores() {

	}


}
