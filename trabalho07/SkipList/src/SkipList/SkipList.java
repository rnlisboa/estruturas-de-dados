package SkipList;

import java.util.Random;

import Comparator.Comparator;
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
    private Comparator comparador;
    private SkipNode lastInList;

    public SkipList() {
        SkipNode head = new SkipNode(new Item(this.MIN, null));
        SkipNode tail = new SkipNode(new Item(this.MAX, null));
        this.level = 0;
        this.head = head;
        this.head.setPost(tail);
        this.tail = tail;
        this.tail.setPrev(head);
        this.random = new Random();
    }

    @Override
    public void insert(Object value) {
        int randomLevel = randomLevel();
        for (int i = 0; i <= randomLevel; i++) {
            Item newItem = new Item(i, value);
            SkipNode newNode = new SkipNode(newItem);
            if (isEmpty()) {
                this.insertIfEmpty(newNode);
            }

            // encontrar a posição onde será inserido
            SkipNode currentNode = this.head;
            while (currentNode != this.tail) {
                this.comparador = new Comparator(value, currentNode.getItem().value());
                if (this.comparador.comparer() > 0)
                    break;
                currentNode = currentNode.getPost();
            }

            // inserir no inicio
            if (currentNode.getPost() == this.tail) {
                insertAtTail(newNode);
            }

            // inserir no fim
            else if (currentNode.getPrev() == this.head) {
                insertAtHead(newNode);
            }

            else {
                // next nó
                insertInList(newNode, currentNode);
            }
        }
    }

    private void insertAtHead(SkipNode sn) {
        SkipNode firstTail = this.head.getPost();
        this.head.setPost(sn);
        sn.setPost(firstTail);
        sn.setPrev(this.head);
        firstTail.setPrev(sn);
        this.lastInList = sn;
    }

    private void insertAtTail(SkipNode sn) {
        SkipNode lastTail = this.tail.getPrev();
        this.tail.setPrev(sn);
        sn.setPost(this.tail);
        sn.setPrev(lastTail);
        lastTail.setPost(sn);
        this.lastInList = sn;
    }

    private void insertIfEmpty(SkipNode sn) {
        this.head.setPost(sn);
        this.tail.setPrev(sn);
        this.lastInList = sn;
    }

    private void insertInList(SkipNode newNode, SkipNode currentNode) {
        SkipNode postc = currentNode.getPost();
        newNode.setPost(postc);
        newNode.setPrev(currentNode);
        postc.setPrev(newNode);
        currentNode.setPost(newNode);
        this.lastInList = newNode;
    }

    private int randomLevel() {
        int sorted = this.random.nextInt(2);
        int level = 0;
        while (level < MAX && sorted == 0) {
            level++;
        }
        return level;
    }

    @Override
    public Object search(Object key) {
        SkipNode currNode = this.lastInList;
        while (currNode.getDown() != null) {
            this.comparador = new Comparator(key, currNode.getItem().value());
            if(this.comparador.comparer() == 0 && currNode.getDown() == null) return currNode;
            if(this.comparador.comparer() == 0 && currNode.getDown() != null) currNode = currNode.getDown();

            
            if(this.comparador.comparer() > 0) currNode = currNode.getPost();
            if(this.comparador.comparer() < 0) currNode = currNode.getPrev();
        }
        return 0;
    }

    private SkipNode findNode(SkipNode currNode, Object key){
        this.comparador = new Comparator(key, currNode.getItem().value());
        int comparer = this.comparador.comparer();
        if(comparer == 0 && currNode.getDown() == null) return findNode(currNode, key);
    }

    @Override
    public void delete(Object key) {

    }

    @Override
    public boolean contains(Object key) {
        return true;
    }

    public boolean isEmpty() {
        return this.head.getPost() == this.tail;
    }
}
