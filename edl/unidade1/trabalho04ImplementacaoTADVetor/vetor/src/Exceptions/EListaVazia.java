package Exceptions;

public class EListaVazia extends RuntimeException {
    public EListaVazia(String mensagem) {
        super(mensagem);
    }
}
