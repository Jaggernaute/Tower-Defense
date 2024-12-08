package game.exceptions;

import java.util.Arrays;

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
        sb.append("Message: ").append(message).append("\n");
        String fullErrorMessage = sb.toString();
        super(fullErrorMessage);
    }

    /**
     * Constructs a new GameException with a custom error message and cause.
     *
     * @param cause   The underlying cause of this exception.
     */
    public GameException(Throwable cause) {
        StringBuilder sb = new StringBuilder();
        sb.append(DEFAULT_ERROR_MESSAGE).append("\n");
        sb.append("Caused by: ").append(cause.getClass().getName()).append(" - ").append(cause.getMessage()).append("\n");
        sb.append("Stack Trace: ").append(Arrays.toString(cause.getStackTrace())).append("\n");
        String fullErrorMessage = sb.toString();
        super(fullErrorMessage, cause);
    }

    /**
     * Constructs a new GameException with a custom error message and cause.
     *
     * @param message The error message associated with this exception.
     * @param cause   The underlying cause of this exception.
     */
    public GameException(String message, Throwable cause) {
        StringBuilder sb = new StringBuilder();
        sb.append(DEFAULT_ERROR_MESSAGE).append("\n");
        sb.append("Message: ").append(message).append("\n");
        sb.append("Caused by: ").append(cause.getClass().getName()).append(" - ").append(cause.getMessage()).append("\n");
        sb.append("Stack Trace: ").append(Arrays.toString(cause.getStackTrace())).append("\n");
        String fullErrorMessage = sb.toString();
        super(fullErrorMessage, cause);
    }
}
