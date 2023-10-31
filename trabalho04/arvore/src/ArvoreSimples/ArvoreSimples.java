package ArvoreSimples;

import java.util.ArrayList;
import java.util.Iterator;
import Exceptions.InvalidNoException;
import Interfaces.IArvoreSimples;
import No.No;

public class ArvoreSimples implements IArvoreSimples {
	No raiz;
	int tamanho;
	private int altura = 0;

	public ArvoreSimples(Object o) {
		raiz = new No(null, o);
		tamanho = 1;
	}

	@Override
	public No root() {
		return raiz;
	}

	@Override
	public No parent(No node) {
		return node.parent();
	}

	@Override
	public Iterator<No> children(No node) {
		return node.children();
	}

	@Override
	public boolean isInternal(No node) {
		return node.childrenNumber() > 0;
	}

	@Override
	public boolean isExternal(No node) {
		return node.childrenNumber() == 0;
	}

	@Override
	public boolean isRoot(No node) {
		return node.equals(raiz);
	}

	@Override
	public void addChild(No parent, Object o) {
		No newNode = new No(parent, o);
		parent.addChild(newNode);
		tamanho++;
	}

	@Override
	public Object remove(No node) throws InvalidNoException {
		No parent = node.parent(); // retorna o pai do nó
		if (parent != null || isExternal(node))
			parent.removeChild(node);
		else
			throw new InvalidNoException(null);
		Object o = node.element();
		tamanho--;
		return o;
	}

	@Override
	public void swapElements(No v, No w) {
		Object elementoNo1 = v.element();
		Object elementoNo2 = w.element();
		v.setElement(elementoNo2);
		w.setElement(elementoNo1);
	}

	@Override
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

	@Override
	public int height() {
		getHeigthOf(root().children());
		return altura;
	}

	@Override
	public Iterator<Object> elements() {
		ArrayList<Object> lista = new ArrayList<>();
		addElementInList(raiz, lista);
		return lista.iterator();
	}

	@Override
	public Iterator<No> Nos() {
		ArrayList<No> lista = new ArrayList<>();
		addNodeInList(raiz, lista);
		return lista.iterator();
	}

	@Override
	public int size() {
		return tamanho;
	}

	@Override
	public boolean isEmpty() {
		return root().element() == null;
	}

	@Override
	public Object replace(No v, Object o) {
		Object elementoNo1 = v.element();
		v.setElement(o);
		return elementoNo1;
	}

	private Iterator<No> getHeigthOf(Iterator<No> childrens) {
		while (childrens.hasNext()) {
			No filho = childrens.next();
			int profundidade = profundidade(filho);
			if (profundidade > this.altura)
				this.altura = profundidade;
			return getHeigthOf(filho.children());
		}
		return null;
	}

	private void addElementInList(No node, ArrayList<Object> list) {
		if (node == null)
			return;
		list.add(node.element());
		Iterator<No> filhos = node.children();
		while (filhos.hasNext()) {
			No filho = filhos.next();
			preOrdem(filho);
		}
	}

	private void addNodeInList(No node, ArrayList<No> list) {
		if (node == null)
			return;
		list.add(node);
		Iterator<No> filhos = node.children();
		while (filhos.hasNext()) {
			No filho = filhos.next();
			preOrdem(filho);
		}
	}

	public void preOrdem(No node) {
		if (node == null)
			return;
		System.out.println(node.element());
		Iterator<No> filhos = node.children();
		while (filhos.hasNext()) {
			No filho = filhos.next();
			preOrdem(filho);
		}
	}

}