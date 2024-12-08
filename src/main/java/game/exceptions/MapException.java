package game.exceptions;

public class MapException extends GameException {

    public static final String DEFAULT_ERROR_MESSAGE = "Invalid Map: The provided map file is dimmed invalid, see reason bellow.";

    /**
     * Constructs a new MapException with a detailed error message.
     * This exception is thrown when the provided map file does not follow the criteria for a
     * valid map.
     *
     * @param reason    A string describing the specific reason for the invalid map, it can be one of :
     *                  <p><ul>
     *                      <li>Unknown tile</li>
     *                      <li>Inconsistent width</li>
     *                      <li>Inconsistent height</li>
     *                  </ul></p>
     * @param levelPath The file path of the level containing the invalid map.
     * @param mapFile   The name or path of the specific map file that is invalid.
     * @see game.exceptions.GameException#GameException(String)
     */
    public MapException(String reason, String levelPath, String mapFile) {
        StringBuilder sb = new StringBuilder();
        sb.append(DEFAULT_ERROR_MESSAGE).append("\n");
        sb.append("Map File: ").append(mapFile).append("\n");
        sb.append("Level Path: ").append(levelPath).append("\n");
        sb.append("Reason: ").append(reason).append("\n");
        String fullErrorMessage = sb.toString();
        super(fullErrorMessage);
    }
}
