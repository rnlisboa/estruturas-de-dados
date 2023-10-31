package ArvoreSimples;

import java.util.Iterator;
import Exceptions.InvalidNoException;
import Interfaces.IArvoreSimples;
import No.No;

public class ArvoreSimples implements IArvoreSimples{
	No raiz;
	int tamanho;
	private int altura = 0;

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

	public void swapElements(No v, No w) {
		Object elementoNo1 = v.element();
		Object elementoNo2 = w.element();
		v.setElement(elementoNo2);
		w.setElement(elementoNo1);
	}

	public int depth(No node) {
		int profundidade = profundidade(node);
		return profundidade;
	}

	private int profundidade(No node) {
		if (node.equals(raiz)) return 0;
		else return 1 + profundidade(node.parent());
	}

	

	@Override
	public int height() {
		/*
		 * recebe filhos do raiz
		 * se raiz.children().length == 0 return 0;
		 * acha o primeiro filho
		 * se filho é externo, vai pro segundo filho
		 * recebe filhos do primeiro filho
		 * acha o primeiro filho
		 */

		this.getHeigthOf(root().children());
		return this.altura;
	}

	

	@Override
	public Iterator<No> elements() {
		
		return null;
	}

	@Override
	public Iterator<No> Nos() {
		// TODO Auto-generated method stub
		return null;
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
			if(profundidade > this.altura) this.altura = profundidade;
			return getHeigthOf(filho.children()); 
				
			}
		
		return null;
	}

	public void preOrdem(No node) {
		if (node == null) {
			return;
		}
		System.out.println(node.element()); 
	
		Iterator<No> filhos = node.children();
		while (filhos.hasNext()) {
			No filho = filhos.next();
			preOrdem(filho);
		}
	}
	
}