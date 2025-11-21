#include <stdio.h>

void main(){

int num, aprovats, total;
float per;

aprovats = 0;
total = 0;

while (!(total == 3)){
    printf("Introdueix una nota: ");
    if (scanf("%d", &num) != 1 && num < 0){
        printf("\nValor Invalid\n");
        return 0;
        }else if (num > 4 && num < 11){
            aprovats++;
            total++;
            }else{
                total++;
}
}
per = ((float)aprovats / total) * 100;
printf("\nDe 3 examens, n'has aprovat %d, equivalent a un %.2f percent\n.", aprovats, per);
getch();
}
