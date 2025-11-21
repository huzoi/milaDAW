#include <stdio.h>

void main(){

    int diaCount, diaMax;
    float temp, tempAcc, tempMax;
    temp = 0;
    tempMax = 999;
    diaCount = 0;

    printf("Introdueix una temperatura (GrausC): ");
    if (scanf("%f", &temp) != 1){
        printf("\nValor Invalid\n");
        return 0;
    }
    while (!(tempAcc == 999)){
        printf("\nIntrodueix una temperatura (GrausC): ");
            if (scanf("%f", &temp) != 1){
                printf("\nValor Invalid\n");
                return 0;
                }else if (temp >= 0 && temp <999){
                    temp = tempAcc;
                    diaCount++;
                    }else (tempAcc >= tempMax){
                        printf("S'ha arribat a la temperatura maxima.");
                        }}
    getch();
}
