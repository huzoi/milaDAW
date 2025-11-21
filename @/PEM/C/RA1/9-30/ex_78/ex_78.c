#include <stdio.h>


int main(){

    float pes, estatura, imc;

    printf("Introdueix el teu pes (kg): ");
    scanf("%d", &pes);
    printf("Introdueix la teva estatura (m): ");
    scanf("%d", &estatura);

    imc = pes / (estatura * 2);

    if (imc > 0 && imc < 18){
        printf("\nVoste mostra una situacio de Magror.\n");
        }else if (imc >= 18 && imc < 25){
            printf("\nVoste mostra una situacio de Corupulencia Normal.\n");
            }else if (imc >= 25 && imc < 30){
                printf("\nVoste esta sofrint una situacio de Sobrepes.\n");
                }else if (imc >= 30 && imc <= 40){
                    printf("\nVoste esta sofrint una situacio d'Obesitat.\n");
                    }else if (imc > 40){
                        printf("\nVoste esta patint una situacio d'Obesitat Morbida.\n");
                        }
    getch();

    }
