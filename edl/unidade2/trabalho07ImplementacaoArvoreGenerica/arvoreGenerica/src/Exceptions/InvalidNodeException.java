package Exceptions;

public class InvalidNodeException extends RuntimeException {
    public InvalidNodeException(String mensagem) {
        super(mensagem);
    }
}
