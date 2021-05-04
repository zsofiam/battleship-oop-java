package battleship;

public enum SquareStatus {
	// (empty, ship, hit, missed) unicode character
	EMPTY(" 🌊"),
	SHIP(" ⛵"),
	HIT(" 🎯"),
	MISSED(" 🚩");

	String status;

	SquareStatus(String status) {
		this.status = status;
	}

	public String getCharacter() {
		return status; // empty, ship, hit, missed - graphical representation
	}

}
