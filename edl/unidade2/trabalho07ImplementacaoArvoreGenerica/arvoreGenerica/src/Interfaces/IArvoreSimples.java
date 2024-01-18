package Interfaces;
import java.util.Iterator;
import Exceptions.InvalidNodeException;
import TNode.Node;

public interface IArvoreSimples {
    Node root();
    Node parent(Node v);
    Iterator<Node> children(Node v);
    boolean isInternal(Node v);
    boolean isExternal(Node v);
    boolean isRoot(Node v);
    void addChild(Node v, Object o);
    Object remove(Node v) throws InvalidNodeException;
    void swapElements(Node v, Node w);
    int depth(Node v);
    int height();
    Iterator<Object> elements();
    Iterator<Node> Nodes();
    int size();
    boolean isEmpty();
    Object replace(Node v, Object o);
}
