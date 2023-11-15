package Node;

public class No {
    private No parent;
    private No leftChild;
    private No rightChild;
    private int element;

    public No(int element){
        this.element = element;
    }

    public No parent(){
        return this.parent;
    }

    public No leftChild(){
        return this.leftChild;
    }

    public No rightChild(){
        return this.rightChild;
    }

    public int element(){
        return this.element;
    }

    public void setLeftChild(No no){
        this.leftChild = no;
    }

    public void setRightChild(No no){
        this.rightChild = no;
    }

    public boolean hasLeftChild(){
        return this.leftChild != null;
    }

    public boolean hasRightChild(){
        return this.rightChild != null;
    }

    public boolean isInternal(){
        if(this.hasLeftChild() == false || this.hasRightChild() == false)
            return false;
        else return true;
    }

    public boolean isExternal(){
        return !isExternal();
    }
}