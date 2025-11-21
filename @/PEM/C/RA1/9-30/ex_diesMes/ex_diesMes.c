
#include <stdio.h>


//He apres que els 'ints' poden ser profunditzats.
int anyTraspas(int any){
    if ((any % 4 == 0 && any % 100 != 0) || any % 400 == 0){ //Formula de l'any de traspas
        return 1;
    }
    return 0; //Si es any de traspas 1, si no, 0.
}

int diesMes(int any, int mes){
    switch(mes){
        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            return 31;
        case 4: case 6: case 9: case 11:
            return 30;
        case 2:
            return anyTraspas(any) ? 29 : 28; //Febrer.
        default:
            return -1; //Valor Invalid.
    }
}

int main(){
    int any, mes;

    printf("Introdueix l'any: ");
    scanf("%d", &any);
    printf("\nIntrodueix el numero de mes (1-12): ");
    scanf("%d", &mes);

    int dies = diesMes(any, mes);
    if (dies == -1){
        printf("\nValor invalid!\n");
    } else {
        printf("\nEl mes %d de l'any %d te %d dies.\n", mes, any, dies);
    }

    return 0;
}
