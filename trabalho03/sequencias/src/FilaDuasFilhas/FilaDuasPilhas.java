package FilaDuasFilhas;

import PilhaAux.Pilha;

public class FilaDuasPilhas {
    private Pilha p1;
    private Pilha p2;

    public FilaDuasPilhas(int tamanho){

        p1 = new Pilha(tamanho);
        p2 = new Pilha(tamanho);
    }

    public void enqueue(Object o){
        p1.Push(o);
        
    }

    public void dequeue(){
        p1.Pop();
    }
}
