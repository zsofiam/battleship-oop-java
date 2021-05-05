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
		clearTerminal();

		System.out.println("______         _    _    _          _____  _      _");
		System.out.println("| ___ \\       | |  | |  | |        /  ___|| |    (_)");
		System.out.println("| |_/ /  __ _ | |_ | |_ | |  ___   \\ `--. | |__   _  _ __");
		System.out.println("| ___ \\ / _` || __|| __|| | / _ \\   `--. \\| '_ \\ | || '_ \\");
		System.out.println("| |_/ /| (_| || |_ | |_ | ||  __/  /\\__/ /| | | || || |_) |");
		System.out.println("\\____/  \\__,_| \\__| \\__||_| \\___|  \\____/ |_| |_||_|| .__/");
		System.out.println("                                                    | |");
		System.out.println("                                                    |_|");

		System.out.println("_____________________________________________________________");
		System.out.println("|                         WELCOME!                          |");
		System.out.println("|                                                           |");
		System.out.println("|                       1 - Play game                       |");
		System.out.println("|                       2 - High Score                      |");
		System.out.println("|                         0 - Exit                          |");
		System.out.println("_____________________________________________________________");
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

	public void printGameOver(int winner) {
		clearTerminal();

		System.out.println("  __ _   __ _  _ __ ___    ___      ___  __   __  ___  _ __    ");
		System.out.println(" / _` | / _` || '_ ` _ \\  / _ \\    / _ \\ \\ \\ / / / _ \\| '__|");
		System.out.println("| (_| || (_| || | | | | ||  __/   | (_) | \\ V / |  __/| |    _");
		System.out.println(" \\__, | \\__,_||_| |_| |_| \\___|    \\___/   \\_/   \\___||_|   (_)");
		System.out.println("  __/ |                                                        ");
		System.out.println("\\____/");

		System.out.println("_____________________________________________________________");
		System.out.println("|                     CONGRATULATIONS!                      |");
		System.out.println("|                                                           |");
		System.out.println("|                      PLAYER #"+String.valueOf(winner)+" WON!                       |");
		System.out.println("|                                                           |");
		System.out.println("|                                                           |");
		System.out.println("|            Press enter to return to the menu...           |");
		System.out.println("_____________________________________________________________");
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

	public void clearTerminal() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public void printTurn(String name) {
		System.out.println("* " + name + "'s turn!");
	}

	public void sayGoodbye() {
		System.out.println(" * Goodbye! *");
	}

}
