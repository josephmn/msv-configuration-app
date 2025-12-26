package edu.config.msvconfigurationapp.infrastructure.exception.types;

/**
 * Exception internal for execution.
 * @author Joseph Magallanes
 * @since 2025-12-26
 */
public class InternalException extends RuntimeException {

    /**
     * Constructor for InternalException.
     *
     * @param message the detail message
     * @param args    the arguments to format the message
     */
    public InternalException(String message, Object... args) {
        super(String.format(message, args));
    }
}
