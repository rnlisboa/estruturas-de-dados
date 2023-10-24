package ArvoreSimples;

import java.util.Iterator;
import Exceptions.InvalidNoException;
import No.No;

public class ArvoreSimples {
	No raiz;
	int tamanho;

	public ArvoreSimples(Object o) {
		raiz = new No(null, o);
		tamanho = 1;
	}

	public No root() {
		return raiz;
	}

	public No parent(No node) {
		return node.parent();
	}

	public Iterator<No> children(No node) {
		return node.children();
	}

	public boolean isInternal(No node) {
		return node.childrenNumber() > 0;
	}

	public boolean isExternal(No node) {
		return node.childrenNumber() == 0;
	}

	public boolean isRoot(No node) {
		return node.equals(raiz);
	}

	public void addChild(No parent, Object o) {
		No newNode = new No(parent, o);
		parent.addChild(newNode);
		tamanho++;
	}

	public Object remote(No node) throws InvalidNoException {
		No parent = node.parent(); // retorna o pai do nó
		if (parent != null || isExternal(node))
			parent.removeChild(node);
		else
			throw new InvalidNoException(null);
		Object o = node.element();
		tamanho--;
		return o;
	}

	public void swapElements(No v, No w) {

	}

	public int depth(No node) {
		int profundidade = profundidade(node);
		return profundidade;
	}

	private int profundidade(No node) {
		if (node.equals(raiz))
			return 0;
		else
			return 1 + profundidade(node.parent());
	}

	public int altura() {
		No node = root();
		while (this.isInternal(node)) {

		}
		int altura = 0;
		return altura;
	}

	public No findNode(No node) {
		if (node.parent().equals(root())) {
			No root = root();
			Iterator<No> rootChildrens = root.children();
			while (rootChildrens.hasNext()) {
				No filho = rootChildrens.next();
				if (filho.equals(node))
					return node;
			}
		} else {
			
		}

		return findNode(node.parent());
	}
}