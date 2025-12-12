#include <stdio.h>
#include <string.h>

int main() {
    FILE *f;
    char linia[256];
    long posicio;
    int caracter;
    int inici_linia;
    
    f = fopen("pelis.txt", "r");
    if (f == NULL) {
        printf("Error: No s'ha pogut obrir l'arxiu pelis.txt\n");
        return 1;
    }

    fseek(f, 0, SEEK_END);
    posicio = ftell(f);
    
    printf("=== PEL·LÍCULES EN ORDRE INVERS ===\n\n");

    while (posicio > 0) {
        inici_linia = 0;
        memset(linia, 0, sizeof(linia));
        int idx = 0;

        posicio--;
        fseek(f, posicio, SEEK_SET);
        caracter = fgetc(f);

        if (caracter == '\n') {
            if (posicio > 0) {
                posicio--;
            }
        }

        while (posicio > 0) {
            fseek(f, posicio - 1, SEEK_SET);
            caracter = fgetc(f);
            
            if (caracter == '\n') {
                inici_linia = 1;
                break;
            }
            posicio--;
        }

        fseek(f, posicio, SEEK_SET);
        if (fgets(linia, sizeof(linia), f) != NULL) {
            linia[strcspn(linia, "\n")] = '\0';

            if (strlen(linia) > 0) {
                printf("%s\n", linia);
            }
        }
 
        if (posicio == 0 && !inici_linia) {
            break;
        }
    }
    
    fclose(f);
    printf("\n");
    
    return 0;
}