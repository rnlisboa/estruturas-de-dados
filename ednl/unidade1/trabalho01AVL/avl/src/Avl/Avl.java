package Avl;

import AbpTree.AbpTree;
import InterfacesAVL.IAVL;
import ItemAVl.Item;
import NodeABP.NodeABP;

public class Avl extends AbpTree implements IAVL {

    public Avl(Item item) {
        super(item);
    }

    public NodeABP insertItem(Item i){
        NodeABP novo = this.incluir(i);
        int h = this.altura(novo);
        novo.setHeitgh(h);

        if(!isBalanced(novo)) rebalance(novo);
        return novo;
    }
    
    @Override
    public boolean isBalanced(NodeABP node) {
        return false;
    }

    @Override
    public void rebalance(NodeABP node) {
 
    }

    @Override
    public NodeABP tallerChild(NodeABP node) {
        NodeABP n = new NodeABP(null);
        return n;
    }
    
}
