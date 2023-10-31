package Interfaces;
import java.util.Iterator;
import Exceptions.InvalidNoException;
import No.No;

public interface IArvoreSimples {
    No root();
    No parent(No v);
    Iterator<No> children(No v);
    boolean isInternal(No v);
    boolean isExternal(No v);
    boolean isRoot(No v);
    void addChild(No v, Object o);
    Object remove(No v) throws InvalidNoException;
    void swapElements(No v, No w);
    int depth(No v);
    int height();
    Iterator<Object> elements();
    Iterator<No> Nos();
    int size();
    boolean isEmpty();
    Object replace(No v, Object o);
}
