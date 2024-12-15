package game.exceptions;

public class TileOccupiedException extends GameException {

    public static final String DEFAULT_ERROR_MESSAGE = "Tile Occupied: Map tile already built ! Cannot place new Tower !";

    /**
     * Constructs a new TileOccupiedException with a detailed error message.
     * This exception is thrown when the player tries to build a tower on an already populated tile.
     *
     * @see game.exceptions.GameException#GameException(String)
     */
    public TileOccupiedException() {
        super(DEFAULT_ERROR_MESSAGE);
    }
}