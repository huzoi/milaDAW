
#include <stdio.h>

int main(){

    char tecla;

    printf("Las Palmas - Levante (1 / 2 / X): ");
    scanf("%c", &tecla);

    if (tecla == '1'){
        printf("\nGuanyen Las Palmas!\n");
    }
        else if (tecla == '2'){
            printf("\nGuanya el Levante!\n");
    }
            else if (tecla == 'X' || tecla == 'x'){
                printf("\nHi ha un empat!\n");
    }
                else{
                    printf("\nValor Invalid\n");
                    return 0;
	}

    getch();
}
