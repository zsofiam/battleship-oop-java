package battleship;

public class Battleship {
	private Display display;
	private Input input;
	private int gameMode = 1;
	// row and col can be set from input
	int row = 10;
	int col = 10;
	Board board;


	public Battleship() {
		board = new Board(row, col);
		// need row and col for display
		this.display = new Display(row, col);
		this.input = new Input();

		showMenu();
	}

	public void play() {
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
				play();
				break;
			case 2:
				showHighScores();
				break;

			case 0:
			default:
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
