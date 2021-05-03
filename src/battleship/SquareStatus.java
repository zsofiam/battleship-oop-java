package battleship;

public enum SquareStatus {
	// (empty, ship, hit, missed) unicode character
	EMPTY("."),
	SHIP("S"),
	HIT("H"),
	MISSED("X");

	String status;

	SquareStatus(String status) {
		this.status = status;
	}

}
