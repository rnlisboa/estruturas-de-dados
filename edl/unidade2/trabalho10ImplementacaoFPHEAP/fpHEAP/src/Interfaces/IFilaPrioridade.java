package Interfaces;
import Item.Item;
import NodeFP.Node;

public interface IFilaPrioridade {
    public void insert(Item i);
    public void removeMin();
    public Node min();
    public int size();
    public boolean isEmpty();
}
