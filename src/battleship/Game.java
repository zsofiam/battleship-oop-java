package battleship;

public class Game {
	Board board1;
	Board board2;
	Player player1;
	Player player2;
	ComputerPlayer computer;
	int row;
	int col;
	boolean isEnd = false;
	private String player1Name = "Peter";
	private String player2Name = "Katie";
	private String computerName = "Computer";

	// the size of the board will be different in each game
	public Game(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public String playerVsPlayer(Input input, Display display) {
		String shotMessage = "";
		display.clearScreen();
		// play rounds, make moves
		// check game end condition
		board1 = new Board(row, col); // player1
		board2 = new Board(row, col); // player2
		// input can set the names

		player1 = new Player(player1Name);
		player2 = new Player(player2Name);
		BoardFactory factory1 = new BoardFactory(board1);
		BoardFactory factory2 = new BoardFactory(board2);
		display.clearScreen();
		display.printBoardOwner(player1Name);
		display.printBoardDuringPlacingShips(board1.getOcean());
		display.printTurn(player1Name);
		factory1.manualPlacement();
		display.clearScreen();
		display.printBoardOwner(player2Name);
		display.printBoardDuringPlacingShips(board2.getOcean());
		display.printTurn(player2Name);
		factory2.manualPlacement();

		while (!isEnd) {
			// print enemy board before shooting
			display.printBoardOwner(player2Name);
			display.printBoardDuringShooting(board2.getOcean());
			display.printTurn(player1Name);
			// shoot enemy
			shotMessage = factory2.getAndPlaceShotOnBoard(board2.getOcean());
			display.clearScreen();
			display.printBoardOwner(player2Name);
			display.printBoardDuringShooting(board2.getOcean());
			display.printHitMessage(shotMessage, player2Name);
			isEnd = !player2.isAlive(board2.getOcean());
			if (isEnd) {
				break;
			}
			input.waitForEnter();
			display.clearScreen();
			// print enemy board before shooting
			display.printBoardOwner(player1Name);
			display.printBoardDuringShooting(board1.getOcean());
			display.printTurn(player2Name);
			// shoot enemy
			shotMessage = factory1.getAndPlaceShotOnBoard(board1.getOcean());
			display.clearScreen();
			display.printBoardOwner(player1Name);
			display.printBoardDuringShooting(board1.getOcean());
			display.printHitMessage(shotMessage, player1Name);
			input.waitForEnter();
			isEnd = !player1.isAlive(board1.getOcean());
		}
		return !player1.isAlive(board1.getOcean()) ? player2Name : player1Name;
	}

	public String playerVsAI(Input input, Display display) {
		String shotMessage = "";
		display.clearScreen();
		// play rounds, make moves
		// check game end condition
		board1 = new Board(row, col); // player
		board2 = new Board(row, col); // AI
		// input can set the name
		player1 = new Player(player1Name);
		computer = new ComputerPlayer(computerName);
		BoardFactory factory1 = new BoardFactory(board1);
		BoardFactory factory2 = new BoardFactory(board2);
		display.clearScreen();
		display.printBoardOwner(player1Name);
		display.printBoardDuringPlacingShips(board1.getOcean());
		display.printTurn(player1Name);
		factory1.manualPlacement();

		display.clearScreen();
		display.printBoardOwner(computerName);
		display.printBoardDuringPlacingShips(board2.getOcean());
		display.printTurn(computerName);
		// random placement

		while (!isEnd) {
			// print enemy board before shooting
			display.printBoardOwner(computerName);
			display.printBoardDuringShooting(board2.getOcean());
			display.printTurn(player1Name);
			// shoot computer
			shotMessage = factory2.getAndPlaceShotOnBoard(board2.getOcean());
			display.clearScreen();
			display.printBoardOwner(computerName);
			display.printBoardDuringShooting(board2.getOcean());
			display.printHitMessage(shotMessage, computerName);
			isEnd = !player2.isAlive(board2.getOcean());
			if (isEnd) {
				break;
			}
			display.clearScreen();
			display.printTurn(computerName);
			// wait for computer to move
			input.waitForEnter();
			// TODO computer shoot player

			display.printBoardOwner(player1Name);
			display.printBoardDuringShooting(board1.getOcean());
			// TODO write AI shotMessage
			input.waitForEnter();
			isEnd = !player1.isAlive(board1.getOcean());
		}

		return !player1.isAlive(board1.getOcean()) ? computerName : player1Name;
	}

	public boolean isEnd() {
		// game end condition
		return false;
	}
}
