#include <stdio.h>
#include <string.h>
#include <ctype.h>

#define MAX 100

typedef struct {
    char nom[MAX];
    int durada;
} tpeli;

void convertir_majuscules(char *str) {
    for (int i = 0; str[i] != '\0'; i++) {
        str[i] = toupper(str[i]);
    }
}

int main() {
    FILE *f, *temp;
    tpeli peli;
    char nom_eliminar[MAX];
    char nom_peli_upper[MAX];
    char nom_eliminar_upper[MAX];
    int trobat = 0;
    int total = 0;
    
    printf("=== ELIMINAR PEL·LÍCULA ===\n");
    printf("Introdueix el nom de la pel·lícula a eliminar: ");
    fgets(nom_eliminar, MAX, stdin);
    nom_eliminar[strcspn(nom_eliminar, "\n")] = '\0';
    
    strcpy(nom_eliminar_upper, nom_eliminar);
    convertir_majuscules(nom_eliminar_upper);
    
    f = fopen("pelis.dat", "rb");
    if (f == NULL) {
        printf("Error: No s'ha pogut obrir l'arxiu pelis.dat\n");
        return 1;
    }
    
    temp = fopen("pelis.tmp", "wb");
    if (temp == NULL) {
        printf("Error: No s'ha pogut crear l'arxiu temporal\n");
        fclose(f);
        return 1;
    }
    
    while (fread(&peli, sizeof(peli), 1, f) == 1) {
        strcpy(nom_peli_upper, peli.nom);
        convertir_majuscules(nom_peli_upper);
        
        if (strcmp(nom_peli_upper, nom_eliminar_upper) == 0) {
            trobat = 1;
            printf("\nPel·lícula eliminada: %s (%d min)\n", peli.nom, peli.durada);
        } else {
            fwrite(&peli, sizeof(peli), 1, temp);
            total++;
        }
    }
    
    fclose(f);
    fclose(temp);
    
    if (trobat) {
        unlink("pelis.dat");
        rename("pelis.tmp", "pelis.dat");
        printf("Arxiu actualitzat correctament. Queden %d pel·lícules.\n", total);
    } else {
        unlink("pelis.tmp");
        printf("\nLa pel·lícula '%s' no s'ha trobat a l'arxiu.\n", nom_eliminar);
    }
    
    return 0;
}