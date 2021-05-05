package battleship;

import java.util.List;

public class Player {
	private List<Ship> ships;
	private String name;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void handleShot(Square[][] enemyBoard, int[] coordinates) {
		int row = coordinates[0];
		int col = coordinates[1];
		if (enemyBoard[row][col].getStatus() == SquareStatus.SHIP) {
			enemyBoard[row][col].setStatus(SquareStatus.HIT);
		} else {
			enemyBoard[row][col].setStatus(SquareStatus.MISSED);
		}
	}

	public boolean isAlive(Square[][] board) {
		for (Square[] row: board) {
			for (Square square: row) {
				if (square.getStatus() == SquareStatus.SHIP) {
					return true;
				}
			}
		}
		return false;
	}
}
