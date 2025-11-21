#include <stdio.h>
#include <string.h>

// Struct for ingredients
typedef struct {
    char name[50];
    float price;
    int available;
} Ingredient;

// Struct for pizza order
typedef struct {
    char pizza_name[100];
    Ingredient ingredients[10];
    int ingredient_count;
    float total_price;
} PizzaOrder;

// Function to create a pizza order
PizzaOrder create_order(char *name, Ingredient available_ingredients[], int total_ingredients) {
    PizzaOrder order;
    strcpy(order.pizza_name, name);
    order.ingredient_count = 0;
    order.total_price = 0.0;
    
    printf("\n=== Creating Order: %s ===\n", name);
    printf("Available ingredients:\n");
    
    // Display available ingredients
    for (int i = 0; i < total_ingredients; i++) {
        printf("%d. %s - $%.2f\n", i + 1, available_ingredients[i].name, available_ingredients[i].price);
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
        if (available_ingredients[index].available) {
            order.ingredients[order.ingredient_count] = available_ingredients[index];
            order.total_price += available_ingredients[index].price;
            order.ingredient_count++;
            printf("Added %s\n", available_ingredients[index].name);
        } else {
            printf("%s is not available!\n", available_ingredients[index].name);
        }
    }
    
    return order;
}

// Function to display order summary
void display_order(PizzaOrder order) {
    printf("\n=== Order Summary ===\n");
    printf("Pizza: %s\n", order.pizza_name);
    printf("Ingredients:\n");
    
    for (int i = 0; i < order.ingredient_count; i++) {
        printf("  - %s ($%.2f)\n", order.ingredients[i].name, order.ingredients[i].price);
    }
    
    printf("Total Price: $%.2f\n", order.total_price);
    printf("====================\n\n");
}

// Main function
int main() {
    // Initialize available ingredients
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
