

#include <stdio.h>

void main()

 {

      // Amb 'float' em donava mides incorrectes, ho he preguntat i m'han recomanat fer-ho amb 'double'.
      double amp, longitud, area;

      // M'ha tocat mirar que hauría d'utilitzar en comptes de %s o %d.
      printf("Introdueix l'amplada de l'habitacio (en metres): ");
      scanf("%lf", &amp);

      printf("Introdueix la longitud de l'habitacio (en metres): ");
      scanf("%lf", &longitud);

      // També m'ha tocat buscar la formula de regla de 3 per trobar l'area d'un perímetre als meus 18 anys, si. No he canviat d'un exercici a l'altre, segueixo sent idiota.
      area = amp * longitud;

      // Ah si, abans de que preguntis, he buscat cóm expressar el resultat en cas de que aquest sigui decimal. El meu cap no dona per més.
      printf("L'àrea de l'habitacio es de: %.4lf metres quadrats.\n", area);

      getch();

 }





