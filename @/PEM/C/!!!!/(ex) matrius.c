#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#define MAXC 5
#define MAXF 5


void main()
{
    int fil, col, m[MAXC][MAXF], x, y;

    for (fil = 0; fil < MAXF; fil++)
    {
        for (col = 0; col < MAXC; col++)
        {
            m[fil][col] = rand()%2;
        }
    }

    x = 40 - MAXC/2; y = 12 - MAXF/2;
    for (fil = 0; fil < MAXF; fil++)
    {
        for (col = 0; col < MAXC; col++)
        {
            gotoxy(x + col, y + fil);
            printf("%d", m[fil][col]);
        }
    }
    getch();
}
