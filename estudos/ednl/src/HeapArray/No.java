package HeapArray;

public class No {
    private No parent;
    private No leftChild;
    private No rightChild;
    private Object element;
  
    public No(Object element){
        this.element = element;
    }

    public No parent(){
        return this.parent;
    }

    public void setParent(No no){
        this.parent = no;
    }

    public No leftChild(){
        return this.leftChild;
    }

    public No rightChild(){
        return this.rightChild;
    }

    public Object element(){
        return this.element;
    }

    public void setElement(Object key){
        this.element = key;
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

    public boolean hasParent(){
        return this.parent != null;
    }

    public boolean isInternal(){
        if(this.hasLeftChild() == true || this.hasRightChild() == true)
            return true;
        return false;
    }

    public boolean isExternal(){
        return !isInternal();
    }
}
