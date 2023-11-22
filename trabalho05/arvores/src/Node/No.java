package Node;

import java.util.ArrayList;

import java.util.Iterator;

public class No {
    private No parent;
    private No leftChild;
    private No rightChild;
    private Object element;
    private ArrayList<No> childs = new ArrayList<No>();
    private int height;
    private int pos;

    public int height(){
        return this.height;
    }

    public void setHeitght(int h){
        this.height = h;
    }

    public void setChilds(){
        childs.add(leftChild);
        childs.add(rightChild);
    }

    public Iterator<No> childs(){
        return childs.iterator();
    }

    public No(Object element){
        this.element = element;
    }

    public void setPos(int pos){
        this.pos = pos;
    }

    public int pos(){
        return this.pos;
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