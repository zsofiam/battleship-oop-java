package battleship;

import java.util.Scanner;

public class Input {
    private final Scanner scanner;
    private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXZY";

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public int[] getValidCoordinates() {
        boolean validInput = false;
        int coordinateX = 0;
        int coordinateY = 0;
        String coordinates = null;

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


    public int getMenuInput() {
        boolean validInput = false;
        int nextState = -1;
        System.out.println("\n                   Waiting for your input..");

        while (!validInput){
            nextState = scanner.nextInt();
            if (nextState == 0 || nextState < 3) {
                validInput = true;
            }
            else {
                System.out.println("\n      Please choose from the menu options!");
                continue;
            }
        }
        return nextState;
    }

    public int getGameMode() {
        boolean validInput = false;
        String mode = null;
        System.out.println("Please choose your desired game mode: pvp (Player vs. Player) or pva (Player vs. AI):");
        while (!validInput){
            mode = scanner.nextLine();
            if (mode.equalsIgnoreCase("pvp") || mode.equalsIgnoreCase("pva")){
                validInput = true;
            }
            else {
                System.out.println("Please choose from the options (pvp or pva)!");
                continue;
            }
        }

        //pvp = 1; pva = 2 - it returned always 2 when used the "==" instead of "equals"
        return (mode.equalsIgnoreCase("pvp") ? 1 : 2);
    }

    public void waitForEnter() {
        boolean validInput = false;
        scanner.nextLine();
    }

}
