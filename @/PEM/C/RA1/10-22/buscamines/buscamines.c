#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#define MAXF 20
#define MAXC 60
#define MINA 1

int qtc, qtf, tauler[MAXF][MAXC], x, y;

void main()
{
    establirDimensions();
    inicialitzarTauler();
    colocarMines();
    mostrarTauler();

    getch();
}

void establirDimensions()
{
    do
  {
    system("cls");
    printf("Introdueix la quantitat desitjada de columnes (5-60) i files (5-20)al tauler (C F): ");
    scanf("%d %d", &qtc, &qtf);
  }
    while (!(qtf >= 5 && qtf <= MAXF && qtc >= 5 && qtc <= MAXC));
    {
        printf("Valor Illegal. Prova un altre valor: ");
        scanf("%d %d", &qtc, &qtf);
    }
}

void inicialitzarTauler(){
    int i, j;

    for (i = 0; i < qtf; i++)
    {
        for (j = 0; j < qtc; j++)
        {
            tauler[i][j] = 0;
        }
    }
}

void colocarMines()
{
    int minesColocar = qtf * qtc * 0.20;
    int minesColocades = 0;
    srand(time(NULL));

    while (minesColocades < minesColocar)
    {
        int f = rand()%qtf;
        int c = rand()%qtc;

        if (tauler[f][c] != MINA)
        {
            tauler[f][c] = MINA;
            minesColocades++;
        }

    }
}

void mostrarTauler()
{
    int i, j;

    x = 40 - qtf/2;
    y = 12 - qtc/2;

    system("cls");

    for (i = 0; i < qtf; i++)
    {
        for (j = 0; j < qtc; j++)
        {
            if (tauler[i][j] == MINA)
            {
                printf(" 1 ");
            }
        }
        printf("\n");
    }
}
