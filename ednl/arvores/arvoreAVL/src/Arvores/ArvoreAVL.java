package Arvores;

import Node.No;

public class ArvoreAVL extends ArvBinPesquisa {

    public No incluirAVL(Object key) {
        No novoNo = new No(key);

        if (this.getRaiz() == null) {
            this.root = novoNo;
            return novoNo;
        }

        No current = this.getRaiz();

        while (current != null) {
            if ((int) key > (int) current.element()) {
                if (current.hasRightChild()) {
                    current = current.rightChild();
                } else {
                    current.setRightChild(novoNo);
                    novoNo.setParent(current);
                    this.atualizaFb(current, -1);
                    return novoNo;
                }
            } else if ((int) key < (int) current.element()) {
                if (current.hasLeftChild()) {
                    current = current.leftChild();
                } else {
                    current.setLeftChild(novoNo);
                    novoNo.setParent(current);
                    this.atualizaFb(current, 1);
                    return novoNo;
                }
            }
        }

        return novoNo;
    }

    public void atualizaFb(No current, int somador) {
        while (true) {
            current.setFb(somador);
            if (current.getFb() < -1 || current.getFb() > 1) {
                this.rebalanceamento(current);
            }

            if (current.equals(this.getRaiz()) || current.getFb() == 0) {
                break;
            }
            // Vai subir pela esquerda?! Então, atualize o sinal do somador para positivo!
            if (current.parent().leftChild() == current) {
                somador = 1;
            } else {
                // Se não, vai subir pela direita! Então, atualize o sinal do somador para
                // negativo!
                somador = -1;
            }

            current = current.parent();
        }
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

    public void rotacaoSimplesDireita(No current) {
        // SE O SINAL DO FILHO ESQUERDA É IGUAL AO DO NÓ DESBALANCEADO, R. SIMPLES DIR
        this.atualizaFbDireita(current);
        No leftChild = current.leftChild();

        current.setLeftChild(leftChild.rightChild());
        if (leftChild.hasRightChild()) {
            leftChild.rightChild().setParent(current);
            current.setLeftChild(leftChild.rightChild());
        }

        if (!current.equals(this.getRaiz())) {
            current.parent().setLeftChild(leftChild);
            leftChild.setParent(current.parent());
        }
        leftChild.setRightChild(current);
        current.setParent(leftChild);

        if (current.equals(this.getRaiz())) {
            this.setRaiz(leftChild);
        }
    }

    public void rotacaoDuplaDireita(No current) {

    }

    public void rotacaoSimplesEsquerda(No current) {
        this.atualizaFbEsquerda(current);

        No rightChild = current.rightChild();
        current.setRightChild(rightChild.leftChild());

        if (rightChild.hasLeftChild()) {
            rightChild.leftChild().setParent(current);
            current.setRightChild(rightChild.rightChild());
        }

        if (!current.equals(this.getRaiz())) {
            current.parent().setRightChild(rightChild);
            rightChild.setParent(current.parent());
        }

        rightChild.setLeftChild(current);
        current.setParent(rightChild);

        if (current.equals(this.getRaiz())) {
            this.setRaiz(rightChild);
        }

    }

    public void rotacaoDuplaEsquerda(No current) {

    }

    public void atualizaFb2(No no, int v) {
        No current = no;
        current.setFb(v);

        if (current.parent() == null) {
            return;
        } else if (v == -1) {
            if (current.getFb() == 0) {
                return;
            }

            if (current.parent().leftChild() == current)
                v = 1;

            this.atualizaFb(current.parent(), v);
        } else if (v == 1) {
            if (current.getFb() == 0) {
                return;
            }

            if (current.parent().rightChild() == current)
                v = -1;

            this.atualizaFb(current.parent(), v);
        }
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
