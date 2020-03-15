package app.storage.exception;

/**
 * @author pollra
 * @description
 * @since 2020.03.15
 **********************************************************************************************************************/
public class SqlExistingKeyException extends SqlException {
    public SqlExistingKeyException(String message) {
        super(message);
    }
}
