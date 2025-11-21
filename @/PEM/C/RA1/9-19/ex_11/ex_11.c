#include <stdio.h>

//Anava a demanar ajuda a ChatGPT c�m una ovella m�s del ramat per� he preferit preguntar-li a un ser hum� real a StackOverflow, no m'en arrepenteixo i així ho faré durant les pràctiques.
//M'han recomenat utilitzar 'int main' en comptes de 'void main', però així s'entén.
void main()

 {
    //Em repetiré molt als comentaris: "I si així funciona millor no tocar-ho = SAFMNT"
    //No estic segur si hauría d'haver declarat els nombres amb 'float' aqui sota, però, cóm encara no sabía fer-ho no ho he fet, i bueno, SAFMNT.
    int n;
    
    printf("Introdueix un nombre, t'el multiplico per 2 i t'el fico al quadrat");

    //M'ha tocat preguntar a StackOverflow la difer�ncia entre %s i %d, finalment ho he ent�s (m�s o menys)...
    scanf("%d", &n);

    //Tamb� he preguntat aix�, per� no vaig trobar una soluci� de codi. S'em havia oblidat canviar el meu chip de X a * per multiplicar. Soc idiota.
    int multiplicatPer2 = n * 2;
    int alQuadrat = n * n;

    //StackOveflow > ChatGPT
    printf("Nombre multiplicat per 2 = %d\n", multiplicatPer2);
    printf("Nombre al quadrat = %d\n", alQuadrat);

    //Aquí m'han recomenat acabar amb 'return' en comptes de 'getch', però així s'entén millor, SAFMNT.
    getch();

 }
