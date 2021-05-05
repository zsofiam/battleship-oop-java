package battleship;

public class Board {
	private Square[][] ocean;
	private int rowNum;
	private int colNum;
	private SquareStatus status;

	public Board(int row, int col) {
		ocean = new Square[row][col];
		rowNum = row;
		colNum = col;
		fillBoard(row, col);
	}
	private void fillBoard(int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				ocean[i][j] = new Square(i, j, SquareStatus.EMPTY);
			}
		}
	}
	public boolean isPlacementOk(int[] startPosition, String direction, int shipLength) {
		int row = startPosition[0];
		int col = startPosition[1];
		if (!isSquareOnBoard(row, col)){
			return false;
		}
		if (direction.equalsIgnoreCase("h")) {
			// check if outside of board
			if (col + shipLength - 1 >= colNum) {
				return false;
			}
			// check for occupied places in surrounding 3 rows and shipLength+2 columns
			for (int i = -1; i < 2; i ++) {
				for (int j = -1; j <= shipLength; j++) {
					// skips the diagonal places and the out of board places around the ship
					if ((j == -1 && i != 0) || (j == shipLength && i != 0)
						|| row + i < 0 || row + i >= rowNum
						|| col + j < 0 || col + j >= colNum) {
						continue;
					}
					if (row + i >= 0 && col + j >= 0) {
						if (ocean[row + i][col + j].getStatus() == SquareStatus.SHIP) {
							return false;
						}
					}
				}
			}
		// else vertical
		} else {
			if (row + shipLength - 1 >= rowNum) {
				return false;
			}
			// check for occupied places in surrounding shipLength+2 rows and 3 columns
			for (int i = -1; i <= shipLength; i++) {
				for (int j = -1; j < 2; j++) {
					// skips the diagonal places and the out of board places around the ship
					if ((i == -1 && j != 0) || (i == shipLength && j != 0)
						|| row + i < 0 || row + i >= rowNum
						|| col + j < 0 || col + j >= colNum) {
						continue;
					}
					if (row + i >= 0 && col + j >= 0) {
						if (ocean[row + i][col + j].getStatus() == SquareStatus.SHIP) {
							return false;
						}
					}
				}
			}
		}

		return true;
	}

	public boolean isShotOk(int[] squarePosition){
		int row = squarePosition[0];
		int col = squarePosition[1];
		return isSquareOnBoard(row, col) && isSquareEmptyOrShip(row, col);
	}

	private boolean isSquareEmptyOrShip(int row, int col) {
		status = ocean[row][col].getStatus();
		return status.equals(SquareStatus.EMPTY) || status.equals(SquareStatus.SHIP);
	}

	private boolean isSquareOnBoard(int row, int col) {
		return row >= 0 && row < rowNum && col >= 0 && col < colNum;
	}

	public int getRows() {
		return ocean.length;
	}

	public int getColumns() {
		return ocean[0].length;
	}

	public Square[][] getOcean() {
		return ocean;
	}
	public void placeShot(int[]squarePosition){
		//TO DO - mark shot on board
	}
}
