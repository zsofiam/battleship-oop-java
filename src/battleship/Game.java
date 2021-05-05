package battleship;

public class Game {
	Board board1;
	Board board2;
	Player player1;
	Player player2;
	int row;
	int col;

	// the size of the board will be different in each game
	public Game(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public void playerVsPlayer(Input input, Display display) {
		// play rounds, make moves
		// check game end condition
		board1 = new Board(row, col); // player1
		board2 = new Board(row, col); // player2
		player1 = new Player("Peter");
		player2 = new Player("Katie");
		display.printTurn("Peter");

		display.printTurn("Katie");
	}

	public void playerVsAI() {
		// play rounds, make moves
		// check game end condition
		board1 = new Board(row, col); // player
		board2 = new Board(row, col); // AI
		player1 = new Player("Peter");
		player2 = new Player("Computer");
	}

	public boolean isEnd() {
		// game end condition
		return false;
	}
}
