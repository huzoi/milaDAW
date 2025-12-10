#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>
#include <time.h>

#define MAXCOMANDES 1000
#define MAXPIGJES_COMANDA 10
#define MAXNOM 50
#define MAXADRECA 100
#define MAXPOBLACIO 50
#define MAXTELEFON 15
#define NUMPIGJES 8

typedef struct {
    char nom[MAXNOM];
    float preu;
} Tpigja;

typedef struct {
    char nom_client[MAXNOM];
    int taula;
    char adreca[MAXADRECA];
    char poblacio[MAXPOBLACIO];
    char telefon[MAXTELEFON];
    int pigjes_escollides[MAXPIGJES_COMANDA];
    int num_pigjes;
    bool cuinada;
    float preu_total;
} Tcomanda;

void inicialitzar_carta(Tpigja carta[]);
void mostrar_menu();
void alta_comanda(Tcomanda comandes[], int *num_comandes, Tpigja carta[]);
void cuinar_comanda(Tcomanda comandes[], int num_comandes);
void consulta_comanda_premiada(Tcomanda comandes[], int num_comandes);
void consulta_comanda_mes_cara(Tcomanda comandes[], int num_comandes);
int calcular_suma_ascii(char poblacio[]);
void mostrar_carta(Tpigja carta[]);

int main() {
    Tcomanda comandes[MAXCOMANDES];
    Tpigja carta[NUMPIGJES];
    int num_comandes = 0;
    char opcio;
    
    srand(time(NULL));
    inicialitzar_carta(carta);
    
    do {
        mostrar_menu();
        printf("\nSelecciona una opcio: ");
        scanf(" %c", &opcio);
        
        switch(opcio) {
            case 'a':
            case 'A':
                alta_comanda(comandes, &num_comandes, carta);
                break;
            case 'b':
            case 'B':
                cuinar_comanda(comandes, num_comandes);
                break;
            case 'c':
            case 'C':
                consulta_comanda_premiada(comandes, num_comandes);
                break;
            case 'd':
            case 'D':
                consulta_comanda_mes_cara(comandes, num_comandes);
                break;
            case 'e':
            case 'E':
                printf("\nFi del programa. Gracies!\n");
                break;
            default:
                printf("\nOpcio no valida.\n");
        }
        
        if(opcio != 'e' && opcio != 'E') {
            printf("\nPrem ENTER per continuar...");
            getchar();
            getchar();
        }
        
    } while(opcio != 'e' && opcio != 'E');
    
    return 0;
}

void inicialitzar_carta(Tpigja carta[]) {
    strcpy(carta[0].nom, "Pigja Cachonda");
    carta[0].preu = 60.0;
    
    strcpy(carta[1].nom, "Pigja Funebre");
    carta[1].preu = 75.0;
    
    strcpy(carta[2].nom, "Pigja Aromatica");
    carta[2].preu = 40.0;
    
    strcpy(carta[3].nom, "Pigja Primavera");
    carta[3].preu = 30.0;
    
    strcpy(carta[4].nom, "Pigja De4potes");
    carta[4].preu = 60.0;
    
    strcpy(carta[5].nom, "Pigja Orelluda");
    carta[5].preu = 40.0;
    
    strcpy(carta[6].nom, "Pija Luxuri Blank&White");
    carta[6].preu = 300.0;
    
    strcpy(carta[7].nom, "Pigja Rodoli");
    carta[7].preu = 50.0;
}

void mostrar_menu() {
    printf("\n\n");
    printf("PIGJERIA THE NEW BOOLLEET\n");
    printf("a) Alta de comanda\n");
    printf("b) Cuinar comanda\n");
    printf("c) Consulta comanda premiada\n");
    printf("d) Consulta comanda mes cara\n");
    printf("e) Sortir\n");
}

void mostrar_carta(Tpigja carta[]) {
    int i;
    printf("\n");
    printf("CARTA DE PIGJES\n");
    for(i = 0; i < NUMPIGJES; i++) {
        printf("%d. %s (%.2f euros)\n", i+1, carta[i].nom, carta[i].preu);
    }
}

void alta_comanda(Tcomanda comandes[], int *num_comandes, Tpigja carta[]) {
    Tcomanda nova;
    int i, opcio;
    
    printf("\n");
    printf("ALTA DE COMANDA\n");
    
    if(*num_comandes >= MAXCOMANDES) {
        printf("Error: No es poden afegir mes comandes.\n");
        return;
    }
    
    printf("Nom del client: ");
    scanf(" %[^\n]", nova.nom_client);
    
    printf("Numero de taula: ");
    scanf("%d", &nova.taula);
    
    printf("Adreca: ");
    scanf(" %[^\n]", nova.adreca);
    
    printf("Poblacio: ");
    scanf(" %[^\n]", nova.poblacio);
    
    printf("Telefon: ");
    scanf(" %[^\n]", nova.telefon);
    
    mostrar_carta(carta);
    
    printf("\nQuantes pigjes vol demanar (max %d)? ", MAXPIGJES_COMANDA);
    scanf("%d", &nova.num_pigjes);
    
    if(nova.num_pigjes < 1 || nova.num_pigjes > MAXPIGJES_COMANDA) {
        printf("Error: Nombre de pigjes no valid.\n");
        return;
    }
    
    nova.preu_total = 0;
    for(i = 0; i < nova.num_pigjes; i++) {
        printf("Pigja %d (1-%d): ", i+1, NUMPIGJES);
        scanf("%d", &opcio);
        
        if(opcio < 1 || opcio > NUMPIGJES) {
            printf("Error: Opcio no valida.\n");
            i--;
            continue;
        }
        
        nova.pigjes_escollides[i] = opcio - 1;
        nova.preu_total += carta[opcio - 1].preu;
    }
    
    nova.cuinada = false;
    
    comandes[*num_comandes] = nova;
    (*num_comandes)++;
    
    printf("\nComanda donada d'alta correctament.\n");
    printf("Preu total: %.2f euros\n", nova.preu_total);
}

void cuinar_comanda(Tcomanda comandes[], int num_comandes) {
    int i, j;
    bool trobada = false;
    
    printf("\n");
    printf("CUINAR COMANDA\n");
    
    if(num_comandes == 0) {
        printf("No hi ha comandes.\n");
        return;
    }
    
    for(i = 0; i < num_comandes; i++) {
        if(!comandes[i].cuinada) {
            printf("\nClient: %s\n", comandes[i].nom_client);
            printf("Pigjes a cuinar:\n");
            
            Tpigja carta[NUMPIGJES];
            inicialitzar_carta(carta);
            
            for(j = 0; j < comandes[i].num_pigjes; j++) {
                printf("  - %s\n", carta[comandes[i].pigjes_escollides[j]].nom);
            }
            
            comandes[i].cuinada = true;
            printf("\nComanda cuinada!\n");
            trobada = true;
            break;
        }
    }
    
    if(!trobada) {
        printf("No hi ha mes comandes pendents de cuinar.\n");
    }
}

int calcular_suma_ascii(char poblacio[]) {
    int suma = 0;
    int i;
    
    for(i = 0; i < strlen(poblacio); i++) {
        suma += (int)poblacio[i];
    }
    
    return suma;
}

void consulta_comanda_premiada(Tcomanda comandes[], int num_comandes) {
    int i, comanda_aleatoria, suma_ascii, ultim_digit;
    char poblacio_seleccionada[MAXPOBLACIO];
    char ultim_digit_tel;
    bool premiat_trobat = false;
    int intent = 0;
    
    printf("\n");
    printf("CONSULTA COMANDA PREMIADA\n");
    
    if(num_comandes == 0) {
        printf("No hi ha comandes.\n");
        return;
    }
    
    while(!premiat_trobat && intent < 1000) {
        comanda_aleatoria = rand() % num_comandes;
        strcpy(poblacio_seleccionada, comandes[comanda_aleatoria].poblacio);
        
        suma_ascii = calcular_suma_ascii(poblacio_seleccionada);
        ultim_digit = suma_ascii % 10;
        
        printf("\nPoblacio seleccionada: %s\n", poblacio_seleccionada);
        printf("Suma ASCII: %d\n", suma_ascii);
        printf("Ultim digit: %d\n", ultim_digit);
        
        for(i = 0; i < num_comandes; i++) {
            if(strcmp(comandes[i].poblacio, poblacio_seleccionada) == 0) {
                ultim_digit_tel = comandes[i].telefon[strlen(comandes[i].telefon) - 1];
                
                if((ultim_digit_tel - '0') == ultim_digit) {
                    printf("\n*** GUANYADOR TROBAT ***\n");
                    printf("Client: %s\n", comandes[i].nom_client);
                    printf("Telefon: %s\n", comandes[i].telefon);
                    premiat_trobat = true;
                    break;
                }
            }
        }
        
        if(!premiat_trobat) {
            printf("No s'ha trobat guanyador, recalculant...\n");
            intent++;
        }
    }
    
    if(!premiat_trobat) {
        printf("\nNo s'ha pogut trobar cap guanyador.\n");
    }
}

void consulta_comanda_mes_cara(Tcomanda comandes[], int num_comandes) {
    int i;
    float preu_maxim = 0;
    
    printf("\n");
    printf("CONSULTA COMANDA MES CARA\n");
    
    if(num_comandes == 0) {
        printf("No hi ha comandes.\n");
        return;
    }
    
    for(i = 0; i < num_comandes; i++) {
        if(comandes[i].preu_total > preu_maxim) {
            preu_maxim = comandes[i].preu_total;
        }
    }
    
    printf("\nPreu de la comanda mes cara: %.2f euros\n", preu_maxim);
    printf("\nClients amb aquesta comanda:\n");
    
    for(i = 0; i < num_comandes; i++) {
        if(comandes[i].preu_total == preu_maxim) {
            printf("  - %s (Taula %d)\n", comandes[i].nom_client, comandes[i].taula);
        }
    }
}