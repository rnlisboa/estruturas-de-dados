package Node;

public class No {
    private No parent;
    private No leftChild;
    private No rightChild;
    private Object element;
    private int fb = 0;

    public No(Object element) {
        this.element = element;
    }

    public No parent() {
        return this.parent;
    }

    public void setParent(No no) {
        this.parent = no;
    }

    public No leftChild() {
        return this.leftChild;
    }

    public No rightChild() {
        return this.rightChild;
    }

    public Object element() {
        return this.element;
    }

    public void setElement(Object key) {
        this.element = key;
    }

    public void setLeftChild(No no) {
        this.leftChild = no;
    }

    public void setRightChild(No no) {
        this.rightChild = no;
    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    public boolean hasRightChild() {
        return this.rightChild != null;
    }

    public boolean hasParent() {
        return this.parent != null;
    }

    public void setFb(int v) {
        this.fb = this.fb + v;
    }

    public void atualizaFb(int v) {
        this.fb = v;
    }

    public int getFb() {
        return fb;
    }
}