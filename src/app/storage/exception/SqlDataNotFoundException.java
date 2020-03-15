package app.storage.exception;

/**
 * @author pollra
 * @description
 * @since 2020.03.15
 **********************************************************************************************************************/
public class SqlDataNotFoundException extends SqlException {
    public SqlDataNotFoundException(String message) {
        super(message);
    }
}
