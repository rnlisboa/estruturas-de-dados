package ESPilha;

import java.util.Vector;

public class Teste {
    public static void main(String[] args) throws Exception {
        Vector<Integer> l = new Vector<Integer>();
        l.add(3);
        l.add(6);
        l.add(2);
        l.add(7);
        l.add(5);

        powerlines(l);
    }

    public static void powerlines(Vector<Integer> l){
        int index = 0;
        int loop = 0;
        Vector<Pilha> pilhas = new Vector<Pilha>();
        while(true){
            Object atual = l.get(index);
            Object atualEsquerda;

            if(index-1 < 0) atualEsquerda = atual;
            else atualEsquerda = l.get(index-1);

            boolean atualIsTaller = isTaller(atual, atualEsquerda);
            if(atualIsTaller){
                Pilha p = new Pilha(1);
                p.push(atual);
                int nindex = index + 1;
                l.remove(index);
                while(nindex < l.size()){
                    Object natual = l.get(nindex);
                    Object natualEsquerda = l.get(nindex - 1);
                    boolean natualIsTaller = isTaller(natual, natualEsquerda);
                    if(natualIsTaller){
                        p.push(natual);
                        l.remove(nindex);
                    }
                    index = nindex;
                    nindex++;
                }
                pilhas.add(p);
            }
            index++;
            if(index == l.size()){
                loop++;
                index = 0;
            }

            if(loop == l.size()-1) break;
        }
    }

    public static boolean isTaller(Object a, Object b){
        if(b == null || a == null) return false;
        return (int)a > (int)b;
    }
}
