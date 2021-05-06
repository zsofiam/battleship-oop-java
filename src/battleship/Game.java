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

		player1 = new Player("Peter");
		player2 = new Player("Katie");
		BoardFactory factory1 = new BoardFactory(board1);
		BoardFactory factory2 = new BoardFactory(board2);
		display.clearScreen();
		display.printBoardOwner(player1.getName());
		display.printBoardDuringPlacingShips(board1.getOcean());
		display.printTurn(player1.getName());
		factory1.manualPlacement();
		display.clearScreen();
		display.printBoardOwner(player2.getName());
		display.printBoardDuringPlacingShips(board2.getOcean());
		display.printTurn(player2.getName());
		factory2.manualPlacement();

		while (!isEnd) {
			// print enemy board before shooting
			display.printBoardOwner(player2.getName());
			display.printBoardDuringShooting(board2.getOcean());
			display.printTurn(player1.getName());
			// shoot enemy
			shotMessage = factory2.getAndPlaceShotOnBoard(board2.getOcean(), null);
			display.clearScreen();
			display.printBoardOwner(player2.getName());
			display.printBoardDuringShooting(board2.getOcean());
			display.printHitMessage(shotMessage, player2.getName(), null);
			// TODO wait here?
			isEnd = !player2.isAlive(board2.getOcean());
			if (isEnd) {
				break;
			}
			input.waitForEnter();
			display.clearScreen();
			// print enemy board before shooting
			display.printBoardOwner(player1.getName());
			display.printBoardDuringShooting(board1.getOcean());
			display.printTurn(player2.getName());
			// shoot enemy
			shotMessage = factory1.getAndPlaceShotOnBoard(board1.getOcean(), null);
			display.clearScreen();
			display.printBoardOwner(player1.getName());
			display.printBoardDuringShooting(board1.getOcean());
			display.printHitMessage(shotMessage, player1.getName(), null);
			input.waitForEnter();
			isEnd = !player1.isAlive(board1.getOcean());
		}
		return !player1.isAlive(board1.getOcean()) ? player2.getName() : player1.getName();
	}

	public String playerVsAI(Input input, Display display) {
		String shotMessage = "";
		display.clearScreen();
		// play rounds, make moves
		// check game end condition
		board1 = new Board(row, col); // player
		board2 = new Board(row, col); // AI
		// input can set the name
		player1 = new Player("Peter");
		computer = new ComputerPlayer("Computer");
		BoardFactory factory1 = new BoardFactory(board1);
		BoardFactory factory2 = new BoardFactory(board2);
		display.clearScreen();
		display.printBoardOwner(player1.getName());
		display.printBoardDuringPlacingShips(board1.getOcean());
		display.printTurn(player1.getName());
		factory1.manualPlacement();

		display.clearScreen();
		display.printComputerPlacingTurn(computer.getName());
		input.waitForEnter();
		factory2.randomPlacement();


		while (!isEnd) {
			// print enemy board before shooting
			display.printBoardOwner(computer.getName());
			display.printBoardDuringShooting(board2.getOcean());
			display.printTurn(player1.getName());
			// shoot computer
			shotMessage = factory2.getAndPlaceShotOnBoard(board2.getOcean(), null);
			display.clearScreen();
			display.printBoardOwner(computer.getName());
			display.printBoardDuringShooting(board2.getOcean());
			display.printHitMessage(shotMessage, computer.getName(), null);
			isEnd = !computer.isAlive(board2.getOcean());
			if (isEnd) {
				break;
			}
			display.clearScreen();
			display.printTurn(computer.getName());
			// wait for computer to move
			input.waitForEnter();
			// TODO computer shoot player
			shotMessage = factory1.getAndPlaceShotOnBoard(board1.getOcean(), computer);
			display.printBoardOwner(player1.getName());
			display.printBoardDuringShooting(board1.getOcean());
			// TODO write AI shotMessage
			display.printHitMessage(shotMessage, computer.getName(), computer);
			input.waitForEnter();
			isEnd = !player1.isAlive(board1.getOcean());
		}
		return !player1.isAlive(board1.getOcean()) ? computer.getName() : player1.getName();
	}

	public boolean isEnd() {
		// game end condition
		return false;
	}
}
