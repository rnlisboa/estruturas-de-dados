package Interfaces;

import Node.No;

public interface IHeap {
    public No insert(Object o);
    public No root();
    public No remove();
    public void upheap();
    public void swapElements(No a, No b);
}
