
#include <stdio.h>

int main(){

    float distancia, descompte, preu;
    char trajecte;

    printf("Introdueix la distancia en quilometres: ");

    /* Amb aquest programa m'hi vaig enrollar durant una estona i vaig informar-me sobre cóm evitar
       que l'usuari entri caracters invalids (cosa que he corretgit als anteriors exercicis ara que sé cóm fer-ho). */
    if (scanf("%f", &distancia) != 1){
        printf("\nValor Invalid\n");
        return 1;
    }

    printf("\nIntrodueix el tipus de viatge (A = Anada / T= AiT): ");
    scanf(" %c", &trajecte);

    preu = distancia * 0.06; // Calcula el preu del trajecte

    if (trajecte == 'T' || trajecte == 't') {
        preu = preu * 2; // Si el bitllet es d'anada i tornada, logicament costa el doble.
        descompte = preu * 0.20;  // 20%.
        preu -= descompte;  // Aplica 20%..
        printf("\nEl preu del bitllet es: %.2f$\n", preu);
    }
        else if (trajecte == 'A' || trajecte == 'a'){
            printf("\nEl preu del bitllet es: %.2f$\n", preu); // Preu sense descompte.
    }       else {
                printf("\n%c no es un valor valid\n", trajecte);
                return 2;
    }

    getch();
}


