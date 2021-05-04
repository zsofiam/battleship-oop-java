package battleship;

public class Main {
	public static void main(String[] args) {
		int row = 10;
		int col = 10;
		Board board = new Board(row, col);
		int[] coordinates = {6, 6};
		String direction = "V";
		int length = 5;
		System.out.println(board.isPlacementOk(coordinates, direction, length)); // true
		int[] coordinates2 = {8, 8};
		System.out.println(board.isPlacementOk(coordinates2, direction, length)); // false
		String direction2 = "H";
		System.out.println(board.isPlacementOk(coordinates, direction2, length)); // true
		System.out.println(board.isPlacementOk(coordinates2, direction2, length)); // false
	}
}
