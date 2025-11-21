#include <stdio.h>

/* Abans de posar-me a treballar, vaig preguntar per curiositat a StackOverflow cóm hauría de fer-ho
i m'han recomanat utilitzar les funcions 'struct' i 'static', que he utilitzat al codi.
Sé que potser no hauría de fer-ho així ara mateix, però he creat una funció especifica per a la conversió del temps. M'agrada ser organitzat sempre que m'ho pugui permetre */

struct conversor
{
    int hores;
    int minuts;
    int segons;
};

// Crea la funció que fará de conversor.
static void conversorTemps(int segons, struct conversor *h);

int main(void)
{
    struct conversor temps;
    int segons;

    // Demana a l'usuari que introdueixi un nombre de segons.
    printf("Inseriu el nombre de segons: ");
    if (scanf("%d", &segons) == 1)
    {
        conversorTemps(segons, &temps);
        // Mostra el resultat en HH:MM:SS.
        printf("%d segons = %d Hores, %d Minuts i %d Segons\n",
               segons, temps.hores, temps.minuts, temps.segons);
    }

    return 0;
}
// És la funció que fará de conversor.
static void conversorTemps(int segons, struct conversor *h)
{
    h->hores = segons / 3600;
    h->minuts = (segons / 60) % 60;
    h->segons = segons % 60;
}
