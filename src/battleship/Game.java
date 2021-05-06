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
		String player1Name = input.askName(display, 1);
		String player2Name = input.askName(display, 2);
		player1 = new Player(player1Name);
		player2 = new Player(player2Name);
		BoardFactory factory1 = new BoardFactory(board1);
		BoardFactory factory2 = new BoardFactory(board2);
		display.clearScreen();
		display.printBoardOwner(player1.getName(), false);
		display.printBoardDuringPlacingShips(board1.getOcean());
		display.printTurn(player1.getName(), false);
		factory1.manualPlacement(player1, false);
		display.clearScreen();
		display.printBoardOwner(player2.getName(), false);
		display.printBoardDuringPlacingShips(board2.getOcean());
		display.printTurn(player2.getName(), false);
		factory2.manualPlacement(player2, false);

		while (!isEnd) {
			// print enemy board before shooting
			display.printBoardOwner(player2.getName(), false);
			display.printBoardDuringShooting(board2.getOcean());
			display.printTurn(player1.getName(), false);
			// shoot enemy
			shotMessage = factory2.getAndPlaceShotOnBoard(board2.getOcean(), null);
			display.clearScreen();
			display.printBoardOwner(player2.getName(), false);
			display.printBoardDuringShooting(board2.getOcean());
			display.printHitMessage(shotMessage, player2.getName(), null);
			input.waitForEnter();
			isEnd = !player2.isAlive(board2.getOcean());
			if (isEnd) {
				break;
			}
			input.waitForEnter();
			display.clearScreen();
			// print enemy board before shooting
			display.printBoardOwner(player1.getName(), false);
			display.printBoardDuringShooting(board1.getOcean());
			display.printTurn(player2.getName(), false);
			// shoot enemy
			shotMessage = factory1.getAndPlaceShotOnBoard(board1.getOcean(), null);
			display.clearScreen();
			display.printBoardOwner(player1.getName(), false);
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
		String player1Name = input.askName(display, 1);
		player1 = new Player(player1Name);
		computer = new ComputerPlayer("Computer Carl");
		BoardFactory factory1 = new BoardFactory(board1);
		BoardFactory factory2 = new BoardFactory(board2);
		display.clearScreen();
		display.printBoardOwner(player1.getName(), true);
		display.printBoardDuringPlacingShips(board1.getOcean());
		display.printTurn(player1.getName(), true);
		factory1.manualPlacement(player1, true);

		display.clearScreen();
		display.printComputerPlacingTurn(computer.getName());
		input.waitForEnter();
		factory2.randomPlacement();



		while (!isEnd) {
			// print enemy board before shooting
			display.printBoardOwner(computer.getName(), false);
			display.printBoardDuringShooting(board2.getOcean());
			display.printTurn(player1.getName(), true);
			// shoot computer
			shotMessage = factory2.getAndPlaceShotOnBoard(board2.getOcean(), null);
			display.clearScreen();
			display.printBoardOwner(computer.getName(), false);
			display.printBoardDuringShooting(board2.getOcean());
			display.printHitMessage(shotMessage, computer.getName(), null);
			input.waitForEnter();
			isEnd = !computer.isAlive(board2.getOcean());
			if (isEnd) {
				break;
			}
			display.clearScreen();
			display.printTurn(computer.getName(), false);
			// wait for computer to move
			input.waitForEnter();
			// TODO computer shoot player
			shotMessage = factory1.getAndPlaceShotOnBoard(board1.getOcean(), computer);
			display.printBoardOwner(player1.getName(), true);
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
