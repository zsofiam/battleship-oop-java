package battleship;

public class Board {
	private Square[][] ocean;

	public Board(int row, int col) {
		ocean = new Square[row][col];
		fillBoard(row, col);
	}
	private void fillBoard(int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				ocean[i][j] = new Square(i, j, SquareStatus.EMPTY);
			}
		}
	}
	public boolean isPlacementOk() {
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
