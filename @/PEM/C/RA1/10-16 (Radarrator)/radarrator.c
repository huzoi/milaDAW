#include <stdio.h>
#include <stdbool.h>
#include <conio.h>
#include <stdlib.h>


void menu();
void mode_aprenent();
void mode_expert();
void visualitzar_error_vtv();
int es_violacio(float vtv, float vmp);
void tractar_violacio(float vtv, float vmp, int *cont1, int *cont2, int *cont3, int *cont4, int mode, int *consecutives, int *policia, int mostrar_avisos);

int main() {
    menu();
    return 0;
}

void menu() {
    int op;
    int lectura_correcta;

    do {
        printf("\n--- MENU ---\n");
        printf("1) Mode aprenent\n");
        printf("2) Mode expert\n");
        printf("3) Visualitzar Error VTV\n");
        printf("4) Sortir\n");
        printf("Tria una opcio (1/2/3/4): ");

        lectura_correcta = scanf("%d", &op);

        if (lectura_correcta != 1) {
            printf("\nValor Invalid.\n");
            while (getchar() != '\n');
        }
        else if (op == 1) {
            clrscr();
            mode_aprenent();
        }
        else if (op == 2) {
            clrscr();
            mode_expert();
        }
        else if (op == 3) {
            clrscr();
            visualitzar_error_vtv();
        }
        else if (op == 4) {
            clrscr();
            printf("Sortint del programa.\n");
        }
        else {
            printf("\nValor Invalid.\n");
        }

    } while (op != 4);
}


void mode_aprenent() {
    float vtv, vmp;
    int cont1 = 0, cont2 = 0, cont3 = 0, cont4 = 0; // no necessàries per aprenent pero per si de cas
    int consecutives = 0;
    int policia = 0; // no s'utilitza en aprenent, pero per si de cas
    printf("\n--- Mode aprenent ---\n");

    while (1) {
        printf("Introdueix VTV i VMP (ex. 60 50). Per acabar introdueix 0 0: ");

        if (scanf("%f %f", &vtv, &vmp) != 2) {
            printf("\nValor Invalid.\n");
            continue;
        }

        if (vtv == 0.0f && vmp == 0.0f) {
            printf("Per fi hem arribat!!!\n");
            break;
        }

        if (vmp <= 0.0f) {
            printf("\nValor Invalid.\n");
            continue;
        }

        int es_violat = es_violacio(vtv, vmp);
        if (es_violat) consecutives++; else consecutives = 0;

        int mostrar_avisos = (consecutives >= 2) ? 1 : 0;

        tractar_violacio(vtv, vmp, &cont1, &cont2, &cont3, &cont4, 0, &consecutives, &policia, mostrar_avisos);
    }
}

void mode_expert() {
    float vtv, vmp;
    int cont1 = 0, cont2 = 0, cont3 = 0, cont4 = 0;
    int consecutives = 0; //no necessari per l'expert, pero per si de cas
    int policia = 0;
    printf("\n--- Mode expert ---\n");
    while (1) {
        printf("Introdueix VTV i VMP (ex. 60 50). Per acabar introdueix 0 0: ");
        if (scanf("%f %f", &vtv, &vmp) != 2) {
            int ch;
            while ((ch = getchar()) != '\n' && ch != EOF);
            printf("\nValor Invalid.\n");
            continue;
        }
        if (vtv == 0.0f && vmp == 0.0f) {
            printf("Per fi hem arribat!!!\n");
            break;
        }
        if (vmp <= 0.0f) {
            printf("\nValor Invalid.\n");
            continue;
        }
        tractar_violacio(vtv, vmp, &cont1, &cont2, &cont3, &cont4, 1, &consecutives, &policia, 1);
        if (cont2 >= 5 || cont3 >= 3 || cont4 >= 1) {
            printf("Prudència truca a la Policia !!!!\n");
            break;
        }
        if (policia) {
            printf("Prudència truca a la Policia !!!!\n");
            break;
        }
    }
}

void visualitzar_error_vtv() {
    int error;
    while (1) {
        printf("\nIntrodueix el percentatge d'error (0..20): ");
        if (scanf("%d", &error) != 1) {
            int ch;
            while ((ch = getchar()) != '\n' && ch != EOF);
            printf("\nValor Invalid.\n");
            continue;
        }
        if (error < 0 || error > 20) {
            printf("\nValor Invalid.\n");
            continue;
        }
        break;
    }
    printf("\nVelocitat Tauler Vehicle (VTV)   Velocitat Real (VR)\n");
    for (int v = 20; v <= 140; v += 10) {
        double vr = v * (1.0 - error / 100.0);
        printf("%3d\t\t\t\t%.1f\n", v, vr);
    }
}

int es_violacio(float vtv, float vmp) {
    return (vtv > vmp) ? 1 : 0;
}

void tractar_violacio(float vtv, float vmp, int *cont1, int *cont2, int *cont3, int *cont4, int mode, int *consecutives, int *policia, int mostrar_avisos) {
    if (vtv <= vmp) {
        return;
    }
    double ratio = vtv / vmp;
    if (ratio > 2.0) {
        (*cont4)++;
        if (mostrar_avisos) {
            printf("Prudència , digues-li que pari i condueix tu.\n");
        }
        return;
    }
    if (ratio > 1.5 && ratio <= 2.0) {
        (*cont3)++;
        if (mostrar_avisos) {
            printf("Isma, que sàpigues que ara tindries 4 punts menys.\n");
        }
        return;
    }
    if (ratio > 1.2 && ratio <= 1.5) {
        (*cont2)++;
        if (mostrar_avisos) {
            printf("Isma, com segueixis així ens haurem de vendre el cotxe per a pagar les multes\n");
        }
        return;
    }
    (*cont1)++;
    if (mostrar_avisos) {
        if (vmp == (int)vmp) {
            printf("Isma, afluixa, havies d'anar a %.0f.\n", vmp);
        } else {
            printf("Isma, afluixa, havies d'anar a %.2f.\n", vmp);
        }
    }
}
