#include <stdio.h>


int main()
{
    char tecla;

    printf("Introdueix un caracter (scanf): ");
    scanf("%c", &tecla);

    // En principi em donava un valor boig.
    // Però ho vaig solucionar repetint la variable 'tecla' no se ni cóm.

    printf("Codi ASCII de '%c' (scanf): %d\n", tecla, tecla);
    getchar();


    printf("Introdueix un caracter (getch): ");
    tecla = getch();
    printf("\nCodi ASCII de '%c' (getch): %d\n", tecla, tecla);


    printf("Introdueix un caracter (getche): ");
    tecla = getche();
    printf("\nCodi ASCII de '%c' (getche): %d\n", tecla, tecla);

    return 0;
}
