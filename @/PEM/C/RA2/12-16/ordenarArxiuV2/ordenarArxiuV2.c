#include <stdio.h>
#include <string.h>

#define MAX 100
#define MAX_NOM 100

typedef struct {
    char nom[MAX_NOM];
    int durada;
} Tpeli;

void insertar_ordenadament_per_durada(Tpeli t[], int *qt, Tpeli reg) {
    int i, pos;
    
    pos = *qt;
    for (i = 0; i < *qt; i++) {
        if (reg.durada > t[i].durada) {
            pos = i;
            break;
        }
    }
    
    for (i = *qt; i > pos; i--) {
        t[i] = t[i-1];
    }
    
    t[pos] = reg;
    (*qt)++;
}

void bolcar_taula_en_un_fitxer_temporal(char *nom_fitxer, Tpeli t[], int qt) {
    FILE *f;
    int i;
    
    f = fopen(nom_fitxer, "wb");
    if (f == NULL) {
        printf("Error: No s'ha pogut crear el fitxer temporal\n");
        return;
    }
    
    for (i = 0; i < qt; i++) {
        fwrite(&t[i], sizeof(Tpeli), 1, f);
    }
    
    fclose(f);
}

void mostrar_arxiu(char *nom_fitxer) {
    FILE *f;
    Tpeli reg;
    int posicio = 1;
    
    printf("\n=== PEL·LÍCULES ORDENADES PER DURADA (DECREIXENT) ===\n\n");
    
    f = fopen(nom_fitxer, "rb");
    if (f == NULL) {
        printf("Error: No s'ha pogut obrir l'arxiu\n");
        return;
    }
    
    printf("%-5s %-40s %-10s\n", "Pos", "Nom", "Durada");
    printf("----------------------------------------------------------\n");
    
    while (fread(&reg, sizeof(reg), 1, f) == 1) {
        printf("%-5d %-40s %-10d min\n", posicio++, reg.nom, reg.durada);
    }
    
    fclose(f);
    printf("\n");
}

int main() {
    FILE *f;
    Tpeli reg, t[MAX];
    int qt = 0, x;
    
    printf("=== ORDENAR PELIS.DAT PER DURADA ===\n");
    
    f = fopen("pelis.dat", "rb");
    if (f == NULL) {
        printf("Error: No s'ha pogut obrir l'arxiu pelis.dat\n");
        return 1;
    }
    
    printf("\nCarregant pel·lícules a memòria...\n");
    
    x = fread(&reg, sizeof(reg), 1, f);
    
    while (x == 1) {
        insertar_ordenadament_per_durada(t, &qt, reg);
        x = fread(&reg, sizeof(reg), 1, f);
    }
    
    fclose(f);
    
    printf("S'han carregat %d pel·lícules\n", qt);
    printf("Ordenant per durada (decreixent)...\n");
    
    bolcar_taula_en_un_fitxer_temporal("arxiu.tmp", t, qt);
    
    printf("Substituint l'arxiu original...\n");
    
    unlink("pelis.dat");
    rename("arxiu.tmp", "pelis.dat");
    
    printf("\nArxiu ordenat correctament!\n");
    
    mostrar_arxiu("pelis.dat");
    
    return 0;
}