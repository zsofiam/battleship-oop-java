package battleship;

public class Board {
	private Square[][] ocean;
	private int rowNum;
	private int colNum;

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
		if (!isFieldOnBoard(row, col)){
			return false;
		}
		if (direction.equalsIgnoreCase("h")) {
			// check if outside of board
			if (col + shipLength - 1 > colNum) {
				return false;
			}
			// check for occupied places in surrounding 3 rows and shipLength+2 columns
			for (int i = -1; i < 2; i ++) {
				for (int j = -1; j <= shipLength; j++) {
					if ((j == -1 && i != 0) || (j == shipLength && i != 0)) {
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
			if (row + shipLength - 1 > rowNum) {
				return false;
			}
			// check for occupied places in surrounding shipLength+2 rows and 3 columns
			for (int i = -1; i <= shipLength; i++) {
				for (int j = -1; j < 2; j++) {
					if ((i == -1 && j != 0) || (i == shipLength && j != 0)) {
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

	private boolean isFieldOnBoard(int row, int col) {
		if(row < 0 || row >= rowNum || col < 0 || col >= colNum){
			return false;
		}
		return true;
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
}
