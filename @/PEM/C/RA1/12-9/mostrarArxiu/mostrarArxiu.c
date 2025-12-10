#include <stdio.h>

int main() {
    FILE *arxiu;
    char caracter;

    arxiu = fopen("pelis.txt", "r");
    
    if (arxiu == NULL) {
        printf("Error: No s'ha pogut obrir l'arxiu\n");
        return 1;
    }
    
    printf("Contingut de l'arxiu:\n");
    printf("==================================\n\n");

    while ((caracter = fgetc(arxiu)) != EOF) {
        putchar(caracter);
    }
    
    printf("\n==================================\n");

    fclose(arxiu);
    
    return 0;
}