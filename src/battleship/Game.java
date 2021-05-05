package battleship;

public class Game {
	Board board1;
	Board board2;
	Player player1;
	Player player2;
	int row;
	int col;
	boolean isEnd = false;

	// the size of the board will be different in each game
	public Game(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public String playerVsPlayer(Input input, Display display) {
		display.clearScreen();
		// play rounds, make moves
		// check game end condition
		board1 = new Board(row, col); // player1
		board2 = new Board(row, col); // player2
		// input can set the names
		player1 = new Player("Peter");
		player2 = new Player("Katie");
		BoardFactory factory1 = new BoardFactory(board1);
		BoardFactory factory2 = new BoardFactory(board2);
		display.clearScreen();
		display.printBoardDuringPlacingShips(board1.getOcean());
		display.printTurn("Peter");
		// TODO need to print board after every ship placement !!
		factory1.manualPlacement();
		display.clearScreen();
		display.printBoardDuringPlacingShips(board2.getOcean());
		display.printTurn("Katie");
		// TODO need to print board after every ship placement !!
		factory2.manualPlacement();

		while (!isEnd) {
			// print enemy board before shooting
			display.printBoardDuringShooting(board2.getOcean());
			display.printTurn("Peter");
			// shoot enemy
			factory2.getAndPlaceShotOnBoard();
			display.clearScreen();
			// print enemy board after shooting
			display.printBoardDuringShooting(board2.getOcean());
			isEnd = !player2.isAlive(board2.getOcean());
			if (isEnd) {
				break;
			}
			input.waitForEnter();
			display.clearScreen();
			// print enemy board before shooting
			display.printBoardDuringShooting(board1.getOcean());
			display.printTurn("Katie");
			// shoot enemy
			factory1.getAndPlaceShotOnBoard();
			display.clearScreen();
			// print enemy board after shooting
			display.printBoardDuringShooting(board1.getOcean());
			isEnd = !player1.isAlive(board1.getOcean());
		}
		return !player1.isAlive(board1.getOcean()) ? "Katie" : "Peter";
	}

	public String playerVsAI(Input input, Display display) {
		display.clearScreen();
		// play rounds, make moves
		// check game end condition
		board1 = new Board(row, col); // player
		board2 = new Board(row, col); // AI
		// input can set the name
		player1 = new Player("Peter");
		player2 = new Player("Computer");
		BoardFactory factory1 = new BoardFactory(board1);
		BoardFactory factory2 = new BoardFactory(board2);
		display.printTurn("Peter");

		display.clearScreen();
		display.printTurn("Computer");

		return !player1.isAlive(board1.getOcean()) ? "Computer" : "Peter";
	}

	public boolean isEnd() {
		// game end condition
		return false;
	}
}
