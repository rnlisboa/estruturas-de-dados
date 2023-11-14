package Exceptions;

public class InvalidNoException extends RuntimeException {
    public InvalidNoException(String mensagem) {
        super(mensagem);
    }
}