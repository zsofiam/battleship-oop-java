package battleship.game.player;

import battleship.game.Ship;
import battleship.game.Square;
import battleship.game.SquareStatus;

import java.util.List;

public class HumanPlayer extends Player{

	public HumanPlayer(String name) {
		super(name);
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

	public boolean isAlive() {
		boolean alive = false;
		for (var ship: ships) {
			if(ship.isWhole())
				alive = true;
		}
		return alive;
	}
}
