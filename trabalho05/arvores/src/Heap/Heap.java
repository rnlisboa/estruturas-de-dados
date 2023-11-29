package Heap;

import Interfaces.IHeap;
import Node.No;

public class Heap implements IHeap {
    private Object root;
    private No lastNode;

    public Heap(Object r) {
        this.root = r;
        No no = new No(r);
        this.lastNode = no;
    }

    @Override
    public No insert(Object o) {
        No lastNode = this.lastNode;
        No newNode = new No(o);

        if (lastNode.equals(root())) {
            No inserted = insertInLeft(lastNode, newNode);
            upheap();
            return inserted;
        }

        if (nodeIsLeftChild(lastNode)) {
            No inserted = insertInRight(lastNode, newNode);
            upheap();
            return inserted;
        }

        No granpa = lastNode.parent().parent();
        if (granpa.equals(this.root) || nodeIsRightChild(granpa)) {
            No nextNodeToInsert = nextNodeToInsertInLeft(lastNode);
            No inserted = insertInLeft(nextNodeToInsert, newNode);
            upheap();
            return inserted;
        } else {
            No nextNodeToInsert = nextNodeToInsertInRight(lastNode);
            No inserted = insertInLeft(nextNodeToInsert, newNode);
            upheap();
            return inserted;
        }

        
    }

    private No insertInLeft(No parent, No newNode) {
        parent.setLeftChild(newNode);
        this.lastNode = newNode;
        return newNode;
    }

    private No insertInRight(No lastNode, No newNode) {
        lastNode.parent().setRightChild(newNode);
        this.lastNode = newNode;
        return newNode;
    }

    private No nextNodeToInsertInLeft(No no) {
        while (no != null) {
            if (no.equals(root()) || nodeIsLeftChild(no)) {
                if (no.leftChild() == null)
                    return no;
                return nextNodeToInsertInLeft(no.leftChild());
            } else {
                return nextNodeToInsertInLeft(no.parent());
            }
        }
        return null;
    }

    private No nextNodeToInsertInRight(No no) {
        while (no != null) {
            if (no.equals(root()) || nodeIsLeftChild(no)) {
                if(no.equals(root())) 
                    return nextNodeToInsertInRight(no.rightChild());
                if(no.leftChild().rightChild().equals(lastNode)) 
                    return nextNodeToInsertInRight(no.rightChild());
                if (no.rightChild() != null && !no.rightChild().equals(lastNode))
                    return nextNodeToInsertInRight(no.parent());
                if(nodeIsRightChild(no.parent())) 
                    return nextNodeToInsertInRight(no.leftChild());
                
                if(no.leftChild() == null) return no;

                return nextNodeToInsertInRight(no.rightChild());
            }
            if (no.rightChild().equals(lastNode))
                return nextNodeToInsertInRight(no.parent());

            if (no.equals(lastNode))
                return nextNodeToInsertInRight(no.parent());

            if (no.leftChild() == null)
                return no;
            if(no.parent().equals(root())) return nextNodeToInsertInRight(no.leftChild());
            
            return nextNodeToInsertInRight(no.rightChild());
        }
        return null;
    }

    public boolean nodeIsLeftChild(No no) {
        if (no.element() == no.parent().leftChild().element())
            return true;
        return false;
    }

    public boolean nodeIsRightChild(No no) {
        if (no.element() == no.parent().rightChild().element())
            return true;
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
        No node = lastNode;
        while((int)node.element() > (int)node.parent().element()){
            node = node.parent();
        }
        swapElements(node, node.parent());
    }

    @Override
    public void swapElements(No a, No b) {
        Object elementA = a.element();
        Object elementB = b.element();
        a.setElement(elementB);
        b.setElement(elementA);
    }
}
