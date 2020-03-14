package app.todo.exception;

/**
 * @since       2020.03.14
 * @author      pollra
 * @description
 **********************************************************************************************************************/
public final class DataNotFoundException extends Exception {

    public DataNotFoundException(String message) {
        super(message);
    }
}