package battleship.game;

public class Square {
	private int X;
	private int Y;
	private SquareStatus status;

	public Square(int x, int y, SquareStatus status) {
		X = x;
		Y = y;
		this.status = status;
	}


	// do we need getter and setter?
	// difference getStataus vs getCharacter?
	public SquareStatus getStatus() {
		return status;
	}

	public void setStatus(SquareStatus status) {
		this.status = status;
	}

	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}
}
