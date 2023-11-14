package ArvoreBinariaPesquisa;

import java.util.Iterator;

import Comparador.Comparador;
import Interfaces.IArvoreBinariaPesquisa;
import No.No;

public class ArvoreBinariaPesquisa implements IArvoreBinariaPesquisa {
    private No root;
    private int hight;
    private int size;
    private Comparador comparador;

    public ArvoreBinariaPesquisa(No root){
        this.root = root;
        this.hight = 0;
        this.size = 0;
    }

    @Override
    public void setComparator(Comparador c) {
        this.comparador = c;
    }

    @Override
    public Comparador getComparador() {
        return this.comparador;
    }

    @Override
    public No pesquisar(No no, Object key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pesquisar'");
    }

    @Override
    public No incluir(Object key) {
        No no = new No(key);
        // percorrer a arvore e seus elementos

        return no;
    }

    @Override
    public Object remover(Object key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public No getRaiz() {
        return this.root;
    }

    @Override
    public void setRaiz(No p) {
        this.root = p;
    }

    @Override
    public void emOrdem(No no) {
        if(no.isInternal())
            emOrdem(no.leftChild());
        System.out.println(no.element());
        if(no.isInternal()){
            emOrdem(no.righChild());
        }
    }

    @Override
    public void preOrdem(No no) {
    
    }
            

    @Override
    public void posOrdem(No no) {
        
    }

    @Override
    public int altura(No no) {
        return profundidade(no);
    }

    @Override
    public int profundidade(No no) {
        if(no.equals(this.root)) return 0;
        return 1 + profundidade(no);
    }

    @Override
    public void mostrar() {
        
    }

    @Override
    public Iterator Nos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Nos'");
    }

    @Override
    public Iterator elements() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'elements'");
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
}
