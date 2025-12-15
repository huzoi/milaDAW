#include <stdio.h>
#include <string.h>

#define MAX 100

typedef struct {
    char nom[MAX];
    int durada;
} tpeli;

void mostrar_pantalla_peli(tpeli peli) {
    printf("  - %s (%d min)\n", peli.nom, peli.durada);
}

int main() {
    FILE *f;
    tpeli peli;
    int count = 0;
    
    f = fopen("pelis.dat", "r+b");
    if (f == NULL) {
        printf("Error: No s'ha pogut obrir l'arxiu pelis.dat\n");
        return 1;
    }
    
    printf("=== ACTUALITZACIÓ DE DURADES ===\n\n");
    printf("Abans:\n");
    
    while (fread(&peli, sizeof(peli), 1, f) == 1) {
        mostrar_pantalla_peli(peli);
        count++;
    }
    
    fseek(f, 0, SEEK_SET);
    
    while (fread(&peli, sizeof(peli), 1, f) == 1) {
        peli.durada += 3;
        
        fseek(f, -1*sizeof(peli), SEEK_CUR);
        fwrite(&peli, sizeof(peli), 1, f);
        fseek(f, 0, SEEK_CUR);
    }
    
    fseek(f, 0, SEEK_SET);
    
    printf("\nDesprés:\n");
    while (fread(&peli, sizeof(peli), 1, f) == 1) {
        mostrar_pantalla_peli(peli);
    }
    
    fclose(f);
    
    printf("\nS'han actualitzat %d pel·lícules (+3 minuts per publicitat)\n", count);
    
    return 0;
}