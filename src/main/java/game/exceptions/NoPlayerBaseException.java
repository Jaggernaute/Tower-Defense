package game.exceptions;

public class NoPlayerBaseException extends GameException {

    public static final String DEFAULT_ERROR_MESSAGE = "No Player Base: The provided Map file does not contain any player base.";

    /**
     * Constructs a new NoEnemySpawnException with a detailed error message.
     * This exception is thrown when the provided map file does not contain a player base.
     *
     * @param levelPath The file path of the level containing the invalid map.
     * @param mapFile   The name or path of the specific map file that is invalid.
     * @see game.exceptions.GameException#GameException(String)
     */
    public NoPlayerBaseException(String levelPath, String mapFile) {
        StringBuilder sb = new StringBuilder();
        sb.append(DEFAULT_ERROR_MESSAGE).append("\n");
        sb.append("Map File: ").append(mapFile).append("\n");
        sb.append("Level Path: ").append(levelPath).append("\n");
        String fullErrorMessage = sb.toString();
        super(fullErrorMessage);
    }
}
