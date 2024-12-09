package game.exceptions;

public class NotEnoughMoneyException extends GameException {

    public static final String DEFAULT_ERROR_MESSAGE = "Invalid Map Path: Not enough money to build Tower ! Please, kill enemies to gain wealth or be cheap and buy something you can afford.";

    /**
     * Constructs a new NotEnoughMoneyException with a detailed error message.
     * This exception is thrown when the player does not have enough money to buy a tower.

     * @see game.exceptions.GameException#GameException(String)
     */
    public NotEnoughMoneyException() {
        super(DEFAULT_ERROR_MESSAGE);
    }
}
