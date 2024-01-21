package NodeHeap;

import Item.Item;

public class Node {
    private Item element;
    private Node parent;
    private Node rightChild;
    private Node leftChild;

    public Node(Item item){
        this.element = item;
    }

    public Item element() {
        return element;
    }

    public void setValue(Item value) {
        this.element = value;
    }

    public Node parent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node rightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node leftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public boolean hasLeftChild(){
        return this.leftChild != null;
    }

    public boolean hasRightChild(){
        return this.rightChild != null;
    }
}
