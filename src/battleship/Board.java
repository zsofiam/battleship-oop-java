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
		if (direction.equalsIgnoreCase("h")) {
			return startPosition[1] + shipLength - 1 <= colNum;
		// else vertical
		} else {
			return startPosition[0] + shipLength - 1 <= rowNum;
		}
	}
}
