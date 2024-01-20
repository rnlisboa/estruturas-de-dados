package Interfaces;

import NodeS.Node;

public interface ISequencia {  
    public int size();  
    public boolean isEmpty();
    public Node atRank(int r);
    public int rankOf(Node n);
    public Object first();
    public Object last();
    public Object before(Object p);
    public Object after(Object p);
    public void replaceElement(Object n, Object o);
    public void swapElements(Object n, Object q);
    public Node elementAtRank(int r);
    public Object replaceAtRank(int r, Object o);
    public void insertAtRank(int r, Object o);
    public Object removeAtRank(int r);
    public void insertFirst(Object o);
    public void insertLast(Object o);
    public void insertAfter(Node node, Object o);
    public void insertBefore(Node node, Object o);
    public Object remove(Node o);
}
