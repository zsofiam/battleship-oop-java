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
		for (int i = 0; i <= row; i++) {
			for (int j = 0; j <= col; j++) {
				if (i == 0 && j == 0) {
					System.out.print("   ");
				} else if (i == 0) {
					System.out.print(" " + letters[j - 1] + " ");
				} else if (j == 0){
					if (i > 9) {
						System.out.print(i + "  ");
					} else {
						System.out.print(i + "   ");
					}
				} else {
					System.out.print(ocean[i - 1][j - 1].getStatus().getCharacter());
				}

			}
			System.out.println("");
		}
		System.out.println("");
	}

	public void printBoardDuringShooting(Square[][] ocean) {
		for (int i = 0; i <= row; i++) {
			for (int j = 0; j <= col; j++) {
				if (i == 0 && j == 0) {
					System.out.print("   ");
				} else if (i == 0) {
					System.out.print(" " + letters[j - 1] + " ");
				} else if (j == 0){
					if (i > 9) {
						System.out.print(i + "  ");
					} else {
						System.out.print(i + "   ");
					}
				} else {
					// you cannot see the ships just the hits or missed hits and ocean
					if (ocean[i - 1][j - 1].getStatus() == SquareStatus.EMPTY ||
							ocean[i - 1][j - 1].getStatus() == SquareStatus.HIT ||
							ocean[i - 1][j - 1].getStatus() == SquareStatus.MISSED) {
						System.out.print(ocean[i - 1][j - 1].getStatus().getCharacter());
					} else if (ocean[i - 1][j - 1].getStatus() == SquareStatus.SHIP){
						System.out.print(SquareStatus.EMPTY.getCharacter());
					}
				}

			}
			System.out.println("");
		}
		System.out.println("");
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
