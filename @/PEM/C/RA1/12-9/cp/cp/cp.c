#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    FILE *origen, *desti;
    char caracter;
    char resposta;
    
    if (argc != 3) {
        printf("Ús: cp arxiu_origen arxiu_desti\n");
        return 1;
    }
    
    origen = fopen(argv[1], "r");
    if (origen == NULL) {
        printf("Error: L'arxiu origen '%s' no existeix.\n", argv[1]);
        return 1;
    }
    
    desti = fopen(argv[2], "r");
    if (desti != NULL) {
        fclose(desti);
        printf("L'arxiu '%s' ja existeix. Vols sobreescriure'l? (s/n): ", argv[2]);
        scanf(" %c", &resposta);
        
        if (resposta != 's' && resposta != 'S') {
            printf("Operació cancel·lada.\n");
            fclose(origen);
            return 0;
        }
    }

    desti = fopen(argv[2], "w");
    if (desti == NULL) {
        printf("Error: No s'ha pogut crear l'arxiu destí '%s'.\n", argv[2]);
        fclose(origen);
        return 1;
    }

    while ((caracter = fgetc(origen)) != EOF) {
        fputc(caracter, desti);
    }

    fclose(origen);
    fclose(desti);
    
    printf("Arxiu copiat correctament: '%s' -> '%s'\n", argv[1], argv[2]);
    
    return 0;
}