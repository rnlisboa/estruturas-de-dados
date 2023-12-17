package Interface;

public interface ISkipList {
    void insert(Object value);
    Object search(Object key);
    void delete(Object key);
    boolean contains(Object key);
}
