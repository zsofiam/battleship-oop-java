package battleship;

import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public int[] getStartCoordinates(ShipType shipType) {
        boolean validInput = false;
        int row = 0;
        int col = 0;
        while (!validInput){
            System.out.println(String.format("Please enter %s (length: %d) coordinates:%n", shipType.name(),shipType.length));
            String coordinates = scanner.nextLine();
            try {
                row = Integer.parseInt(coordinates.substring(0,1));
                col = Integer.parseInt(coordinates.substring(1));
            }
            catch (NumberFormatException e){
                System.out.println("Coordinates are not valid!");
                continue;
            }
            validInput = true;
        }
        
        return new int[]{row, col};
    }

    public String getShipDirection() {
        return null;
    }
    // gather every input
	// validate every input
}
