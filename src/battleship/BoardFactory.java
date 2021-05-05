package battleship;

import java.util.Random;

public class BoardFactory {

	private final Board board;
	private final Random random;
	private final Input input;

	public BoardFactory(Board board) {
		this.board = board;
		this.input = new Input();
		random = new Random();
	}

	public void randomPlacement() {
		int boardSize = getBoardSize();
		if (boardSize > 5) {
			checkAndPlaceOnBoardRandom(ShipType.CARRIER);
		} if (boardSize > 15) {
			checkAndPlaceOnBoardRandom(ShipType.CRUISER);
		} if (boardSize > 25) {
			checkAndPlaceOnBoardRandom(ShipType.BATTLESHIP);
		} if (boardSize > 35) {
			checkAndPlaceOnBoardRandom(ShipType.SUBMARINE);
		} if (boardSize > 45) {
			checkAndPlaceOnBoardRandom(ShipType.DESTROYER);
		}
	}

	private void checkAndPlaceOnBoardRandom(ShipType shipType) {
		boolean isPlacementOk = false;
		int row = 0;
		int col = 0;
		String[] directions = new String[]{"h", "v"};
		String direction = null;
		int[] startPosition;
		int length = shipType.length;
		while (!isPlacementOk){
			row = random.nextInt(getBoardRows());
			col = random.nextInt(getBoardColumns());
			direction = directions[random.nextInt(2)];
			startPosition = new int[]{row,col};
			isPlacementOk = board.isPlacementOk(startPosition, direction, length);
		}
		placeOnBoard(shipType.length, new int[]{row,col}, direction);
	}

	private void placeOnBoard(int length, int[]startPosition, String direction){
		int row = startPosition[0];
		int col = startPosition[1];
		if(direction.equals("h")){
			for(int i = 0; i < length; i++){
				board.getOcean()[row][col+i] = new Square(row, (col+i), SquareStatus.SHIP);
			}
		}
		else{
			for(int i = 0; i < length; i++){
				board.getOcean()[row+i][col] = new Square((row+i), col, SquareStatus.SHIP);
			}
		}
	}

	private int getBoardSize() {
		return getBoardRows() * getBoardColumns();
	}

	private int getBoardColumns() {
		return board.getColumns();
	}

	private int getBoardRows() {
		return board.getRows();
	}

	public void manualPlacement() {
		int boardSize = getBoardSize();
		if (boardSize > 5) {
			checkAndPlaceOnBoardManual(ShipType.CARRIER);
		} if (boardSize > 15) {
			checkAndPlaceOnBoardManual(ShipType.CRUISER);
		} if (boardSize > 25) {
			checkAndPlaceOnBoardManual(ShipType.BATTLESHIP);
		} if (boardSize > 35) {
			checkAndPlaceOnBoardManual(ShipType.SUBMARINE);
		} if (boardSize > 45) {
			checkAndPlaceOnBoardManual(ShipType.DESTROYER);
		}
	}

	private void checkAndPlaceOnBoardManual(ShipType shipType) {
		boolean isPlacementOk = false;
		int row = 0;
		int col = 0;
		String direction = null;
		int[] startPosition;
		int length = shipType.length;
		while (!isPlacementOk){
			startPosition = input.getStartCoordinates(shipType);
			direction = input.getShipDirection();
			isPlacementOk = board.isPlacementOk(startPosition, direction, length);
			if(!isPlacementOk){
				System.out.println("Cannot place ship there. Please try again!");
			}
		}
		placeOnBoard(shipType.length, new int[]{row,col}, direction);
	}

}
