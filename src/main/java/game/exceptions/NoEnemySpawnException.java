package game.exceptions;

public class NoEnemySpawnException extends GameException {

    public static final String DEFAULT_ERROR_MESSAGE = "No Enemy Spawn: The provided Map file does not contain any enemy spawn.";

    /**
     * Constructs a new NoEnemySpawnException with a detailed error message.
     * This exception is thrown when the provided map file does not contain an enemy spawn.
     *
     * @param levelPath The file path of the level containing the invalid map.
     * @param mapFile   The name or path of the specific map file that is invalid.
     * @see game.exceptions.GameException#GameException(String)
     */
    public NoEnemySpawnException(String levelPath, String mapFile) {
        StringBuilder sb = new StringBuilder();
        sb.append(DEFAULT_ERROR_MESSAGE).append("\n");
        sb.append("Map File: ").append(mapFile).append("\n");
        sb.append("Level Path: ").append(levelPath).append("\n");
        String fullErrorMessage = sb.toString();
        super(fullErrorMessage);
    }
}
