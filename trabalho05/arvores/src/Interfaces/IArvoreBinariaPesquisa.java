package Interfaces;

import java.util.Iterator;

import Comparador.Comparador;
import Node.No;

public interface IArvoreBinariaPesquisa {
    void setComparator(Comparador c);

	Comparador getComparador();

	No pesquisar(No no, Object key);

	No incluir(Object key);

	Object remover(Object key);

	No getRaiz();

	void setRaiz(No p);

	void emOrdem(No no);

	void preOrdem(No no);

	void posOrdem(No no);

	int altura(No no);

	int profundidade(No no);

	void mostrar();

	Iterator<No> Nos();

	Iterator<Object> elements();

	int size();

	boolean isEmpty();
}
