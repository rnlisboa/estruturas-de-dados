package Interfaces;

import Node.Node;

public interface IListaEncadeada {
    public Object first();
    public Object last();
    public Object before(Node p);
    public Object after(Node p);
    public void replaceElement(Node n, Object o);
    public void swapElements(Node n, Node q);
    public void insertBefore(Node foundedNode, Object o);
    public void insertAfter(Node foundedNode, Object o);
    public void insertFirst(Object o);
    public void insertLast(Object o);
    public boolean isFirst(Object o);
    public boolean isLast(Object o);
    public boolean isEmpty();
    public Object remove(Node foundedNode);
}
