package HeapArray;

public class HeapArray {
    private int lastPos;
    private int n = 10;
    private Object[] array = new Object[11];

    public HeapArray(Object o) {
        array[1] = o;
    }

    private void increase() {
        int newN = n * 2 + 1;
        Object[] newArray = new Object[newN];
        for (int i = 0; i < newN; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
        n = newN;

        upheap();
    }

    public Object insert(Object o) {
        if (lastPos == n)
            increase();

        if (array[2 * lastPos] == null) {
            array[2 * lastPos] = o;
            lastPos = 2 * lastPos;
            return o;
        } else {
            array[2 * lastPos + 1] = o;
            lastPos = 2 * lastPos + 1;
        }

        upheap();
        return o;
    }

    public void upheap() {
        int posNewElm = lastPos;
        Object newElm = array[lastPos];
    
        while (posNewElm > 1 && ((int) newElm > (int) array[posNewElm / 2])) {
            array[posNewElm] = array[posNewElm / 2];
            posNewElm = posNewElm / 2;
        }
        array[posNewElm] = newElm;
    }
    

    public Object removeMin() {
        Object o = array[n];
        array[n] = null;
        return o;
    }
}
