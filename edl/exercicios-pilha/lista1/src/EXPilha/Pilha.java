package EXPilha;

import Interface.IPilha;
import Interface.PilhaVaziaExcecao;

public class Pilha implements IPilha {
    private int t,c,incremento,i;
    private Object[] pilha;

    public Pilha(int tam, int incremento, int i){
        this.incremento = incremento;
        this.i = i;
        this.t = -1;
        this.c = tam;
        this.pilha = new Object[tam];
    }

    @Override
    public int size() {
        return this.t+1;
    }

    @Override
    public boolean isEmpty() {
        return this.t == -1;
    }

    @Override
    public Object top() throws PilhaVaziaExcecao {
        return this.pilha[t];
    }

    @Override
    public void push(Object o) {
        if(this.incremento == 1){
            if(size() == this.pilha.length){
                int nc = this.c + this.i;
                Object[] npilha = new Object[nc];
                int i;
                for(i = 0; i <= t; i++){
                    npilha[i] = this.pilha[i];
                }
                this.c = nc;
                this.pilha = npilha;
            }
        } else {
            if(size() == this.pilha.length){
                int nc = this.c*2;
                Object[] npilha = new Object[nc];
                int i;
                for(i = 0; i <= t; i++){
                    npilha[i] = this.pilha[i];
                }
                this.c = nc;
                this.pilha = npilha;
            }
        }

        this.t++;
        this.pilha[t] = o;
    }

    @Override
    public Object pop() throws PilhaVaziaExcecao {
        if(isEmpty()) throw new PilhaVaziaExcecao("Pilha vazia");
        Object o = this.pilha[t];
        this.t--;
        return o;
    }

    public void adicionaPilha(Pilha p){
        Pilha aux = p;
        for(int i = 0; i < aux.size(); i++){
            Object o = aux.pop();
            this.push(o);
        }
        
    }
    
}
