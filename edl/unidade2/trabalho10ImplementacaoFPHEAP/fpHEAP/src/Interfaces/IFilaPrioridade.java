package Interfaces;

import Item.Item;

public interface IFilaPrioridade {
    public void insert(Object key, Object value);
    public Item removeMin();
    public Item min();
    public int size();
    public boolean isEmpty();
}
