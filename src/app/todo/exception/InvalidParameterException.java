package app.todo.exception;

/**
 * @since       2020.03.14
 * @author      pollra
 * @description
 **********************************************************************************************************************/
public final class InvalidParameterException extends Exception {

    public InvalidParameterException(String message) {
        super(message);
    }
}