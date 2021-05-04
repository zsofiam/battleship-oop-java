package battleship;

import java.util.Random;

public class BoardFactory {

	private Board board;
	private ShipType shipType;
	private Random random;

	public void randomPlacement() {

		int boardSize = getBoardSize();
		if (boardSize > 5) {
			placeOnBoard(shipType.CARRIER);
		} if (boardSize > 15) {
			placeOnBoard(shipType.CRUISER);
		} if (boardSize > 25) {
			placeOnBoard(shipType.BATTLESHIP);
		} if (boardSize > 35) {
			placeOnBoard(shipType.SUBMARINE);
		} if (boardSize > 45) {
			placeOnBoard(shipType.DESTROYER);
		}
	}

	private void placeOnBoard(ShipType shipType) {
		boolean isPlacementOk = false;
		int row = 0;
		int col = 0;
		String[] directions = new String[]{"h", "v"};
		String direction;
		int[] startPosition;
		int length = shipType.length;
		while (!isPlacementOk){
			row = random.nextInt(getBoardRows());
			col = random.nextInt(getBoardColumns());
			direction = directions[random.nextInt(2)];
			startPosition = new int[]{row,col};
			isPlacementOk = board.isPlacementOk(startPosition, direction, length);
		}
		placeOnBoard(shipType, new int[]{row,col}, direction);
	}
	private void placeOnBoard(ShipType shipType, int[]startPosition, String direction){

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

	}
}
