#include <stdbool.h>
#include <stdio.h>


void main(){

    float temp;
    int count = 0;
    bool glasada = false;

    printf("Introdueix una temperatura (ºC): ");
    scanf("%f", &temp);

    while (!(temp == -100)){
        if (glasada){
            count++;
            }if (temp < 0){
                glasada = true;
                }
                scanf("%f", &temp);
                }
    if (glasada){
    printf("Han passat %d dies des de la 1a glaçada.");
    return 0;
    }
}
