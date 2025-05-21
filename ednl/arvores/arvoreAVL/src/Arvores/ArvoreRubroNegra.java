package Arvores;

import Cores.Cores;
import Node.No;

public class ArvoreRubroNegra extends ArvBinPesquisa {
    public No insert(Object key) {
        No v = this.incluir(key);
        this.colorir(v);
        this.mostrarRN();
        System.out.println("--------------------");
        return v;
    }

    private void colorir(No v) {
        if (v.equals(this.getRaiz())) {
            v.setCor(Cores.NEGRO);
            return;
        }
        v.setCor(Cores.RUBRO);

        // casos
        No w = v.parent(); // pai do novo nó
        
        //caso 1
        if (w.getCor().equals(Cores.NEGRO)) {
            return;
        }
        
        // caso 2
        this.insercaoCasoDois(v);

        // caso 3
        this.insercaoCasoTres(v);
    }


    private void insercaoCasoDois(No v) {
        if (v.equals(this.getRaiz())) {
            if (v.getCor().equals(Cores.RUBRO)) {
                v.setCor(Cores.NEGRO);
                return;
            }

            return;
        }

        No w = v.parent(); // pai do novo nó


        No t = w.parent(); // avô do novo nó

        No u = t.rightChild().equals(w) ? t.leftChild() : t.rightChild(); // tio do novo nó
        
        if (u.getCor().equals(Cores.RUBRO)) {
            t.setCor(Cores.RUBRO);
            u.setCor(Cores.NEGRO);
            w.setCor(Cores.NEGRO);
        }

        if (t.getCor().equals(Cores.RUBRO)) {
            v = t;
            insercaoCasoDois(v);
        }
    }


    private void insercaoCasoTres(No v) {
        No w = v.parent(); // pai do novo nó
        No t = w.parent(); // avô do novo nó
        No u = t.rightChild().equals(w) ? t.leftChild() : t.rightChild(); // tio do nó
        
        if(w.getCor().equals(Cores.RUBRO) && u.getCor().equals(Cores.NEGRO)) {

            // caso 3a)
            if(w.leftChild().equals(v) && t.leftChild().equals(w)) {
                this.rotacaoEsquerdaSimples(w);
            }
            
            // caso 3b)
            if(w.rightChild().equals(v) && t.rightChild().equals(w)) {
                this.rotacaoDireitaSimples(w);
            }

            // caso 3c)
            if(w.leftChild().equals(v) && t.rightChild().equals(w)) {
                this.rotacaoEsquerdaDupla(w);
            }

            // caso 3d)
            if(w.rightChild().equals(v) && t.leftChild().equals(w)) {
                this.rotacaoDireitaDupla(w);
            }
        }
    }


    private void rotacaoDireitaSimples (No w) {
        No t = w.parent();
        w.setCor(Cores.NEGRO);

        w.setRightChild(t);
        w.setParent(t.parent());
        t.setParent(w);
        t.setCor(Cores.RUBRO);
    }

    private void rotacaoEsquerdaSimples (No w) {
        No t = w.parent();
        w.setCor(Cores.NEGRO);
        
        w.setLeftChild(t);
        w.setParent(t.parent());
        t.setParent(w);
        t.setCor(Cores.RUBRO);
    }

    private void rotacaoDireitaDupla (No w) {
        No v = w.rightChild();
        No t = w.parent();

        // passo 1
        w.setRightChild(v.leftChild());
        w.setParent(v);
        v.setLeftChild(w);

        // passo 2
        v.setParent(t.parent());
        if (t.parent().rightChild().equals(t)) {
            t.parent().setRightChild(v);
        } else {
            t.parent().setLeftChild(v);
        }

        v.setRightChild(t);
        t.setParent(v);
        t.setLeftChild(v.rightChild());

        v.setCor(Cores.NEGRO);
        t.setCor(Cores.RUBRO);
    }

    private void rotacaoEsquerdaDupla (No w) {
        No v = w.rightChild();
        No t = w.parent();

        // passo 1
        w.setLeftChild(v.rightChild());
        w.setParent(v);
        v.setRightChild(w);

        // passo 2
        v.setParent(t.parent());
        if (t.parent().leftChild().equals(t)) {
            t.parent().setLeftChild(v);
        } else {
            t.parent().setRightChild(v);
        }

        v.setLeftChild(t);
        t.setParent(v);
        t.setRightChild(v.leftChild());

        v.setCor(Cores.NEGRO);
        t.setCor(Cores.RUBRO);
    }
}
