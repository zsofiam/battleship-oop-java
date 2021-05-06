package battleship;

import java.util.Random;

public class BoardFactory {

    private final Board board;
    private final Random random;
    private final Input input;
    private final Display display;

    public BoardFactory(Board board) {
        this.board = board;
        this.input = new Input();
        random = new Random();
        display = new Display(board.getRows(), board.getColumns());
    }

    public void randomPlacement() throws InterruptedException {
        int boardSize = getBoardSize();
        Square[][] ocean = board.getOcean();
        if (boardSize > 5) {
            checkAndPlaceOnBoardRandom(ShipType.CARRIER);
            display.printBoardDuringPlacingShips(ocean);
            Thread.sleep(1000);
        }
        if (boardSize > 15) {
            checkAndPlaceOnBoardRandom(ShipType.CRUISER);
            display.printBoardDuringPlacingShips(ocean);
            Thread.sleep(1000);
        }
        if (boardSize > 25) {
            checkAndPlaceOnBoardRandom(ShipType.BATTLESHIP);
            display.printBoardDuringPlacingShips(ocean);
            Thread.sleep(1000);
        }
        if (boardSize > 35) {
            checkAndPlaceOnBoardRandom(ShipType.SUBMARINE);
            display.printBoardDuringPlacingShips(ocean);
            Thread.sleep(1000);
        }
        if (boardSize > 45) {
            checkAndPlaceOnBoardRandom(ShipType.DESTROYER);
            display.printBoardDuringPlacingShips(ocean);
            Thread.sleep(1000);
        }
    }

    private void checkAndPlaceOnBoardRandom(ShipType shipType) {
        boolean isPlacementOk = false;
        int row = 0;
        int col = 0;
        String[] directions = new String[]{"h", "v"};
        String direction = null;
        int[] startPosition = null;
        int length = shipType.length;
        while (!isPlacementOk) {
            row = random.nextInt(getBoardRows());
            col = random.nextInt(getBoardColumns());
            direction = directions[random.nextInt(2)];
            startPosition = new int[]{row, col};
            isPlacementOk = board.isPlacementOk(startPosition, direction, length);
        }
        placeOnBoard(shipType.length, startPosition, direction);
    }

    private void placeOnBoard(int length, int[] startPosition, String direction) {
        int row = startPosition[0];
        int col = startPosition[1];
        if (direction.equals("h")) {
            for (int i = 0; i < length; i++) {
                board.getOcean()[row][col + i] = new Square(row, (col + i), SquareStatus.SHIP);
            }
        } else {
            for (int i = 0; i < length; i++) {
                board.getOcean()[row + i][col] = new Square((row + i), col, SquareStatus.SHIP);
            }
        }
    }

    private int getBoardSize() {
        return getBoardRows() * getBoardColumns();
    }

    private int getBoardColumns() {
        return board.getColumns();
    }

    private int getBoardRows() {
        return board.getRows();
    }

    public void manualPlacement() {
        int boardSize = getBoardSize();
        Square[][] ocean = board.getOcean();
        if (boardSize > 5) {
            checkAndPlaceOnBoardManual(ShipType.CARRIER);
            display.printBoardDuringPlacingShips(ocean);
        }
        if (boardSize > 15) {
            checkAndPlaceOnBoardManual(ShipType.CRUISER);
            display.printBoardDuringPlacingShips(ocean);
        }
        if (boardSize > 25) {
            checkAndPlaceOnBoardManual(ShipType.BATTLESHIP);
            display.printBoardDuringPlacingShips(ocean);
        }
        if (boardSize > 35) {
            checkAndPlaceOnBoardManual(ShipType.SUBMARINE);
            display.printBoardDuringPlacingShips(ocean);
        }
        if (boardSize > 45) {
            checkAndPlaceOnBoardManual(ShipType.DESTROYER);
            display.printBoardDuringPlacingShips(ocean);
        }
    }

    private void checkAndPlaceOnBoardManual(ShipType shipType) {
        boolean isValidPlacement = false;
        String direction = null;
        int[] startPosition = null;
        int length = shipType.length;
        while (!isValidPlacement) {
            System.out.print(String.format("Please enter %s (length: %d) coordinates:%n", shipType.name(), shipType.length));
            startPosition = input.getValidCoordinates();
            direction = input.getShipDirection();
            isValidPlacement = board.isPlacementOk(startPosition, direction, length);
            if (!isValidPlacement) {
                System.out.println("Cannot place ship there. Please try again!");
            }
        }
        placeOnBoard(shipType.length, startPosition, direction);
    }

    public String getAndPlaceShotOnBoard(Square[][] enemyBoard) {
        boolean validShot = false;
        int[] squarePosition = new int[2];
        System.out.println("Provide shooting coordinates!");
        while (!validShot) {
            squarePosition = input.getValidCoordinates();
            validShot = board.isShotOk(squarePosition);
            if (!validShot) {
                System.out.println("Not valid shot. Please try again!");
            }
        }
        return board.placeShot(squarePosition, enemyBoard);
    }

}
