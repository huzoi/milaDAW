#include <stdbool.h>
#include <stdio.h>


void main(){

    int num;
    int i;

    for (num = 1; num <= 10; num++){
        printf("\n\nLa taula del %d\n\n", num);
            for (i = 1; i <= 10; i++){
            printf("\n%d * %d = %d", num, i, i*num);
            }
        }
    getch();
}



