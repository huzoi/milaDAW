#include <stdio.h>


/*void main(){

    float edatHome;
    float edatDona;

    printf("Escriu l'edat de l'home: ");
    scanf("%d", &edatHome);

    printf("\nEscriu l'edat de la dona: ");
    scanf("%d", &edatDona);

    while (!(edatDona > (edatHome + 2)) && !(edatHome == -1 && edatDona == -1)){
        scanf("%d", &edatHome);
        scanf("%d", &edatDona);
    }
        if (edatDona > (edatHome + 2)){
            printf("\nAquesta dona te +3 anys més que el seu home.\n");
        }
    getch();
} */

void main(){

    int edatH, edatD;

    scanf("%d, %d", &edatH, &edatD);
    while (!(edatH==-1 && edatD==-1) && !(edatH<= edatD-3)){
       scanf("%d, %d", &edatH, &edatD);
    }
        if (edatH<= edatD-3){
            printf("Trobada");
        }else{
            printf("No trobada");
        }
}
