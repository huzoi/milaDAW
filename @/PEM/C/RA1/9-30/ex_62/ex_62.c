#include <stdio.h>


/* int main(){


int ref;
char targetaClient;
int preu = 0;

printf("Introdueix un nombre de referencia de viatge (1-3): ");
scanf("%d", &ref);
if (ref > 3){
        printf("\nValor Invalid\n");
        return 0;
    }
if (ref == 1){
    preu = 800;
    printf("\nEgipte - %d$. Te Targeta Client? (S/N): ", preu);
    scanf("%c", &targetaClient);
    if (targetaClient == 'S' || targetaClient == 's'){
        preu = preu * 0.9;
        preu = preu * 0.07;
        printf("El vostre viatge te un preu de %d$, bona sort a Egipte!", preu);
    }
       if (targetaClient == 'N' || targetaClient == 'n'){
            preu = preu * 0.9;
            preu = preu * 0.07;
            printf("El vostre viatge te un preu de %d$, bona sort a Egipte!", preu);
    }
}
if (ref == 2){
    preu = 3000;
    printf("\nJapo - %d$. Te Targeta Client? (S/N): ", preu);
    scanf("%c", &targetaClient);
    if (targetaClient == 'S' || targetaClient == 's'){
        preu = preu * 0.9;
        preu = preu * 0.07;
        printf("El vostre viatge te un preu de %d$, bona sort al Japo!", preu);
    }
       if (targetaClient == 'N' || targetaClient == 'n'){
            preu = preu * 0.9;
            preu = preu * 0.07;
            printf("El vostre viatge te un preu de %d$, bona sort al Japo!", preu);
    }
}
if (ref == 3){
    preu = 1000;
    printf("\nMexic - %d$. Te Targeta Client? (S/N): ", preu);
    scanf("%c", &targetaClient);
    if (targetaClient == 'S' || targetaClient == 's'){
        preu = preu * 0.9;
        preu = preu * 0.07;
        printf("El vostre viatge te un preu de %d$, bona sort a Mexic!", preu);
    }
       if (targetaClient == 'N' || targetaClient == 'n'){
            preu = preu * 0.9;
            preu = preu * 0.07;
            printf("El vostre viatge te un preu de %d$, bona sort a Mexic!", preu);
    }
}

getch();
} */ // Ho vaig fer així, però no em sortia, així que vaig demanar a ChatGPT que arregli el codi
     // l el va deixar així.

#include <stdio.h>

int main() {
    int ref;
    char targetaClient;
    int preu = 0;

    printf("Introdueix un nombre de referencia de viatge (1-3): ");
    scanf("%d", &ref);
    getchar();  // To consume the newline character left by scanf

    // Validate the reference number
    if (ref < 1 || ref > 3) {
        printf("\nValor Invalid\n");
        return 0;
    }

    // Determine the price and destination based on reference number
    if (ref == 1) {
        preu = 800;
        printf("\nEgipte - %d$. Te Targeta Client? (S/N): ", preu);
        scanf("%c", &targetaClient);
    } else if (ref == 2) {
        preu = 3000;
        printf("\nJapo - %d$. Te Targeta Client? (S/N): ", preu);
        scanf("%c", &targetaClient);
    } else if (ref == 3) {
        preu = 1000;
        printf("\nMexic - %d$. Te Targeta Client? (S/N): ", preu);
        scanf("%c", &targetaClient);
    }

    // Check if the user has a client card
    if (targetaClient == 'S' || targetaClient == 's') {
        preu = preu * 0.9;  // 10% discount for cardholders
        preu = preu + preu * 0.07;  // Adding 7% tax
    } else if (targetaClient == 'N' || targetaClient == 'n') {
        preu = preu + preu * 0.07;  // Adding 7% tax without discount
    }

    // Print the final price
    printf("El vostre viatge te un preu de %d$, bona sort!\n", preu);

    getch();
}
