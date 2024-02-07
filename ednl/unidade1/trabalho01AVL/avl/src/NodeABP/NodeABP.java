package NodeABP;
import ItemAVl.Item;

public class NodeABP {
    private NodeABP parent;
    private NodeABP leftChild;
    private NodeABP rightChild;
    private Item element;
    private int height;

    public NodeABP(Item element){
        this.element = element;
    }

    public NodeABP parent(){
        return this.parent;
    }

    public void setParent(NodeABP Node){
        this.parent = Node;
    }

    public NodeABP leftChild(){
        return this.leftChild;
    }

    public NodeABP rightChild(){
        return this.rightChild;
    }

    public Item element(){
        return this.element;
    }

    public void setElement(Item e){
        this.element = e;
    }

    public void setLeftChild(NodeABP Node){
        this.leftChild = Node;
    }

    public void setRightChild(NodeABP Node){
        this.rightChild = Node;
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

    public void setHeitgh(int h){
        this.height = h;
    }

    public int height(){
        return this.height;
    }

}
