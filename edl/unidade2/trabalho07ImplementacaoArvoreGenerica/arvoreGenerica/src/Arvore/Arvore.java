package Arvore;

import java.util.ArrayList;
import java.util.Iterator;
import Exceptions.InvalidNodeException;
import TNode.Node;

public class Arvore {
	Node raiz;
	int tamanho;

	public Arvore(Object o) {
		raiz = new Node(null, o);
		tamanho = 1;
	}

	public Node root() {
		return raiz;
	}

	public Node parent(Node node) {
		return node.parent();
	}

	public Iterator<Node> children(Node node) {
		return node.children();
	}

	public boolean isInternal(Node node) {
		return node.childrenNumber() > 0;
	}

	public boolean isExternal(Node node) {
		return node.childrenNumber() == 0;
	}

	public boolean isRoot(Node node) {
		return node.equals(raiz);
	}

	public void addChild(Node parent, Object o) {
		Node newNodede = new Node(parent, o);
		parent.addChild(newNodede);
		tamanho++;
	}

	public Object remove(Node node) throws InvalidNodeException {
		Node parent = node.parent(); // retorna o pai do nó
		if (parent != null || isExternal(node))
			parent.removeChild(node);
		else
			throw new InvalidNodeException(null);
		Object o = node.element();
		tamanho--;
		return o;
	}

	public void swapElements(Node v, Node w) {
		Object elementoNode1 = v.element();
		Object elementoNode2 = w.element();
		v.setElement(elementoNode2);
		w.setElement(elementoNode1);
	}

	public int depth(Node node) {
		int profundidade = profundidade(node);
		return profundidade;
	}

	private int profundidade(Node node) {
		if (node.equals(raiz))
			return 0;
		else
			return 1 + profundidade(node.parent());
	}

	public int height() {
		int height = getHeight(root());
		return height;
	}

	private int getHeight(Node node) {
		if (isExternal(node)) {
			return 0;
		} else {
			int h = 0;
			Iterator<Node> childrens = node.children();
			while (childrens.hasNext()) {
				h = Math.max(h, getHeight(childrens.next()));
			}
			return h + 1;
		}
	}

	public Iterator<Object> elements() {
		ArrayList<Object> lista = new ArrayList<>();
		addElementInList(raiz, lista);
		return lista.iterator();
	}

	private void addElementInList(Node node, ArrayList<Object> list) {
		if (node == null)
			return;
		list.add(node.element());
		Iterator<Node> filhos = node.children();
		while (filhos.hasNext()) {
			Node filho = filhos.next();
			preOrdem(filho);
		}
	}

	public Iterator<Node> Nodes() {
		ArrayList<Node> lista = new ArrayList<>();
		addNodedeInList(raiz, lista);
		return lista.iterator();
	}

	public int size() {
		return tamanho;
	}

	public boolean isEmpty() {
		return root().element() == null;
	}

	public Object replace(Node v, Object o) {
		Object elementoNode1 = v.element();
		v.setElement(o);
		return elementoNode1;
	}

	private void addNodedeInList(Node node, ArrayList<Node> list) {
		if (node == null)
			return;
		list.add(node);
		Iterator<Node> filhos = node.children();
		while (filhos.hasNext()) {
			Node filho = filhos.next();
			preOrdem(filho);
		}
	}

	public void preOrdem(Node node) {
		if (node == null)
			return;
		System.out.println(node.element());
		Iterator<Node> filhos = node.children();
		while (filhos.hasNext()) {
			Node filho = filhos.next();
			preOrdem(filho);
		}
	}

}
