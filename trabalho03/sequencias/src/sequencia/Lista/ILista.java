package sequencia.Lista;

public interface ILista {
    public Object first();
    public Object last();
    public Object before(Object p);
    public Object after(Object p);
    public Object replaceElement(int n, Object o);
    public Object swapElements(Object n, Object q);
    public Object insertBefore(Object n, Object o);
    public Object insertAfter(Object n, Object o);
    public Object insertFirst(Object o);
    public Object insertLast(Object o);
    public Object remove(Object n);
}
