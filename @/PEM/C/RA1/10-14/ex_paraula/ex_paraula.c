// Donada per teclat una paraula acabada en '.', mostrar-la en ordre invers.

#include <stdio.h>
#define MAX 30

void main(){

    int qt;
    int i;
    char lletra;
    char lletres[MAX];
    qt = 0;

    scanf("%c", &lletra);

    while (!(lletra=='.') && qt<MAX){
        lletres[qt]=lletra;
        qt++;
        scanf("%c", &lletra);
    }

    if (lletra=='.'){
        for (i=qt-1; i>=0; i--){
            printf("%c", lletres[i]);
        }
    } else {
        printf("\nValor Invalid.\n");
    }
}

