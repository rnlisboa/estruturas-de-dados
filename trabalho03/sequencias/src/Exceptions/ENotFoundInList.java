package Exceptions;

public class ENotFoundInList extends RuntimeException {
    public ENotFoundInList(String mensagem) {
        super(mensagem);
    }
}
