package main.java.br.com.bellato.exception;

public class KeyTypeNotFoundException extends Exception {

    public KeyTypeNotFoundException(String msg) {
        this(msg, null);
    }

    public KeyTypeNotFoundException(String msg, Throwable e) {
        super(msg, e);
    }
}
