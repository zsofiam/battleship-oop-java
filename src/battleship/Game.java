package battleship;

public class Game {
	Board board;
	int row;
	int col;

	// the size of the board will be different in each game
	public Game(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public void playerVsPlayer() {
		// play rounds, make moves
		// check game end condition
		board = new Board(row, col);
	}

	public void playerVsAI() {
		// play rounds, make moves
		// check game end condition
		board = new Board(row, col);
	}

	public boolean isEnd() {
		// game end condition
		return false;
	}
}
