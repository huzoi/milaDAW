
#include <stdio.h>

// M'ha costat saber com funciona l'else, i pel camí he descobert que un if pot englobar un altre. Soc idiota.

int main()
{
    char lletra;

    printf("Introdueix una lletra: ");
    scanf("%c", &lletra);

    if (lletra == 'a' || lletra == 'i' || lletra == 'u' || lletra == 'e' || lletra == 'o'){
     printf("La lletra %c es vocal \n", lletra);

      if (lletra == 'e' || lletra == 'o'){
        printf("La vocal %c pot tenir accents oberts \n", lletra);
        } else {
           printf("La vocal %c NO pot tenir accents oberts \n", lletra);
        }}
     else {
        printf("La lletra %c es consonant \n", lletra);
     }

     getch();
}
