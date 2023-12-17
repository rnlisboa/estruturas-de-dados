package SkipList;

import java.util.Random;

import Comparador.Comparador;
import Interface.ISkipList;
import Item.Item;
import SkipNode.SkipNode;

public class SkipList implements ISkipList {
    private int MAX = 100;
    private int MIN = -100;
    private int level;
    private SkipNode head;
    private SkipNode tail;
    private Random random;
    private Comparador comparador;

    public SkipList(){
        SkipNode head = new SkipNode(new Item(this.MIN, null));
        SkipNode tail = new SkipNode(new Item(this.MAX, null));
        this.level = 0;
        this.head = head;
        this.tail = tail;
        this.random = new Random();
    }

    @Override
    public void insert(Object value) {
        int randomLevel = randomLevel();
        for(int i = 0; i <= randomLevel; i++){
            Item newItem = new Item(i, value);
        }
    }

    private void insertAtHead(Item item){

    }

    private void insertAtTail(Item item){

    }

    private void insertIfEmpty(Item item){

    }

    private int randomLevel(){
        int sorted = this.random.nextInt(2);
        int level = 0;
        while (level < MAX && sorted == 0) {
            level++;
        }
        return level;
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
