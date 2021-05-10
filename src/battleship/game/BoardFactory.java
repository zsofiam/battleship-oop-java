package battleship.game;

import battleship.game.player.ComputerPlayer;
import battleship.game.player.HumanPlayer;
import battleship.view.Display;
import battleship.view.Input;

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

    public void randomPlacement() {
        int boardSize = getBoardSize();
        if (boardSize > 5) {
            checkAndPlaceOnBoardRandom(ShipType.CARRIER);
        }
        if (boardSize > 15) {
            checkAndPlaceOnBoardRandom(ShipType.CRUISER);
        }
        if (boardSize > 25) {
            checkAndPlaceOnBoardRandom(ShipType.BATTLESHIP);
        }
        if (boardSize > 35) {
            checkAndPlaceOnBoardRandom(ShipType.SUBMARINE);
        }
        if (boardSize > 45) {
            checkAndPlaceOnBoardRandom(ShipType.DESTROYER);
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

    public void manualPlacement(HumanPlayer player, boolean isJustMe) {
        int boardSize = getBoardSize();
        Square[][] ocean = board.getOcean();
        if (boardSize > 5) {
            checkAndPlaceOnBoardManual(ShipType.CARRIER);
            display.clearScreen();
            display.printBoardOwner(player.getName(), isJustMe);
            display.printBoardDuringPlacingShips(ocean);
            input.waitForEnter();
        }
        if (boardSize > 15) {
            checkAndPlaceOnBoardManual(ShipType.CRUISER);
            display.clearScreen();
            display.printBoardOwner(player.getName(), isJustMe);
            display.printBoardDuringPlacingShips(ocean);
            input.waitForEnter();
        }
        if (boardSize > 25) {
            checkAndPlaceOnBoardManual(ShipType.BATTLESHIP);
            display.clearScreen();
            display.printBoardOwner(player.getName(), isJustMe);
            display.printBoardDuringPlacingShips(ocean);
            input.waitForEnter();
        }
        if (boardSize > 35) {
            checkAndPlaceOnBoardManual(ShipType.SUBMARINE);
            display.clearScreen();
            display.printBoardOwner(player.getName(), isJustMe);
            display.printBoardDuringPlacingShips(ocean);
            input.waitForEnter();
        }
        if (boardSize > 45) {
            checkAndPlaceOnBoardManual(ShipType.DESTROYER);
            display.clearScreen();
            display.printBoardOwner(player.getName(), isJustMe);
            display.printBoardDuringPlacingShips(ocean);
            input.waitForEnter();
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

    public String getAndPlaceShotOnBoard(Square[][] enemyBoard, ComputerPlayer computer) {
        boolean validShot = false;
        int[] squarePosition = new int[2];
        if (computer == null) {
            System.out.println("Provide shooting coordinates!");
        }
        while (!validShot) {
            if (computer == null) {
                squarePosition = input.getValidCoordinates();
            } else {
                int row = random.nextInt(getBoardRows());
                int col = random.nextInt(getBoardColumns());
                squarePosition = new int[]{row, col};
            }
            validShot = board.isShotOk(squarePosition);
            if (!validShot) {
                if (computer == null) {
                    System.out.println("Not valid shot. Please try again!");
                }
            }
        }
        return board.placeShot(squarePosition, enemyBoard);
    }

}
