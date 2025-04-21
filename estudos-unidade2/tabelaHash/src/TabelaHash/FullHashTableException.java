package TabelaHash;

public class FullHashTableException extends RuntimeException{
    public FullHashTableException(){
        super("Hashtable has no available index.");
    }
}
