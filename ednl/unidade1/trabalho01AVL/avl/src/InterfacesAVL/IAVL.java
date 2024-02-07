package InterfacesAVL;

import NodeABP.NodeABP;

public interface IAVL {
    public boolean isBalanced(NodeABP node);
    public void rebalance(NodeABP node);
    public NodeABP tallerChild(NodeABP node);
}
