package Arvores;

import Cores.Cores;
import Node.No;

public class ArvoreRubroNegra extends ArvBinPesquisa {
    public No insert(Object key) {
        No v = this.incluir(key);
        this.colorir(v);
        return v;
    }

    public No remove(Object key) {
        No v = this.pesquisar(this.getRaiz(), key);
        No x = this.getSucessor(v);
        this.verificarCasoRemocao(v, x);
        System.out.println("Cor do sucessor: " + x.getCor());
        System.out.println("Valor do sucessor: " + x.element());
        return x;
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
        

        No t = w.parent(); // avô do novo nó
        No u = new No(null);
        u.setCor(Cores.NEGRO);
        if(t.hasRightChild()){
            u = t.rightChild().equals(w) ? t.leftChild() : t.rightChild(); // tio do novo nó
        }
        
        if (u == null) {
            u = new No(null);
            u.setCor(Cores.NEGRO);
        }
        // caso 2 
        if (w.getCor().equals(Cores.RUBRO) && u.getCor().equals(Cores.RUBRO) && t.getCor().equals(Cores.NEGRO)) {
            this.insercaoCasoDois(v, w, u, t);
        }

        // caso 3
        if (w.getCor().equals(Cores.RUBRO) && u.getCor().equals(Cores.NEGRO)) {
            this.insercaoCasoTres(v, w, u, t);
        }
    }


    private void insercaoCasoDois(No v, No w, No u, No t) {
        if (v.equals(this.getRaiz())) {
            if (v.getCor().equals(Cores.RUBRO)) {
                v.setCor(Cores.NEGRO);
                return;
            }

            return;
        }
        
        if(!t.equals(this.getRaiz())) {
            t.setCor(Cores.RUBRO);
        }
        
        u.setCor(Cores.NEGRO);
        w.setCor(Cores.NEGRO);
        if (t.parent() != null && t.parent().getCor().equals(Cores.RUBRO)) {
            v = t;
       
            this.colorir(v);
        }
    }


    private void insercaoCasoTres(No v, No w, No u, No t) {    
        // caso 3a)
        if (w.hasLeftChild() && t.hasLeftChild()) {
            if(w.leftChild().equals(v) && t.leftChild().equals(w)) {
                this.rotacaoDireitaSimples(w);
            }
        }
        
        
        // caso 3b)
        if (w.hasRightChild() && t.hasRightChild()) {
            if(w.rightChild().equals(v) && t.rightChild().equals(w)) {
                this.rotacaoEsquerdaSimples(w);
            }
        }
        
            
        // caso 3c)
        if (w.hasLeftChild() && t.hasRightChild()) {
            if(w.leftChild().equals(v) && t.rightChild().equals(w)) {
                this.rotacaoEsquerdaDupla(w);
            }
        }
        
                
        // caso 3d)
        if (w.hasRightChild() && t.hasLeftChild()) {
            if(w.rightChild().equals(v) && t.leftChild().equals(w)) {
                this.rotacaoDireitaDupla(w);
            }
        }
        
    }


    private void rotacaoDireitaSimples (No w) {
        No t = w.parent();
        // Atualiza o filho esquerdo de t para ser o filho direito de w
        t.setLeftChild(w.rightChild());
        if (w.hasRightChild()) {
            w.rightChild().setParent(t);
        }

        // Atualiza o pai de w para ser o pai de t
        w.setParent(t.parent());
        if (t.parent() == null) {
            // t era a raiz
            this.setRaiz(w);
        } else if (t.parent().leftChild() == t) {
            t.parent().setLeftChild(w);
        } else {
            t.parent().setRightChild(w);
        }

        w.setRightChild(t);
        t.setParent(w);

        t.setCor(Cores.RUBRO);
        w.setCor(Cores.NEGRO);
    }

    private void rotacaoEsquerdaSimples (No w) {
        No t = w.parent();
        if (t.equals(this.getRaiz())) {
            this.setRaiz(w);
        } else {
            w.setParent(t.parent());
            if (t.parent().leftChild().equals(t)) {
                t.parent().setLeftChild(w);
            } else {
                t.parent().setRightChild(w);
            }
        }

        t.setRightChild(w.leftChild());
        if (w.hasLeftChild()) {
            w.leftChild().setParent(t);
        }
        t.setParent(w);
        t.setCor(Cores.RUBRO);
        w.setLeftChild(t);

        w.setCor(Cores.NEGRO);
        
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

    private void verificarCasoRemocao(No v, No x) {
        No pai = x.parent();
        No w = null;

        if (pai.leftChild() != null && pai.leftChild().equals(x)) {
            w = pai.rightChild();
        } else {
            w = pai.leftChild();
        }

        // Situação 1
        if (Cores.RUBRO.equals(v.getCor()) && Cores.RUBRO.equals(x.getCor())) {
            return;
        }

        // Situação 2
        if (Cores.NEGRO.equals(v.getCor()) && Cores.RUBRO.equals(x.getCor())) {
            x.setCor(Cores.NEGRO);
            return;
        }

        // Situação 3
        if (Cores.NEGRO.equals(v.getCor()) && Cores.NEGRO.equals(x.getCor())) {
            this.casosTres(v, x, w);
        }

        // Situação 4
        if (Cores.RUBRO.equals(v.getCor()) && Cores.NEGRO.equals(x.getCor())) {
            x.setCor(Cores.RUBRO);
            this.casosTres(v, x, w);
        }

    }

    private void casosTres(No v, No x, No w) {
        No pai = x.parent();

        // caso 1: irmão rubro e pai negro
        if (Cores.RUBRO.equals(w.getCor()) && Cores.NEGRO.equals(pai.getCor())) {
            // • Faça uma rotação simples esquerda
            // • Pinte w de negro
            // • Pinte pai de x de rubro
            this.rotacaoEsquerdaSimples(x);
            w.setCor(Cores.NEGRO);
            pai.setCor(Cores.RUBRO);
        }

        // caso 2a: irmão é negro com filhos negros e pai negro
        if (Cores.NEGRO.equals(w.getCor()) &&
            (w.leftChild() == null || Cores.NEGRO.equals(w.leftChild().getCor())) &&
            (w.rightChild() == null || Cores.NEGRO.equals(w.rightChild().getCor())) &&
            Cores.NEGRO.equals(pai.getCor())) {
            // • Pinte o irmão w de rubro
            w.setCor(Cores.RUBRO);
        }

        // caso 2b: irmão é negro com filhos negros e pai é rubro
        if (Cores.NEGRO.equals(w.getCor()) &&
            (w.leftChild() == null || Cores.NEGRO.equals(w.leftChild().getCor())) &&
            (w.rightChild() == null || Cores.NEGRO.equals(w.rightChild().getCor())) &&
            Cores.RUBRO.equals(pai.getCor())) {
            // Pinte o irmão w de rubro e o pai de x de negro
            w.setCor(Cores.RUBRO);
            pai.setCor(Cores.NEGRO);
        }

        // caso 3: irmão é negro, pai de qualquer cor, filho esquerdo do irmão é rubro e o direito é negro
        if (Cores.NEGRO.equals(w.getCor()) &&
            w.leftChild() != null && Cores.RUBRO.equals(w.leftChild().getCor()) &&
            (w.rightChild() == null || Cores.NEGRO.equals(w.rightChild().getCor()))) {
            // • Rotação simples direita em w
            // • Trocar as cores de w com seu filho esquerdo
            this.rotacaoDireitaSimples(w);
            String corW = w.getCor();
            w.setCor(w.leftChild().getCor());
            w.leftChild().setCor(corW);
        }

        // caso 4: irmão é negro, pai de qualquer cor, filho esquerdo do irmão de qualquer cor e o direito rubro
        if (Cores.NEGRO.equals(w.getCor()) &&
            w.rightChild() != null && Cores.RUBRO.equals(w.rightChild().getCor())) {
            // • Rotação simples a esquerda
            // • Pinte o pai de negro
            // • w igual a cor anterior do pai de x
            // • Pinte o filho direito de w de negro
            this.rotacaoEsquerdaSimples(x);
            String corT = pai.getCor();
            pai.setCor(Cores.NEGRO);
            w.setCor(corT);
            if (w.rightChild() != null) {
                w.rightChild().setCor(Cores.NEGRO);
            }
        }
}
}
