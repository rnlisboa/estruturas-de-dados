package EXPilha.PilhaEncadeada;

public class PilhaEncadeada {
    private Node first, last;
    private int size;

    public PilhaEncadeada(){
        this.size = 0;
    }

    public void push(Object o){
        Node novo = new Node(o, last);
        if(first == null){
            this.first = novo;
        } else {
            Node prevInicio = first.getProx();
            novo.setProx(prevInicio);
            first = novo;
        }
        
    }

    public void print(){
        Node current = this.first;
        while(current != null){
            System.out.println(current.getValue() + " ");
            current = current.getProx();
        }
    }

}
