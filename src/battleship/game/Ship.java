package battleship.game;

import java.util.LinkedList;
import java.util.List;

public class Ship {
	private List<Square> squares;

	public Ship() {
		//Initialize empty squares
		this.squares = new LinkedList<>();
	}

	public Ship(List<Square> squares) {
		//We don't need to initialize, the argument is
		this.squares = squares;
	}

	//Add scares one-by-one in case we inited with Ship()
	public void addSquare(Square square) {
		squares.add(square);
	}

	//Get the whole list
	public List<Square> getSquares() {
		return squares;
	}

	//Get a specific square by coords
	public Square getSquareByCoord(int x, int y) {
		for (Square square : squares) {
			if (square.getX() == x && square.getY() == y) {
				return square;
			}
		}

		//This square has no ship
		return new Square(x, y, SquareStatus.EMPTY);
	}

	public boolean isWhole() {
		for(var sqr : squares){

		}
		return true;
	}
}
