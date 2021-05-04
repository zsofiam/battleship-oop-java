package battleship;

import java.util.Scanner;

public class Input {
    private final Scanner scanner;
    private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXZY";

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public int[] getStartCoordinates(ShipType shipType) {
        boolean validInput = false;
        int coordinateX = 0;
        int coordinateY = 0;
        String coordinates = null;
        System.out.print(String.format("Please enter %s (length: %d) coordinates:%n", shipType.name(),shipType.length));
        while (!validInput){
            coordinates = scanner.nextLine();
            try {
                char rowLetter = Character.toUpperCase(coordinates.charAt(0));
                coordinateY = Integer.parseInt(coordinates.substring(1))-1;
                coordinateX = convertLetterToNumber(rowLetter);
            }
            catch (NumberFormatException|StringIndexOutOfBoundsException e){
                System.out.println("Please provide valid coordinates!");
                continue;
            }
            if(coordinateX == -1){
                System.out.println("Please provide valid coordinates!");
                continue;
            }
            validInput = true;
        }
        return new int[]{coordinateX, coordinateY};
    }

    private int convertLetterToNumber(char rowLetter) {
        return ALPHABET.indexOf(rowLetter);
    }

    public String getShipDirection() {
        boolean validInput = false;
        String direction = null;
        System.out.println("Please choose direction: h (horizontal) or v (vertical):");
        while (!validInput){
            direction = scanner.nextLine();
                if (direction.equalsIgnoreCase("h") || direction.equalsIgnoreCase("v")){
                    validInput = true;
                }
                else {
                System.out.println("Please choose 'h' or 'v'!");
                continue;
            }
        }
        return direction;
    }
    // gather every input
	// validate every input

}
