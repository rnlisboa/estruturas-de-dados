package ESPilha;

import java.util.Vector;

public class Powerlines {
    public static void main(String[] args) throws Exception {
        Object[] l = {8,6,10,4,1,5,3};
        powerlines(l);
    }

    public static void powerlines(Object[] l){
        Pilha p = new Pilha(2);
        for(int i=0;i<l.length;i++){
            p.push(l[i]);   
        }

        for(int i = 0; i < p.size(); i++){
            Object a = p.pop();
            Vector pl = new Vector<Object>();
            pl.add(a);
            
        }
    }
    
}
