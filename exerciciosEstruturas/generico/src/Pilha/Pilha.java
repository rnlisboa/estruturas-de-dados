package Pilha;

public class Pilha implements IPilha {
    private int top = -1;
    private Object[] lista = new Object[50];
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top==-1;
    }

    @Override
    public Object top() throws PilhaVaziaExcecao {
       return  lista[top];
    }

    @Override
    public void push(Object o) {
        top++;
        lista[top] = o;
        size++;
    }

    @Override
    public Object pop() throws PilhaVaziaExcecao {
        Object topPilha = top();
        top--;
        return topPilha;
    }

    @Override
    public void adicionaPilha(Pilha p) {
        Pilha coPilha = new Pilha();
        for (int i = 0; i < p.size(); i++){
            coPilha.push(p.pop());
            
        }
        for (int i = 0; i < coPilha.size(); i++){
            Object top = coPilha.pop();
            p.push(top);
            push(top);
            
        }
    }

    public void print(){
        System.out.print("{");
        for(int index = 0; index <= top; index++){
            System.out.print(lista[index] + ", ");
        }
        System.out.print("}");
        System.out.println();
    }
    
}
