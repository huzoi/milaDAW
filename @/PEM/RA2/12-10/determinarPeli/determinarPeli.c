#include <stdio.h>
#include <string.h>

int main() {
    FILE *arxiu;
    char titol_buscar[100];
    char linia[100];
    int trobat = 0;

    printf("Introdueix el títol de la pel·lícula: ");
    fgets(titol_buscar, sizeof(titol_buscar), stdin);

    titol_buscar[strcspn(titol_buscar, "\n")] = '\0';

    arxiu = fopen("pelis.txt", "r");
    if (arxiu == NULL) {
        printf("Error: No s'ha pogut obrir l'arxiu pelis.txt\n");
        return 1;
    }

    while (fgets(linia, sizeof(linia), arxiu) != NULL) {
        linia[strcspn(linia, "\n")] = '\0';
        if (strcmp(linia, titol_buscar) == 0) {
            trobat = 1;
            break;
        }
    }

    fclose(arxiu);

    if (trobat) {
        printf("\n✓ La pel·lícula '%s' SÍ es troba a l'arxiu.\n", titol_buscar);
    } else {
        printf("\n✗ La pel·lícula '%s' NO es troba a l'arxiu.\n", titol_buscar);
    }
    
    return 0;
}