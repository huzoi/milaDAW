
#include <stdio.h>
#define PI 3.1416


int main()
{
    float radi;

    // Demanar el radi a l'usuari
    printf("Introdueix el radi (cm): ");
    scanf("%f", &radi);

    // C�lculs del cercle
    float longitud = 2 * PI * radi;
    float area = PI * radi * radi;
    float volum = (4 / 3) * PI * radi * radi * radi;

    // Mostrar els resultats
    printf("Longitud del cercle: %.2f\n", longitud);
    printf("Area del cercle: %.2f\n", area);
    printf("Volum del cercle: %.2f\n", volum);

    return 0;
}
