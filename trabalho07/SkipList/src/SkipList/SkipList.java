package SkipList;

import java.util.Random;

import Interface.ISkipList;
import Item.Item;

public class SkipList implements ISkipList {
    private int MAX_ITEM = 100;
    private int MIN_ITEM = -100;
    private int level;
    private Random random;
    
    @Override
    public void insert(Object key, Object value) {
        
    }

    @Override
    public Object search(Object key) {
       return 0;
    }

    @Override
    public void delete(Object key) {
        
    }

    @Override
    public boolean contains(Object key) {
        return true;
    }
    
}
