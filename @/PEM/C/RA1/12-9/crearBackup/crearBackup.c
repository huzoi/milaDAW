#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    FILE *origen, *desti;
    char caracter;
    char nom_desti[256];
    char *punt;

    if (argc != 2) {
        printf("Ús: backuptxt arxiu.txt\n");
        return 1;
    }

    punt = strrchr(argv[1], '.');
    if (punt == NULL || strcmp(punt, ".txt") != 0) {
        printf("Error: L'arxiu ha de tenir extensió .txt\n");
        return 1;
    }

    origen = fopen(argv[1], "r");
    if (origen == NULL) {
        printf("Error: No s'ha pogut obrir l'arxiu '%s'\n", argv[1]);
        return 1;
    }

    strcpy(nom_desti, argv[1]);
    punt = strrchr(nom_desti, '.');
    strcpy(punt, ".bkp");

    desti = fopen(nom_desti, "w");
    if (desti == NULL) {
        printf("Error: No s'ha pogut crear l'arxiu '%s'\n", nom_desti);
        fclose(origen);
        return 1;
    }

    while ((caracter = fgetc(origen)) != EOF) {
        fputc(caracter, desti);
    }

    fclose(origen);
    fclose(desti);
    
    printf("Còpia de seguretat creada: '%s' -> '%s'\n", argv[1], nom_desti);
    
    return 0;
}