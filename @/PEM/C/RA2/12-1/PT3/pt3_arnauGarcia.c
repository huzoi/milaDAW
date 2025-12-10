#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include "data.h"

#define MAXALUMNES 30
#define MAXNOM 50
#define MAXDNI 10
#define SORTIR 'd'

typedef struct alumne{
    char nom[MAXNOM];
    char dni[MAXDNI];
    Tdata data_naixement;
    float nota_prova_inicial;
}Talumne;

void ini_variables(Talumne alumnes[], int *qt_alumnes);
void mostrar_menu();
char llegir_opcio();
void tractar_opcio(char opcio, Talumne alumnes[], int *qt_alumnes);
void alta_alumne(Talumne alumnes[], int *qt_alumnes);
int cercar_alumne_dni(Talumne alumnes[], int qt_alumnes, char dni[]);
void consulta_dni(Talumne alumnes[], int qt_alumnes);
void dies_aniversari(Talumne alumnes[], int qt_alumnes);
int calcular_dies_aniversari(Tdata data_naixement);

int main(){
    Talumne alumnes[MAXALUMNES];
    int qt_alumnes;
    char opcio;
    
    ini_variables(alumnes, &qt_alumnes);
    
    do{
        mostrar_menu();
        opcio = llegir_opcio();
        tractar_opcio(opcio, alumnes, &qt_alumnes);
        
        if(opcio != SORTIR){
            printf("\nPrem ENTER per continuar...");
            getchar();
            getchar();
        }
    }while(opcio != SORTIR);
    
    return 0;
}

void ini_variables(Talumne alumnes[], int *qt_alumnes){
    *qt_alumnes = 0;
}

void mostrar_menu(){
    printf("\n\n");
    printf("MENU PRINCIPAL - Gestio d'Alumnes\n");
    printf("a) Alta d'un alumne\n");
    printf("b) Consulta per DNI\n");
    printf("c) Anys i anys per molts anys\n");
    printf("d) Sortir\n");
}

char llegir_opcio(){
    char opcio;
    printf("\nSelecciona una opcio: ");
    scanf(" %c", &opcio);
    return opcio;
}

void tractar_opcio(char opcio, Talumne alumnes[], int *qt_alumnes){
    switch(opcio){
        case 'a':
        case 'A':
            alta_alumne(alumnes, qt_alumnes);
            break;
        case 'b':
        case 'B':
            consulta_dni(alumnes, *qt_alumnes);
            break;
        case 'c':
        case 'C':
            dies_aniversari(alumnes, *qt_alumnes);
            break;
        case 'd':
        case 'D':
            printf("\nFi del programa. Adeu!\n");
            break;
        default:
            printf("\nOpcio no valida.\n");
    }
}

int cercar_alumne_dni(Talumne alumnes[], int qt_alumnes, char dni[]){
    int i;
    for(i = 0; i < qt_alumnes; i++){
        if(strcmp(alumnes[i].dni, dni) == 0){
            return i;
        }
    }
    return -1;
}

void alta_alumne(Talumne alumnes[], int *qt_alumnes){
    Talumne nou_alumne;
    int posicio;
    
    printf("\n");
    printf("Alta d'alumne\n");
    
    if(*qt_alumnes >= MAXALUMNES){
        printf("Error: No es poden afegir mes alumnes. Grup ple.\n");
        return;
    }
    
    printf("Introdueix DNI: ");
    scanf(" %[^\n]", nou_alumne.dni);
    
    posicio = cercar_alumne_dni(alumnes, *qt_alumnes, nou_alumne.dni);
    
    if(posicio != -1){
        printf("Error: Ja existeix un alumne amb aquest DNI.\n");
        return;
    }
    
    printf("Introdueix nom: ");
    scanf(" %[^\n]", nou_alumne.nom);
    
    printf("Data de naixement:\n");
    llegirdata(&nou_alumne.data_naixement);
    
    printf("Introdueix nota prova inicial: ");
    scanf("%f", &nou_alumne.nota_prova_inicial);
    
    alumnes[*qt_alumnes] = nou_alumne;
    (*qt_alumnes)++;
    
    printf("\nAlumne donat d'alta correctament.\n");
}

void consulta_dni(Talumne alumnes[], int qt_alumnes){
    char dni[MAXDNI];
    int posicio;
    
    printf("\n");
    printf("Consulta per DNI\n");
    printf("Introdueix DNI: ");
    scanf(" %[^\n]", dni);
    
    posicio = cercar_alumne_dni(alumnes, qt_alumnes, dni);
    
    if(posicio == -1){
        printf("\nAlumne no trobat.\n");
    }
    else{
        printf("\nAlumne trobat:\n");
        printf("Nom: %s\n", alumnes[posicio].nom);
        printf("DNI: %s\n", alumnes[posicio].dni);
        printf("Data de naixement: ");
        escriuredata(alumnes[posicio].data_naixement);
        printf("\n");
        printf("Nota prova inicial: %.2f\n", alumnes[posicio].nota_prova_inicial);
    }
}

int calcular_dies_aniversari(Tdata data_naixement){
    char data_actual_str[11];
    Tdata data_actual, proper_aniversari;
    int dies_fins_aniversari;
    
    data_sistema(data_actual_str);
    cadena_a_data(data_actual_str, &data_actual);
    
    proper_aniversari.dia = data_naixement.dia;
    proper_aniversari.mes = data_naixement.mes;
    proper_aniversari.any = data_actual.any;
    
    dies_fins_aniversari = datadif(proper_aniversari, data_actual);
    
    if(dies_fins_aniversari < 0){
        proper_aniversari.any = data_actual.any + 1;
        dies_fins_aniversari = datadif(proper_aniversari, data_actual);
    }
    
    return dies_fins_aniversari;
}

void dies_aniversari(Talumne alumnes[], int qt_alumnes){
    int i, dies;
    
    printf("\n");
    printf("Dies fins al proper aniversari\n");
    printf("Nom ====== Dies\n");
    
    if(qt_alumnes == 0){
        printf("No hi ha alumnes registrats.\n");
        return;
    }
    
    for(i = 0; i < qt_alumnes; i++){
        dies = calcular_dies_aniversari(alumnes[i].data_naixement);
        printf("%-40s %d\n", alumnes[i].nom, dies);
    }
}