#include <iostream>
#include <new>
#include <string>
#include <stdlib.h>
#include <stdio.h>

#define TAM 10
using namespace std;

void imprimeVetor(int vetor[], int count){
    for(count = 0; count <= TAM; count++){
        cout << vetor[count] << " - ";
    }
}

int buscaValor(int vetor[], int valorProcurado, int *posicao){
    int esquerda = 0; //limite da esquerda
    int direita = TAM - 1; //limite da direita
    int meio; //cursor

    while (esquerda <= direita){
        meio = (direita + esquerda) / 2;
        //quando o valor do meio é encontrado
        if(valorProcurado == vetor[meio]){
            return meio;
        }

        //ajustando os limites
        if(vetor[meio] < valorProcurado){
            esquerda = meio + 1;
        } else {
            direita = meio - 1;
        }
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
    
    int encontrado = buscaValor(vetor, valorProcurado, &posicao);
    if(encontrado >= 0)
        cout << "Encontado na posição: " << encontrado;
    else
        cout << "Nao encontrado.";       
    
    return 0;
}