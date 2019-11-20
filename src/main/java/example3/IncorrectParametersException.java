package example3;

public class IncorrectParametersException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new instance of <code>IncorrectParameters</code> without detail message.
     */
    public IncorrectParametersException() {
        this("IncorrectParameters");
    }

    /**
     * Constructs an instance of <code>IncorrectParameters</code> with the specified detail message.
     * @param msg the detail message.
     */
    public IncorrectParametersException(String msg) {
        super(msg);
    }
}

