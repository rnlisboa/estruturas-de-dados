package HashTable;

public interface IHashTable {

    int hash(Object k);

    void insere(Object k, Object v);

    Object busca(Object x);

    Object remove(Object o);

}
