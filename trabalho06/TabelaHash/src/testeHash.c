#include <stdio.h>

int hash(int x){
    return x % 10;
}

void insere(int a[], int x){
    a[hash(x)] = x;
}

int busca_hash(int a[], int x){
    int k;
    k = hash(x);
    if (a[k] == x)
        return k;
    return - 1;
}

int main(){
    int a[10];
    insere(a, 50);
    insere(a, 35);
    insere(a, 28);
    insere(a, 87);
    insere(a, 12);

    int hash = busca_hash(a, 5);
    printf("%d", hash);
    return 0;
}