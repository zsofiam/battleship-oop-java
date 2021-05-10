package battleship.game.player;

import java.util.List;

public abstract class Player {
    private List<Ship> ships;
    private String name;

    public String getName() {
        return name;
    }

    Player(String name) {this.name = name;}

}
