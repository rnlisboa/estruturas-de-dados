package SkipNode;

import Item.Item;

public class SkipNode {
    private Item Item;
    private SkipNode prev;
    private SkipNode post;
    private SkipNode up;
    private SkipNode down;

    public SkipNode(Item item){
        this.Item = item;
    }

    public Item getItem(){
        return this.Item;
    }

    public SkipNode getPrev() {
        return this.prev;
    }

    public void setPrev(SkipNode sn){
        this.prev = sn;
    }

    public SkipNode getPost() {
        return this.post;
    }

    public void setPost(SkipNode sn){
        this.post = sn;
    }

    public SkipNode getUp() {
        return this.up;
    }

    public void setUp(SkipNode sn){
        this.up = sn;
    }

    public SkipNode getDown() {
        return this.down;
    }

    public void setDown(SkipNode sn){
        this.down = sn;
    }

}
