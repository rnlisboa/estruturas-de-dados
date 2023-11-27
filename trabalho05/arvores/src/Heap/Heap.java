package Heap;

import Interfaces.IHeap;
import Node.No;

public class Heap implements IHeap {
    private Object root;
    private int size;
    private No lastNode;
    public Heap(Object r){
        this.root = r;
        No no = new No(r);
        this.lastNode = no;
    }

    @Override
    public No insert(Object o) {
        No lastNode = this.lastNode;
        No newNode = new No(o);

        if(lastNode.equals(root())){ 
            lastNode.setLeftChild(newNode);
            this.lastNode = newNode;
            return newNode;
        }
        
        
        if(nodeIsLeftChild(lastNode)) {
            lastNode.parent().setRightChild(newNode);
            this.lastNode = newNode;
            return newNode;
        }


        No nextNodeToInsert = nextNodeToInsert(lastNode);

        return newNode;
    }

    private No nextNodeToInsert(No no){
        
        while (no.leftChild() != null) {
            if(no.equals(root())) return nextNodeToInsert(no.leftChild());
            
            boolean nodeIsLeftChild = nodeIsLeftChild(lastNode);
            if(nodeIsLeftChild) return nextNodeToInsert(no.leftChild());
            
            return nextNodeToInsert(no.parent());
        }
        return no;
    }

    public boolean nodeIsLeftChild(No no){
        if(no.element() == no.parent().leftChild().element()) return true;
        return false;
    }

    public boolean nodeIsRightChild(No no){
        if(no.element() == no.parent().rightChild().element()) return true;
        return false;
    }

    @Override
    public No root() {
        return this.root();
    }
    @Override
    public No remove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
    @Override
    public void upheap() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'upheap'");
    }
    @Override
    public void swapElements(No a, No b) {
        Object elementA = a.element();
        Object elementB = b.element();
        a.setElement(elementB);
        b.setElement(elementA);
    }
}
