#include <stdio.h>


int main(){

    int edat, estatura;

    printf("Introdueix la teva edat: ");
    if (scanf("%d", &edat) != 1){
        printf("\nValor Invalid\n");
        return 1;
    }
        if (edat < 5 || edat > 10){
            printf("\nAquesta atraccio no esta disponible pels nens de la teva edat\n");
            return 2;
    }

    printf("\nIntrodueix la teva estatura (en cm): ");
    if (scanf("%d", &estatura) != 1){
        printf("\nValor Invalid\n");
        return 3;
    }
        if (estatura < 50 || estatura > 150){
            printf("\nAquesta atraccio no esta disponible pels nens de la teva estatura\n");
            return 4;
    }

    printf("\nEnhorabona! Tens acces a l'atraccio!\n");

    getch();

}
