package battleship;

import java.util.Random;

public class BoardFactory {

	private Board board;
	private Random random;
	private Input input;

	public void randomPlacement() {

		int boardSize = getBoardSize();
		if (boardSize > 5) {
			placeOnBoard(ShipType.CARRIER);
		} if (boardSize > 15) {
			placeOnBoard(ShipType.CRUISER);
		} if (boardSize > 25) {
			placeOnBoard(ShipType.BATTLESHIP);
		} if (boardSize > 35) {
			placeOnBoard(ShipType.SUBMARINE);
		} if (boardSize > 45) {
			placeOnBoard(ShipType.DESTROYER);
		}
	}

	private void placeOnBoard(ShipType shipType) {
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
			placeOnBoardManual(ShipType.CARRIER);
		} if (boardSize > 15) {
			placeOnBoardManual(ShipType.CRUISER);
		} if (boardSize > 25) {
			placeOnBoardManual(ShipType.BATTLESHIP);
		} if (boardSize > 35) {
			placeOnBoardManual(ShipType.SUBMARINE);
		} if (boardSize > 45) {
			placeOnBoardManual(ShipType.DESTROYER);
		}
	}

	private void placeOnBoardManual(ShipType shipType) {
		boolean isPlacementOk = false;
		int row = 0;
		int col = 0;
		String[] directions = new String[]{"h", "v"};
		String direction = null;
		int[] startPosition = new int[2];
		int length = shipType.length;
		while (!isPlacementOk){
			startPosition = input.getStartCoordinates(shipType);
			direction = input.getShipDirection();
			isPlacementOk = board.isPlacementOk(startPosition, direction, length);
		}
		placeOnBoard(shipType.length, new int[]{row,col}, direction);
	}
}
