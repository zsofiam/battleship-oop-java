package battleship;

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
}
