package Heap;

import Interfaces.IHeap;
import Node.No;

public class Heap {
    private No root;
    private No lastNode;
    private int indice = 0;

    public Heap(Object r) {
        this.root = new No(r);
        indice++;
        this.lastNode = this.root;
    }

    public No insert(No inserted, No lastNode) {
        if (lastNode != root && lastNode.parent().rightChild() != null
                && lastNode.parent() != lastNode.parent().parent().rightChild()) {
            No atual = lastNode;
            while (atual != null) {
                if (atual == root) {
                    atual = atual.rightChild();
                    lastNode = atual;
                } else if (atual == atual.parent().rightChild()) {
                    atual = atual.leftChild();
                    lastNode = atual;
                } else if (atual.rightChild().leftChild() == null) {
                    lastNode = atual;
                    atual = atual.leftChild();
                } else {
                    atual = atual.parent();
                    lastNode = atual;
                }
            }
            
        } else if (lastNode != root && lastNode.parent().rightChild() != null
                && lastNode.parent() == lastNode.parent().parent().rightChild()) {
            No atual = lastNode;
            while (atual != null) {
                if (atual == root)
                    atual = atual.leftChild();
                else if (atual == atual.parent().leftChild())
                    atual = atual.leftChild();
                else
                    atual = atual.parent();
            }
            lastNode = atual;
        }

        if (lastNode.leftChild() == null) {
            lastNode.setLeftChild(inserted);
            inserted.setParent(lastNode);
        } else if (lastNode.rightChild() == null) {
            lastNode.setRightChild(inserted);
            inserted.setParent(lastNode);
            this.lastNode = lastNode.leftChild();
        }

        return inserted;
    }

    public No root() {
        return this.root();
    }

    public No remove() {
        // TODO
        return null;
    }

    public void upheap() {
        No node = lastNode;
        while ((int) node.element() > (int) node.parent().element()) {
            node = node.parent();
        }
        swapElements(node, node.parent());
    }

    public void swapElements(No a, No b) {
        Object elementA = a.element();
        Object elementB = b.element();
        a.setElement(elementB);
        b.setElement(elementA);
    }
}
