#include <stdio.h>
#include <string.h>

#define MAXARTICLES 100
#define MAXNOM 50

typedef struct {
    int num_referencia;
    char nom[MAXNOM];
    float preu;
    int quantitat;
} Tarticle;

// Declaració de funcions
void mostrar_menu();
void llistar_articles(Tarticle articles[], int qt_articles);
int cercar_article(Tarticle articles[], int qt_articles, int ref);
void mostrar_article(Tarticle articles[], int qt_articles);
void modificar_article(Tarticle articles[], int qt_articles);
void esborrar_article(Tarticle articles[], int *qt_articles);
void alta_article(Tarticle articles[], int *qt_articles);
void llegir_article_teclat(Tarticle *a);

int main() {
    Tarticle articles[MAXARTICLES] = {
        {123, "Cargols fusta 3mm", 1.34, 1200},
        {154, "Arandeles plastiques 2mm", 1.45, 102},
        {144, "Pegament ultramax", 4.32, 102},
        {167, "Pintura base delux", 10.50, 55},
        {208, "Broca fusta 14mm", 3.61, 66}
    };
    int qt_articles = 5;
    char opcio;
    
    do {
        mostrar_menu();
        printf("Selecciona una opcio: ");
        scanf(" %c", &opcio);
        
        switch(opcio) {
            case 'A':
            case 'a':
                llistar_articles(articles, qt_articles);
                break;
            case 'B':
            case 'b':
                alta_article(articles, &qt_articles);
                break;
            case 'C':
            case 'c':
                modificar_article(articles, qt_articles);
                break;
            case 'D':
            case 'd':
                mostrar_article(articles, qt_articles);
                break;
            case 'E':
            case 'e':
                esborrar_article(articles, &qt_articles);
                break;
            case 'F':
            case 'f':
                printf("\nFi del programa. Adeu!\n");
                break;
            default:
                printf("\nOpcio no valida. Torna-ho a intentar.\n");
        }
        
        if(opcio != 'F' && opcio != 'f') {
            printf("\nPrem ENTER per continuar...");
            getchar();
            getchar();
        }
        
    } while(opcio != 'F' && opcio != 'f');
    
    return 0;
}

void mostrar_menu() {
    printf("\n\n");
    printf("MENU PRINCIPAL\n");
    printf("A) Llistar tots els articles\n");
    printf("B) Alta d'un article\n");
    printf("C) Modificar article per num. de referencia\n");
    printf("D) Mostrar article per num. de referencia\n");
    printf("E) Esborrar article per num de referencia\n");
    printf("F) Fi\n");
}

int cercar_article(Tarticle articles[], int qt_articles, int ref) {
    int i;
    for(i = 0; i < qt_articles; i++) {
        if(articles[i].num_referencia == ref) {
            return i;  // Retorna la posició on s'ha trobat
        }
    }
    return -1;  // No s'ha trobat
}

void llistar_articles(Tarticle articles[], int qt_articles) {
    int i;
    
    printf("\n");
    printf("Llista d'articles\n");
    printf("Pos  Num. ref  Nom                          Preu   Quantitat\n");
    
    for(i = 0; i < qt_articles; i++) {
        printf("%-4d %-9d %-28s %6.2f %9d\n", 
               i+1, 
               articles[i].num_referencia, 
               articles[i].nom, 
               articles[i].preu, 
               articles[i].quantitat);
    }
}

void alta_article(Tarticle articles[], int *qt_articles) {
    Tarticle nou_article;
    int ref, posicio;
    
    printf("\n");
    printf("Alta d'article\n");
    
    if(*qt_articles >= MAXARTICLES) {
        printf("Error: No es poden afegir mes articles. Catàleg ple.\n");
        return;
    }
    
    printf("Introdueix numero de referencia: ");
    scanf("%d", &ref);
    
    posicio = cercar_article(articles, *qt_articles, ref);
    
    if(posicio != -1) {
        printf("Error: Ja existeix un article amb aquesta referencia.\n");
        return;
    }
    
    nou_article.num_referencia = ref;
    printf("Introdueix nom: ");
    scanf(" %[^\n]", nou_article.nom);
    printf("Introdueix preu: ");
    scanf("%f", &nou_article.preu);
    printf("Introdueix quantitat: ");
    scanf("%d", &nou_article.quantitat);
    
    articles[*qt_articles] = nou_article;
    (*qt_articles)++;
    
    printf("\nArticle donat d'alta correctament.\n");
}

void llegir_article_teclat(Tarticle *a) {
    printf("Introdueix numero de referencia: ");
    scanf("%d", &a->num_referencia);
    printf("Introdueix nom: ");
    scanf(" %[^\n]", a->nom);
    printf("Introdueix preu: ");
    scanf("%f", &a->preu);
    printf("Introdueix quantitat: ");
    scanf("%d", &a->quantitat);
}

void modificar_article(Tarticle articles[], int qt_articles) {
    int ref, posicio;
    
    printf("\n");
    llistar_articles(articles, qt_articles);
    
    printf("\n");
    printf("Modificacio d'article per num de referencia\n");
    printf("Quin article vols modificar? ");
    scanf("%d", &ref);
    
    posicio = cercar_article(articles, qt_articles, ref);
    
    if(posicio == -1) {
        printf("Article no trobat.\n");
        return;
    }
    
    llegir_article_teclat(&articles[posicio]);
    
    printf("\nArticle modificat correctament.\n");
}

void mostrar_article(Tarticle articles[], int qt_articles) {
    int ref, posicio;
    
    printf("\n");
    printf("Cerca d'article per num de referencia\n");
    printf("Introduir numero de referencia: ");
    scanf("%d", &ref);
    
    posicio = cercar_article(articles, qt_articles, ref);
    
    if(posicio == -1) {
        printf("\nArticle No trobat\n");
    } else {
        printf("\nArticle Trobat\n");
        printf("Numero de referencia: %d\n", articles[posicio].num_referencia);
        printf("Nom: %s\n", articles[posicio].nom);
        printf("Preu: %.2f\n", articles[posicio].preu);
        printf("Quantitat: %d\n", articles[posicio].quantitat);
    }
}

void esborrar_article(Tarticle articles[], int *qt_articles) {
    int ref, posicio, i;
    
    printf("\n");
    printf("Eliminar article per referencia\n");
    printf("Introduir numero de referencia: ");
    scanf("%d", &ref);
    
    posicio = cercar_article(articles, *qt_articles, ref);
    
    if(posicio == -1) {
        printf("\nArticle no trobat.\n");
        return;
    }
    
    for(i = posicio; i < *qt_articles - 1; i++) {
        articles[i] = articles[i + 1];
    }
    
    (*qt_articles)--;
    
    printf("\nArticle eliminat.\n");
    llistar_articles(articles, *qt_articles);
}