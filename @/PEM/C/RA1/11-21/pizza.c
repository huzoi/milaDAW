#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct {
    char nom[50];
    float preu;
} Ingredient;

typedef struct {
    Ingredient ingredients[5];
    int quantitat;
    float total;
} Comanda;

Comanda fer_comanda(Ingredient menu[], int mida_menu) {
    Comanda comanda = {0, 0.0};
    int opcio;
    
    printf("\n=== COMANDA DE PIZZA ===\n");
    printf("Ingredients disponibles:\n");
    
    for (int i = 0; i < mida_menu; i++) {
        printf("%d. %s - %.2f€\n", i + 1, menu[i].nom, menu[i].preu);
    }
    
    printf("\nSelecciona ingredients (0 per acabar):\n");
    
    while (1) {
        printf("Ingredient (1-%d, 0 per acabar): ", mida_menu);
        scanf("%d", &opcio);
        
        if (opcio == 0) break;
        if (opcio < 1 || opcio > mida_menu) {
            printf("Opcio no valida!\n");
            continue;
        }
        
        int index = opcio - 1;
        comanda.ingredients[comanda.quantitat] = menu[index];
        comanda.total += menu[index].preu;
        comanda.quantitat++;
        printf("Afegit: %s\n", menu[index].nom);
    }
    
    return comanda;
}

void mostrar_comanda(Comanda comanda) {
    printf("\n=== RESUM DE LA COMANDA ===\n");
    printf("Ingredients:\n");
    
    for (int i = 0; i < comanda.quantitat; i++) {
        printf("  - %s (%.2f€)\n", comanda.ingredients[i].nom, comanda.ingredients[i].preu);
    }
    
    printf("Total: %.2f€\n", comanda.total);
    printf("===========================\n\n");
}

int main() {
    Ingredient menu[] = {
        {"Formatge", 1.50},
        {"Peroni", 2.00},
        {"Bolets", 1.00},
        {"Cebolla", 0.75},
        {"Bacon", 2.50}
    };
    
    int mida_menu = sizeof(menu) / sizeof(menu[0]);
    
    Comanda pizza = fer_comanda(menu, mida_menu);
    mostrar_comanda(pizza);
    
    return 0;
}
