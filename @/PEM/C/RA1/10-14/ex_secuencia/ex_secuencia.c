#include <stdio.h>
#define MAX 10
#define PROMIG 5


void main(){

    int qt, qt2, qt3, i;
    int nota, notes;
    qt = 0;
    qt2 = 0;
    qt3 = 0;

    printf("\nEscriu una nota: ");
    scanf("%d", &nota);

    while (!(nota>0 && qt<MAX)){
           if (nota<0){
            qt2++;
            scanf("%d", &nota);
           }    else if (nota<PROMIG){
                    qt3++;
                    scanf("%d", &nota);
                }

    }
    if (qt<MAX){
    printf("\nS'ha introduit %d notes, i d'aquestes, %d son superiors al promig\n", qt, qt2);
    getch();
    }
}
