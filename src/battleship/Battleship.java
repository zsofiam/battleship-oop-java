package battleship;

public class Battleship {
	private Display display;
	private Input input;
	// row and col can be set from input
	int row = 10;
	int col = 10;
	Board board;


	public Battleship() {
		board = new Board(row, col);
		// need row and col for display
		this.display = new Display(row, col);
		this.input = new Input();

	}

	public void play() {
//		display.printBoardDuringPlacingShips(board.getOcean());
//		display.printBoardDuringShooting(board.getOcean());
//		while (true) {
//			//
//		}
	}

	public void showMenu() {
		// start new game - choose player vs player | player vs AI
		// display high scores
		// exit
	}


}
