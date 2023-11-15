package Interfaces;

import java.util.Iterator;

import Comparador.Comparador;
import Node.No;

public interface IArvoreBinariaPesquisa {
    void setComparator(Comparador c);

	Comparador getComparador();

	No pesquisar(int key, No no);

	No incluir(int key);

	int remover(int key);

	No getRaiz();

	void setRaiz(No p);

	void emOrdem(No no);

	void preOrdem(No no);

	void posOrdem(No no);

	int altura(No no);

	int profundidade(No no);

	void mostrar();

	Iterator Nos();

	Iterator elements();

	int size();

	boolean isEmpty();
}
