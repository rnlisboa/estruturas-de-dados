package ESPilha;

public class Powerlines {
    public static void main(String[] args) throws Exception {
        Object[] l = {3, 6, 2, 7, 5};
        powerlines(l);
    }

    public static void powerlines(Object[] l){
        int index = 0;
        int loop = 0;
        while(true){
            Object atual = l[index];
            Object atualEsquerda;
            
            if(index-1 < 0) atualEsquerda = atual;
            else atualEsquerda = l[index-1];

            boolean atualIsTaller = isTaller(atual, atualEsquerda);
            if(atualIsTaller){
                Pilha p = criaNovaPilha();
                p.push(atual);
                int nindex = index + 1;
                l[index] = null;
                while(nindex < l.length){
                    Object natual = l[nindex];
                    Object natualEsquerda = l[nindex - 1];
                    boolean natualIsTaller = isTaller(natual, natualEsquerda);
                    if(natualIsTaller){
                        p.push(natual);
                        l[nindex] = null;
                    }
                    index = nindex;
                    nindex++;
                }
            }
            index++;
            if(index == l.length){
                loop++;
                index = 0;
            }

            if(loop == l.length-1) break;
        }
    }

    public static boolean isTaller(Object a, Object b){
        if(b == null || a == null) return false;
        return (int)a > (int)b;
    }

    public static Pilha criaNovaPilha(){
        Pilha pilha = new Pilha(1);
        return pilha;
    }
    
}
