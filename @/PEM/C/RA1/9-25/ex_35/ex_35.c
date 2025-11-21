
#include <stdio.h>

int main()
{
    int num;

    // Demanem un numero enter.
    printf("Introdueix un numero (enter): ");
    scanf("%d", &num);

    // Determina si el numero és parell o senar.
    if (num % 2 == 0)
    {
    printf("El numero es parell.\n");
    } else {
     printf("El numero es senar.\n");
    }

    return 0;
}
