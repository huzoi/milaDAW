
#include <stdio.h>


int main()
{

double nombre;
int nombreInt;
double nombreDouble;

printf("Escriu un nombre amb decimals: ");
scanf("%lf", &nombre);

nombreInt = (int) nombre;
nombreDouble = nombre - nombreInt;

printf("a) %d\n", nombreInt);
printf("b) %.3f\n", nombreDouble);

return 0;
}
