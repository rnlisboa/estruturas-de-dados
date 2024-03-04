package Deque;

public interface IDeque {
    public Object insertFirst(Object o);
    public Object insertLast(Object o);
    public Object removeFirst();
    public Object removeLast();
    public Object first();
    public Object last();
    public int size();
    public boolean isEmpty();
}
