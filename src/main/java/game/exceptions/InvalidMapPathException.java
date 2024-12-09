package game.exceptions;

public class InvalidMapPathException extends GameException {

    public static final String DEFAULT_ERROR_MESSAGE = "Invalid Map Path: The provided Map file does not contain a clear path from the enemy base to the player base.";

    /**
     * Constructs a new InvalidMapPathException with a detailed error message.
     * This exception is thrown when the provided map file does not contain a valid path
     * from the enemy base to the player base.
     *
     * @param reason    A string describing the specific reason for the invalid map path it can be one of :
     *                  <p><ul>
     *                      <li>No path found</li>
     *                      <li>Multiple paths found</li>
     *                      <li>A loop was found</li>
     *                  </ul></p>
     * @param levelPath The file path of the level containing the invalid map.
     * @param mapFile   The name or path of the specific map file that is invalid.
     * @see game.exceptions.GameException#GameException(String)
     */
    public InvalidMapPathException(String reason, String levelPath, String mapFile) {
        StringBuilder sb = new StringBuilder();
        sb.append(DEFAULT_ERROR_MESSAGE).append("\n");
        sb.append("Map File: ").append(mapFile).append("\n");
        sb.append("Level Path: ").append(levelPath).append("\n");
        sb.append("Reason: ").append(reason).append("\n");
        String fullErrorMessage = sb.toString();
        super(fullErrorMessage);
    }
}
