#include <stdio.h>
#include <string.h>

#define MAX_NOM 100

typedef struct {
    char nom[MAX_NOM];
    int durada;
} tpeli;

void llegir_peli_teclat(tpeli *peli) {
    printf("Introdueix el nom de la pel·lícula: ");
    fgets(peli->nom, MAX_NOM, stdin);
    peli->nom[strcspn(peli->nom, "\n")] = '\0';
    
    printf("Introdueix la durada (en minuts): ");
    scanf("%d", &peli->durada);
    getchar();
}

void mostrar_pantalla_peli(tpeli peli) {
    printf("  - %s (%d min)\n", peli.nom, peli.durada);
}

int main() {
    FILE *f;
    tpeli peli;
    int i, x;
    
    f = fopen("pelis.dat", "wb");
    if (f == NULL) {
        printf("Error: No s'ha pogut crear l'arxiu pelis.dat\n");
        return 1;
    }
    
    for (i = 0; i < 5; i++) {
        printf("Pel·lícula %d:\n", i + 1);
        llegir_peli_teclat(&peli);
        
        x = fwrite(&peli, sizeof(peli), 1, f);
        if (x != 1) {
            printf("Error en escriure la pel·lícula\n");
        }
        printf("\n");
    }
    
    fclose(f);
    
    f = fopen("pelis.dat", "rb");
    if (f == NULL) {
        printf("Error: No s'ha pogut obrir l'arxiu pelis.dat\n");
        return 1;
    }
    
    printf("\nLlistat de pel·lícules:\n");
    
    while (fread(&peli, sizeof(peli), 1, f) == 1) {
        mostrar_pantalla_peli(peli);
    }
    
    fclose(f);
    
    return 0;
}