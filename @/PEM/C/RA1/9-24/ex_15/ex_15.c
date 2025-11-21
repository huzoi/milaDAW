
#include <stdio.h>


int main()
{

int nombre1, nombre2;

printf("Escriu un nombre: ");
scanf("%d", &nombre1);

printf("Ara, escriu un altre nombre: ");
scanf("%d", &nombre2);

int resultat1 = nombre1 / nombre2;
int resultat2 = nombre1 + nombre2;
int resultat3 = nombre1 - nombre2;
int resultat4 = nombre1 * nombre2;

printf("a) %d\n", resultat1);
printf("b) %d\n", resultat2);
printf("c) %d\n", resultat3);
printf("d) %d\n", resultat4);

return 0;
}
