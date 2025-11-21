#include <stdio.h>
#define MAXNOM 30
#define MAXAUTOR 10
typedef struct t_data
{
    int dataPub, dataImp;
}t_data;

typedef struct t_fitxa
{
    int id, ed, pagNum;
    char title[MAXNOM];
    char auth[MAXNOM][MAXAUTOR];
    char edit[MAXNOM];
}t_fitxa;

void main()
{
    t_fitxa s1;
    t_data s2;

    printf("Title: ");
    scanf("%s", s1.title);

    printf("ID: ");
    scanf("%d", &s1.id);

    printf("Ed: ");
    scanf("%d", &s1.ed);

    printf("Auth: ");
    scanf("%s", s1.auth);

    printf("Edit: ");
    scanf("%s", s1.edit);

    printf("pagNum: ");
    scanf("%d", &s1.pagNum);

    printf("dataPub [DD/MM/YYYY]: ");
    scanf("%d", &s2.dataPub);

    printf("dataImp [DD/MM/YYYY]: ");
    scanf("%d", &s2.dataImp);

    printf("Titol: %s\nID: %d\nEdicio: %d\nAutor/s: %s\nEditorial: %s\nNombre de Pagines: %d\nData de Publicacio: %d\nData d'Impressio: %d\n\n",
    s1.title, s1.id, s1.ed, s1.auth, s1.edit, s1.pagNum, s2.dataPub, s2.dataImp);

    return;
}
