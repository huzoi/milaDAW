#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>


void main(){

    bool errmsg = false;
    int num;


    printf("num (0/1): ");
    scanf("%d", &num);

    if (!(num == 0 || num == 1)){
        printf("\nillegal value");
        scanf("%d", &num);
    }
        else if (num == 0){
            printf("now try with 1 trust ");
            scanf("%d", &num);
        }
            else {
                errmsg = true;
            }
    if (errmsg){
        pr_err("AMD Radeon\n\nbrace for impact nigga\n");
    }
    getch();
}
