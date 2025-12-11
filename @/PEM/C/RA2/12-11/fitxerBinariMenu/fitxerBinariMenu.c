#include <stdio.h>
#include <string.h>

#define MAX 100

typedef struct {
    char nom[MAX];
    int durada;
} tpeli;

void llegir_peli_teclat(tpeli *peli) {
    printf("Introdueix el nom de la pel·lícula: ");
    fgets(peli->nom, MAX, stdin);
    peli->nom[strcspn(peli->nom, "\n")] = '\0';
    
    printf("Introdueix la durada (en minuts): ");
    scanf("%d", &peli->durada);
    getchar();
}

void mostrar_pantalla_peli(tpeli peli) {
    printf("  - %s (%d min)\n", peli.nom, peli.durada);
}

void mostrar_totes_pelis() {
    FILE *f;
    tpeli peli;
    
    f = fopen("pelis.dat", "rb");
    if (f == NULL) {
        printf("Error: No s'ha pogut obrir l'arxiu pelis.dat\n");
        return;
    }
    
    printf("\n=== LLISTAT DE PEL·LÍCULES ===\n");
    
    while (fread(&peli, sizeof(peli), 1, f) == 1) {
        mostrar_pantalla_peli(peli);
    }
    
    fclose(f);
    printf("\n");
}

void afegir_peli() {
    FILE *f;
    tpeli peli;
    
    f = fopen("pelis.dat", "ab");
    if (f == NULL) {
        printf("Error: No s'ha pogut obrir l'arxiu pelis.dat\n");
        return;
    }
    
    printf("\n=== AFEGIR PEL·LÍCULA ===\n");
    llegir_peli_teclat(&peli);
    
    fwrite(&peli, sizeof(peli), 1, f);
    
    fclose(f);
    printf("Pel·lícula afegida correctament!\n\n");
}

void consulta_peli_nom() {
    FILE *f;
    tpeli peli;
    char nom_buscar[MAX];
    int trobat = 0;
    
    printf("\n=== CONSULTA PEL·LÍCULA PER NOM ===\n");
    printf("Introdueix el nom de la pel·lícula: ");
    fgets(nom_buscar, MAX, stdin);
    nom_buscar[strcspn(nom_buscar, "\n")] = '\0';
    
    f = fopen("pelis.dat", "rb");
    if (f == NULL) {
        printf("Error: No s'ha pogut obrir l'arxiu pelis.dat\n");
        return;
    }
    
    while (fread(&peli, sizeof(peli), 1, f) == 1) {
        if (strcmp(peli.nom, nom_buscar) == 0) {
            printf("\nPel·lícula trobada:\n");
            mostrar_pantalla_peli(peli);
            trobat = 1;
            break;
        }
    }
    
    if (!trobat) {
        printf("\nLa pel·lícula '%s' no s'ha trobat.\n", nom_buscar);
    }
    
    fclose(f);
    printf("\n");
}

void consulta_peli_mes_llarga() {
    FILE *f;
    tpeli peli, peli_llarga;
    int primera = 1;
    
    f = fopen("pelis.dat", "rb");
    if (f == NULL) {
        printf("Error: No s'ha pogut obrir l'arxiu pelis.dat\n");
        return;
    }
    
    while (fread(&peli, sizeof(peli), 1, f) == 1) {
        if (primera || peli.durada > peli_llarga.durada) {
            peli_llarga = peli;
            primera = 0;
        }
    }
    
    fclose(f);
    
    if (!primera) {
        printf("\n=== PEL·LÍCULA MÉS LLARGA ===\n");
        mostrar_pantalla_peli(peli_llarga);
        printf("\n");
    } else {
        printf("\nNo hi ha pel·lícules a l'arxiu.\n\n");
    }
}

void mostrar_menu() {
    printf("=============================\n");
    printf("    GESTIÓ DE PEL·LÍCULES\n");
    printf("=============================\n");
    printf("A) Mostrar totes les pelis\n");
    printf("B) Afegir peli\n");
    printf("C) Consulta peli per nom\n");
    printf("D) Consulta peli més llarga\n");
    printf("E) Sortir\n");
    printf("=============================\n");
    printf("Opció: ");
}

int main() {
    char opcio;
    
    do {
        mostrar_menu();
        scanf(" %c", &opcio);
        getchar();
        
        opcio = toupper(opcio);
        
        switch(opcio) {
            case 'A':
                mostrar_totes_pelis();
                break;
            case 'B':
                afegir_peli();
                break;
            case 'C':
                consulta_peli_nom();
                break;
            case 'D':
                consulta_peli_mes_llarga();
                break;
            case 'E':
                printf("\nSortint del programa...\n");
                break;
            default:
                printf("\nOpció incorrecta. Torna a intentar-ho.\n\n");
        }
        
    } while(opcio != 'E');
    
    return 0;
}