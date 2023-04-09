package at.altin.customerapp.exception;

/**
 * @author altin
 * @since 09.04.2023
 * @version 1.0
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String s) {
        super(s);
    }
}
