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

            SkipNode currentNode = this.head;
            while (currentNode != this.tail) {
                this.comparador = new Comparador(value, currentNode);
                if (this.comparador.comparer() > 0)
                    break;
                currentNode = currentNode.getPost();
            }

            if (currentNode.getPost() == this.tail) {
                insertAtTail(newNode);
            }

            if (currentNode.getPrev() == this.head) {
                insertAtHead(newNode);
            }
        }
    }

    private void insertAtHead(SkipNode sn) {
        SkipNode firstTail = this.head.getPost();
        this.head.setPost(sn);
        sn.setPost(firstTail);
        sn.setPrev(this.head);
        firstTail.setPrev(sn);
    }

    private void insertAtTail(SkipNode sn) {
        SkipNode lastTail = this.tail.getPrev();
        this.tail.setPrev(sn);
        sn.setPost(this.tail);
        sn.setPrev(lastTail);
        lastTail.setPost(sn);
    }

    private void insertIfEmpty(SkipNode sn) {
        this.head.setPost(sn);
        this.tail.setPrev(sn);
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
        return 0;
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
