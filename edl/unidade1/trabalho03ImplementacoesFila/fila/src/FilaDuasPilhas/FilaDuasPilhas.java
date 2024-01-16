package FilaDuasPilhas;

import PilhaAux.Pilha;

public class FilaDuasPilhas {
    private Pilha p1, p2;

    public FilaDuasPilhas(int c){
        this.p1 = new Pilha(c);
        this.p2 = new Pilha(c);
    }

    public Object enqueue(Object o){
        p1.push(o);
        return o;
    }

    public Object dequeue(){
        for(int i = p1.size(); i > 0; i--){
            Object rm = p1.pop();
            p2.push(rm);
        }
        
        Object removed = p2.top();
        
        p2.pop();

        for(int i = p2.size(); i > 0; i--){
            Object add = p2.pop();
            p1.push(add);
        }

        return removed;
    }

    public Object first(){
        for(int i = p1.size(); i > 0; i--){
            Object rm = p1.pop();
            p2.push(rm);
        }
        
        Object first = p2.top();
        
        p2.pop();

        for(int i = p2.size(); i > 0; i--){
            Object add = p2.pop();
            p1.push(add);
        }
        
        return first;
    }

    public int size(){
        return p1.size();
    }

    public boolean isEmpty(){
        return false;
    }

    public void print(){
        p1.print();
    }
}
