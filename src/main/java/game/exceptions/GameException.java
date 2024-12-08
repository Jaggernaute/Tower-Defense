package game.exceptions;

public class GameException extends Exception {
    
    private static final String DEFAULT_ERROR_MESSAGE = "An Error has occurred during the execution of the game, please see the stacktrace if available";

    /**
     * Constructs a new GameException with the default error message.
     * This constructor creates an exception without a specific cause or custom message,
     * using the predefined DEFAULT_ERROR_MESSAGE.
     */
    public GameException() {
        super(DEFAULT_ERROR_MESSAGE);
    }

    /**
     * Constructs a new GameException with a custom error message.
     *
     * @param message The error message associated with this exception.
     */
    public GameException(String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(DEFAULT_ERROR_MESSAGE).append("\n");
        sb.append(message).append("\n");
        String fullErrorMessage = sb.toString();
        super(fullErrorMessage);
    }
}
