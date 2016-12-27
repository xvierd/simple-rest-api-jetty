package org.example.exceptions;

/**
 * @author Xavier Guti&#233;rrez
 *         27/12/16.
 */
public class ExampleException extends Exception {
    public ExampleException(String message) {
        super(message);
    }

    public ExampleException(String message, Throwable cause) {
        super(message, cause);
    }
}