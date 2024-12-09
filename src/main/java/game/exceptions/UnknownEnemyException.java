package game.exceptions;

public class UnknownEnemyException extends GameException {

    public static final String DEFAULT_ERROR_MESSAGE = "Unknown Enemy : the current wave is trying to place an enemy with an unknown type.";

    /**
     * Constructs a new UnknownEnemyException with a detailed error message.
     * This exception is thrown when the current wave contains an enemy with an unknown type.
     *
     * @param levelPath The file path of the level containing the wave.
     * @param wavePath The file path of the wave containing the unknown enemy.
     * @param lineNumber The line number where the unknown enemy is called in the wave file.
     * @param lineContent The content of the line where the unknown enemy is called in the wave file.
     * @see game.exceptions.GameException#GameException(String)
     * @see game.mobs.Element to see available types
     */
    public UnknownEnemyException(String levelPath, String wavePath, int lineNumber, String lineContent) {
        StringBuilder sb = new StringBuilder();
        sb.append(DEFAULT_ERROR_MESSAGE).append("\n");
        sb.append("Level Path: ").append(levelPath).append("\n");
        sb.append("Wave Path: ").append(wavePath).append("\n");
        sb.append("Line Number: ").append(lineNumber).append("\n");
        String fullErrorMessage = sb.toString();
        super(fullErrorMessage);
    }
}
