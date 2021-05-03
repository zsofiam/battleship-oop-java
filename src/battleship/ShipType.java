package battleship;

public enum ShipType {

    CARRIER(2),
    CRUISER(3),
    BATTLESHIP(4),
    SUBMARINE(5),
    DESTROYER(6);

    public final int length;

    private ShipType(int length) {
        this.length = length;
    }
}
