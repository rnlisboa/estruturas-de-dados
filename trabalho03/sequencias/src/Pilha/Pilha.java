package Pilha;


public class Pilha{
    private int top;
    private Object[] lista;
    
    public Pilha(int tamanho){
        top = -1;
        lista = new Object[tamanho];
    }

    public void Push(Object value){
        this.top++;
        this.lista[top] = value;
    }

    public Object Pop(){
        Object ultimoTop = lista[top];
        top--;
        return ultimoTop;
    }
    
}
