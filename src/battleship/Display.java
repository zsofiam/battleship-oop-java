package battleship;

public class Display {
	int col;
	int row;
	private String[] letters;

	public Display(int row, int col) {
		this.row = row;
		this.col = col;
		letters = new String[col];
		generateLetters();
	}

	public void printMenu() {

	}

	public void printBoardDuringPlacingShips(Square[][] ocean) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(ocean[i][j].getStatus().getCharacter());
			}
			System.out.println("");
		}
		System.out.println("------------");
	}

	public void printBoardDuringShooting(Square[][] ocean) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				// you cannot see the ships just the hits or missed hits and ocean
				if (ocean[i][j].getStatus() == SquareStatus.EMPTY ||
					ocean[i][j].getStatus() == SquareStatus.HIT ||
					ocean[i][j].getStatus() == SquareStatus.MISSED) {
					System.out.print(ocean[i][j].getStatus().getCharacter());
				} else if (ocean[i][j].getStatus() == SquareStatus.SHIP){
					System.out.print(SquareStatus.EMPTY.getCharacter());
				}
			}
			System.out.println("");
		}
		System.out.println("------------");
	}

	public void printGameOver() {

	}

	public void generateLetters() {
		int index = 0;
		for (char c = 'A'; c < 'Z'; c++) {
			if (index == col) {
				break;
			}
			letters[index++] = String.valueOf(c);
		}

	}

}
