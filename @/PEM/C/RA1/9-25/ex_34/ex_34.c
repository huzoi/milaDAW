#include <stdio.h>

int main()
{

int nota;

printf("Escriu la teva nota (0/10): ");
scanf ("%d", &nota);

if (nota < 5)
{
printf("Estas suspes, quin perdedor!!!! bahahahaha ");

getch();
}

if (nota <10)
{
printf("Estas aprobat, felicitats!!! ");

getch();
}

else
{
printf("A mi no em menteixes ehhh!!!! Ara et peto el programa, per burro ");

return 666;
}


getch();

}
