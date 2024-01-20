package Teste;

public class No<t extends Object> {
    private t value;
    private No<t> father;
    private No<t> leftChild;
    private No<t> RightChild;
    
    public No(t value) {
        this.value = value;
    } 
    
    public t getValue() {
        return value;
    }

    public void setValue(t value) {
        this.value = value;
    }

    public No<t> getFather() {
        return father;
    }

    public void setFather(No<t> father) {
        this.father = father;
    }

    public No<t> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(No<t> leftChild) {
        this.leftChild = leftChild;
    }

    public No<t> getRightChild() {
        return RightChild;
    }

    public void setRightChild(No<t> rightChild) {
        RightChild = rightChild;
    }
    public boolean Isinternal(){
        return this.leftChild!=null||this.RightChild!=null;
    }

}
