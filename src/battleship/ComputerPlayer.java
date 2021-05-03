package battleship;

public class ComputerPlayer {
	public void ComputerPlayerEasy() {
		// random, excluding struck fields
	}
	public void ComputerPlayerNormal() {
		// also excludes fields around ships when taking random hits.
		//  shoots around a ship after hitting it to determine its direction.
		//  changes direction to opposite when can not go further.
		//  follows the direction until the ship is sunk.
	}
	public void ComputerPlayerHard() {
		// uses ComputerPlayerNormal logic but shoots diagonal fields only.
	}
}
