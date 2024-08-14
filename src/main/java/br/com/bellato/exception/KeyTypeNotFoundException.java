package main.java.br.com.bellato.exception;

public class KeyTypeNotFoundException extends Exception {

    private static final long serialVersionUID = -2338126872552424111L;

    public KeyTypeNotFoundException(String msg) {
        this(msg, null);
    }

    public KeyTypeNotFoundException(String msg, Throwable e) {
        super(msg, e);
    }
}
