package Avl;

import AbpTree.AbpTree;
import InterfacesAVL.IAVL;
import ItemAVl.Item;
import NodeABP.NodeABP;

public class Avl extends AbpTree implements IAVL {

    public Avl(Item item) {
        super(item);
    }

    public NodeABP insertItem(Item i) {
        NodeABP novo = this.incluir(i);
        int h = this.altura(novo);
        novo.setHeitgh(h);

        if (!isBalanced(novo))
            rebalance(novo);
        return novo;
    }

    public void showIsBalanced(NodeABP n){
        //System.out.println(n.element().toString() + " " + isBalanced(n));
        System.out.println(n.element().toString() + " " + this.altura(n));
        if(n.equals(this.root)){
            return;
        };
        showIsBalanced(n.parent());
    }

    @Override
    public boolean isBalanced(NodeABP node) {
        int bf = this.altura(node.leftChild()) - this.altura(node.rightChild());
        return (-1 <= bf) && (bf <= 1);
    }

    @Override
    public void rebalance(NodeABP node) {
        NodeABP atual = node;
        while (!atual.equals(this.root)) {
            atual = atual.parent();
            if (!isBalanced(atual)) {
                NodeABP xPos = tallerChild(tallerChild(atual));

            }
        }
    }

    @Override
    public NodeABP tallerChild(NodeABP node) {
        if (this.altura(node.leftChild()) >= this.altura(node.rightChild()))
            return node.leftChild();
        else
            return node.rightChild();
    }

}
