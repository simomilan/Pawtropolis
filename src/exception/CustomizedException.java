package exception;

public class CustomizedException extends Exception{

    /**
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public CustomizedException(String message) {
        super(message);
    }
}
