
#include <stdio.h>

int main(){

	int num1, num2, num3;

	printf("Introdueix un nombre: ");
	if (scanf("%d", &num1) != 1){
        printf("\nValor Invalid\n");
        return 0;
	}

	printf("\nIntrodueix un segon nombre: ");
	if (scanf("%d", &num2) != 1){
        printf("\nValor Invalid\n");
        return 1;
	}

	printf("\nIntrodueix un tercer nombre: ");
	if (scanf("%d", &num3) != 1){
        printf("\nValor Invalid\n");
        return 2;
	}

	if (num1 > num2 && num1 > num3) {
		printf("\nEl nombre %d (1r) es el mes gran\n.", num1);
	}
        else if (num2 > num1 && num2 > num3) {
            printf("\nEl nombre %d (2n) es el mes gran\n.", num2);
	}
	       else {
                printf("\nEl nombre %d (3r) es el mes gran\n.", num3);
	}

	getch();
}
