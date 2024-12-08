package game.exceptions;

public class InvalidMapPathException extends GameException {

    public static final String DEFAULT_ERROR_MESSAGE = "Invalid Map Path: The provided path does not exist or is not accessible";

    public InvalidMapPathException() {
        super(DEFAULT_ERROR_MESSAGE);
    }

    /**
     * Constructs a new GameException with a detailed error message including the cause and stack trace.
     *
     * @param message The error message associated with this exception (not used in the current implementation).
     */
    public InvalidMapPathException(String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(DEFAULT_ERROR_MESSAGE).append("\n");
        sb.append("Message: ").append(message).append("\n");
        String fullErrorMessage = sb.toString();
        super(fullErrorMessage);
    }

    /**
     * Constructs a new GameException with a detailed error message including the cause and stack trace.
     *
     * @param cause   The underlying cause of this exception.
     */
    public InvalidMapPathException(Throwable cause) {
        super(DEFAULT_ERROR_MESSAGE, cause);
    }

    /**
     * Constructs a new GameException with a detailed error message including the cause and stack trace.
     *
     * @param message The error message associated with this exception (not used in the current implementation).
     * @param cause   The underlying cause of this exception.
     */
    public InvalidMapPathException(String message, Throwable cause) {
        StringBuilder sb = new StringBuilder();
        sb.append(DEFAULT_ERROR_MESSAGE).append("\n");
        sb.append("Message: ").append(message).append("\n");
        String fullErrorMessage = sb.toString();
        super(fullErrorMessage, cause);
    }
}
