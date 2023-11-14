package No;

public class No {
    private No parent;
    private No leftChild;
    private No righChild;
    private Object element;

    public No(Object element){
        this.element = element;
    }

    public No parent(){
        return this.parent;
    }

    public No leftChild(){
        return this.leftChild;
    }

    public No righChild(){
        return this.righChild;
    }

    public Object element(){
        return this.element;
    }

    public void setLeftChild(No no){
        this.leftChild = no;
    }

    public void setRightChild(No no){
        this.righChild = no;
    }

    public boolean hasLeftChild(){
        return this.leftChild == null;
    }

    public boolean hasRightChild(){
        return this.righChild == null;
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
