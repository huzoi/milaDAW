
#include <stdio.h>


int main()
{
    float graus;

    // Demanar el radi a l'usuari
    printf("Introdueix els graus (celsius): ");
    scanf("%f", &graus);

    // C�lculs del cercle
    float f = (graus + 32) * 1.8;

    // Mostrar els resultats
    printf("Graus Fahrenheit: %.2f\n", f);


    return 0;
}

