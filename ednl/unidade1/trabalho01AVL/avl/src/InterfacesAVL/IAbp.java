package InterfacesAVL;

import NodeABP.NodeABP;
import java.util.Iterator;

import ItemAVl.Item;

public interface IAbp{


	NodeABP pesquisar(NodeABP node, Object key);

	NodeABP incluir(Item i);

	Object remover(Object key);

	NodeABP getRaiz();

	void emOrdem(NodeABP node);

	void preOrdem(NodeABP node);

	void posOrdem(NodeABP node);

	int altura(NodeABP NodeABP);

	int profundidade(NodeABP node);

	void mostrar();

	Iterator<NodeABP> nodeABPs();

	Iterator<Object> elements();

	int size();

	boolean isEmpty();

	boolean isInternal(NodeABP node);

	boolean isExternal(NodeABP node);

}

