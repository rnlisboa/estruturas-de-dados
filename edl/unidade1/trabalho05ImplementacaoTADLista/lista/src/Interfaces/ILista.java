package Interfaces;

public interface ILista {
    public Object first();
    public Object last();
    public Object before(Object p);
    public Object after(Object p);
    public void replaceElement(Object n, Object o);
    public void swapElements(Object n, Object q);
    public void insertBefore(Object n, Object o);
    public void insertAfter(Object n, Object o);
    public void insertFirst(Object o);
    public void insertLast(Object o);
    public Object remove(Object n);
}
