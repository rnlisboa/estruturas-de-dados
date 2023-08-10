#include <iostream>
#include <new>
#include <string>
#include <stdlib.h>

#define TAM 10
using namespace std;

void imprimeVetor(int vetor[], int count){
    for(count = 0; count <= TAM; count++){
        cout << vetor[count] << " - ";
    }
}

int buscaValor(int vetor[], int count, int valorProcurado, int posicao){
    for(count = 0; count <= TAM; ++count){
        if(vetor[count] == valorProcurado)
            return count;
    }

    return -1;
}

int main(){
    int vetor[10] = {1,29,23,44,56,6,72,81,95,101};
    int valorProcurado;
    int posicao;
    int count;
    
    imprimeVetor(vetor, count);

    cout << "\nQual numero deseja encontrar?\n";
    scanf("%d", &valorProcurado);
    
    int encontrado = buscaValor(vetor, count, valorProcurado, posicao);
    if(encontrado >= 0)
        cout << "Encontado na posição: " << encontrado;
    else
        cout << "Nao encontrado.";       
    
    return 0;
}