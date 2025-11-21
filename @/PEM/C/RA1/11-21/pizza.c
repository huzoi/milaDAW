#include <stdio.h>
#include <string.h>

// Struct for ingredients
typedef struct {
    char nom[50];
    float preu;
    int disponible;
} Ingredient;

// Struct for pizza order
typedef struct {
    char pizza_nom[100];
    Ingredient ingredients[10];
    int ingredient_qt;
    float total_preu;
} PizzaOrder;

// Function to create a pizza order
PizzaOrder create_order(char *nom, Ingredient disponible_ingredients[], int total_ingredients) {
    PizzaOrder order;
    strcpy(order.pizza_nom, nom);
    order.ingredient_qt = 0;
    order.total_preu = 0.0;
    
    printf("\n=== Creating Order: %s ===\n", nom);
    printf("disponible ingredients:\n");
    
    // Display disponible ingredients
    for (int i = 0; i < total_ingredients; i++) {
        printf("%d. %s - $%.2f\n", i + 1, disponible_ingredients[i].nom, disponible_ingredients[i].preu);
    }
    
    printf("\nEnter ingredient numbers to add (0 to finish):\n");
    
    int choice;
    while (1) {
        printf("Select ingredient (0 to finish): ");
        scanf("%d", &choice);
        
        if (choice == 0) break;
        if (choice < 1 || choice > total_ingredients) {
            printf("Invalid choice!\n");
            continue;
        }
        
        // Add ingredient to order
        int index = choice - 1;
        if (disponible_ingredients[index].disponible) {
            order.ingredients[order.ingredient_qt] = disponible_ingredients[index];
            order.total_preu += disponible_ingredients[index].preu;
            order.ingredient_qt++;
            printf("Added %s\n", disponible_ingredients[index].nom);
        } else {
            printf("%s is not disponible!\n", disponible_ingredients[index].nom);
        }
    }
    
    return order;
}

// Function to display order summary
void display_order(PizzaOrder order) {
    printf("\n=== Order Summary ===\n");
    printf("Pizza: %s\n", order.pizza_nom);
    printf("Ingredients:\n");
    
    for (int i = 0; i < order.ingredient_qt; i++) {
        printf("  - %s ($%.2f)\n", order.ingredients[i].nom, order.ingredients[i].preu);
    }
    
    printf("Total preu: $%.2f\n", order.total_preu);
    printf("====================\n\n");
}

// Main function
int main() {
    // Initialize disponible ingredients
    Ingredient ingredients[] = {
        {"Cheese", 1.50, 1},
        {"Pepperoni", 2.00, 1},
        {"Mushrooms", 1.00, 1},
        {"Onions", 0.75, 1},
        {"Bell Peppers", 1.25, 1},
        {"Olives", 1.50, 1},
        {"Bacon", 2.50, 1},
        {"Tomato Sauce", 0.50, 1}
    };
    
    int total_ingredients = sizeof(ingredients) / sizeof(ingredients[0]);
    
    printf("====== PIZZA ORDERING SYSTEM ======\n\n");
    
    // Create a pizza order
    PizzaOrder my_pizza = create_order("My Custom Pizza", ingredients, total_ingredients);
    
    // Display the order
    display_order(my_pizza);
    
    return 0;
}
