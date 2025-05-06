package Arvores;

import Node.No;

public class ArvoreAVL extends ArvBinPesquisa {

    public No incluirAVL(Object key) {
        No novo = this.incluir(key);
        this.atualizaFB(novo);
        return novo;
    }

    public void atualizaFB(No novo) {
        int incremento = this.isRightChild(novo) ? -1 : 1;
        No current = novo.parent();
        boolean deveParar = false;

        while(!deveParar && current != null) {        
            current.incrementaFb(incremento);    
            if (current.getFb() < -1 || current.getFb() > 1) {
                this.rebalanceamento(current);
            }

            if(current.equals(this.getRaiz()) || current.getFb() == 0) {
                deveParar = true;
            }

            incremento = this.isRightChild(current) ? -1 : 1;
            current = current.parent();
        }
    }

    public boolean isRightChild(No no) {
        if(no.equals(this.getRaiz())){
            return false;
        }

        return (int)no.parent().element() < (int)no.element();
    }

    public void rebalanceamento(No current) {
        No leftChild = current.leftChild();
        No rightChild = current.rightChild();
        // FB = 2 --> ROTAÇÃO À DIREITA, FB POSITIVO
        // SE O SINAL DO FILHO ESQUERDA É OPOSTO AO DO NÓ DESBALANCEADO, R. DUPLA DIR
        if (leftChild != null) {
            if (leftChild.getFb() * current.getFb() < 0) {
                this.rotacaoDuplaDireita(current);
            }
            // SE O SINAL FOR IGUAL, ROTAÇÃO SIMPLES
            if (leftChild.getFb() * current.getFb() > 0) {
                this.rotacaoSimplesDireita(current);
            }
        }
        // --------------------

        // FB = -2 --> ROTAÇÃO À ESQUERDA, FB NEGATIVO
        // SE O SINAL DO FILHO DIREITO É OPOSTO AO DO NÓ DESBALANCEADO, R. DUPLA ESQ
        if (rightChild != null) {
            if (rightChild.getFb() * current.getFb() < 0) {
                this.rotacaoDuplaEsquerda(current);
            }
            // SE O SINAL FOR IGUAL, ROTAÇÃO SIMPLES
            if (rightChild.getFb() * current.getFb() > 0) {
                this.rotacaoSimplesEsquerda(current);
            }
        }

    }

    public void rotacaoSimplesEsquerda(No current) {
        this.atualizaFbEsquerda(current);
        No novoPai = current.rightChild();

        current.setRightChild(novoPai.leftChild());
        if (novoPai.hasLeftChild()) {
            novoPai.leftChild().setParent(current);
        }

        if (!current.equals(this.getRaiz())) {
            if(this.isRightChild(current)) {
                current.parent().setRightChild(novoPai);
            } else {
                current.parent().setLeftChild(novoPai);
            }
            novoPai.setParent(current.parent());
        }

        novoPai.setLeftChild(current);
        current.setParent(novoPai);

        if (current.equals(this.getRaiz())) {
            this.setRaiz(novoPai);
        }
    }

    public void rotacaoSimplesDireita(No current) {
        // SE O SINAL DO FILHO ESQUERDA É IGUAL AO DO NÓ DESBALANCEADO, R. SIMPLES DIR
        this.atualizaFbDireita(current);
        No novoPai = current.leftChild();

        current.setLeftChild(novoPai.rightChild());
        if (novoPai.hasRightChild()) {
            novoPai.rightChild().setParent(current);
        }

        if (!current.equals(this.getRaiz())) {
            if(this.isRightChild(current)) {
                current.parent().setRightChild(novoPai);;
            } else {
                current.parent().setLeftChild(novoPai);
            }
            novoPai.setParent(current.parent());
        }
        novoPai.setRightChild(current);
        current.setParent(novoPai);

        if (current.equals(this.getRaiz())) {
            this.setRaiz(novoPai);
        }
    }

    public void rotacaoDuplaDireita(No current) {
        this.rotacaoSimplesEsquerda(current.leftChild());
        this.rotacaoSimplesDireita(current);
    }

    public void rotacaoDuplaEsquerda(No current) {
        this.rotacaoSimplesDireita(current.rightChild());
        this.rotacaoSimplesEsquerda(current);
    }

    public void atualizaFbEsquerda(No current) {
        int fb_b_novo = current.getFb() + 1 - Math.min(current.rightChild().getFb(), 0);
        int fb_a_novo = current.rightChild().getFb() + 1 - Math.max(fb_b_novo, 0);
        current.atualizaFb(fb_b_novo);
        current.rightChild().atualizaFb(fb_a_novo);
    }

    public void atualizaFbDireita(No current) {
        int fb_b_novo = current.getFb() - 1 - Math.max(current.leftChild().getFb(), 0);
        int fb_a_novo = current.leftChild().getFb() - 1 + Math.min(fb_b_novo, 0);

        current.atualizaFb(fb_b_novo);
        current.leftChild().atualizaFb(fb_a_novo);
    }
}
