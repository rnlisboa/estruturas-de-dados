package MergeSort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        int[] minhaLista = new int[1000000];
        Random random = new Random();
        
        for (int i = 0; i < minhaLista.length; i++) {
            minhaLista[i] = random.nextInt(1000000);
        }

        long inicio = System.currentTimeMillis();
        mergeSort(minhaLista);
        long fim = System.currentTimeMillis();

        boolean ordenada = isOrdenada(minhaLista);
        double tempo = (fim - inicio) / 1000.0; 

        if (ordenada) {
            System.out.printf("Ordenada em %.2f segundos!\n", tempo);
        } else {
            System.out.println("Não ordenada!");
        }
    }

    public static void mergeSort(int[] lista) {
        if (lista.length <= 1) {
            return;
        }
        
        int meio = lista.length / 2;
        int[] esquerda = Arrays.copyOfRange(lista, 0, meio);
        int[] direita = Arrays.copyOfRange(lista, meio, lista.length);

        mergeSort(esquerda);
        mergeSort(direita);

        merge(lista, esquerda, direita);
    }

    public static void merge(int[] lista, int[] esquerda, int[] direita) {
        int i = 0, j = 0, k = 0;

        while (i < esquerda.length && j < direita.length) {
            if (esquerda[i] < direita[j]) {
                lista[k] = esquerda[i];
                i++;
            } else {
                lista[k] = direita[j];
                j++;
            }
            k++;
        }

        while (i < esquerda.length) {
            lista[k] = esquerda[i];
            i++;
            k++;
        }

        while (j < direita.length) {
            lista[k] = direita[j];
            j++;
            k++;
        }
    }

    public static boolean isOrdenada(int[] lista) {
        for (int i = 0; i < lista.length - 1; i++) {
            if (lista[i] > lista[i + 1]) {
                return false;
            }
        }
        return true;
    }
}

