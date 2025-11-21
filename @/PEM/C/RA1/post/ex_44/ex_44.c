
#include <stdio.h>


int main(){

	int num1, num2, num3;

	printf("Introdueix un nombre: ");
	if (scanf("%d", &num1) != 1){
        printf("\nValor Invalid\n");
        return 1;
    }

	printf("Introdueix un segon nombre: ");
	if (scanf("%d", &num2) != 1){
        printf("\nValor Invalid\n");
        return 2;
    }

	printf("Introdueix un tercer nombre: ");
	if (scanf("%d", &num3) != 1){
        printf("\nValor Invalid\n");
        return 3;
    }

	// M'ha costat trobar la formula, pero ho he aconseguit.
	if (num1 > num2){
        int mesGran = num1;
        num1 = num2;
        num2 = mesGran;
	}
        if (num1 > num3){
            int mesGran = num1;
            num1 = num3;
            num3 = mesGran;
	}
            if (num2 > num3){
                int mesGran = num1;
                num2 = num3;
                num3 = mesGran;
	}

	printf("%d / %d / %d (de petit a gran)", num1, num2, num3);

	getch();
}
