// M'he ajudat d'IA per automatitzar els printfs (sent realista, l'art de fer printfs bonics no es lo meu).

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAX_NOM 50
#define MAX_PARTIDES 3
#define TOP_TEN 10

typedef struct {
    int dia, mes, any;
} Tdata;

typedef struct {
    int id_matricula;
    char nomdeguerra[MAX_NOM];
    char sexe;
    int cicle;
    int partidesjugades;
} Tparticipant;

typedef struct {
    int id_matricula;
    Tdata data;
    int duradapartida;
} Tpartida;

typedef struct {
    char nomdeguerra[MAX_NOM];
    int duradapartida;
    Tdata data;
} Trecord;

void llegir_data(Tdata *data) {
    printf("Dia: ");
    scanf("%d", &data->dia);
    printf("Mes: ");
    scanf("%d", &data->mes);
    printf("Any: ");
    scanf("%d", &data->any);
}

void mostrar_data(Tdata data) {
    printf("%02d/%02d/%04d", data.dia, data.mes, data.any);
}

int participant_existeix(int id_matricula, char *nomdeguerra) {
    FILE *f;
    Tparticipant p;
    
    f = fopen("participants.dat", "rb");
    if (f == NULL) return 0;
    
    while (fread(&p, sizeof(p), 1, f) == 1) {
        if (p.id_matricula == id_matricula || strcmp(p.nomdeguerra, nomdeguerra) == 0) {
            fclose(f);
            return 1;
        }
    }
    
    fclose(f);
    return 0;
}

void alta_participant() {
    FILE *f;
    Tparticipant p;
    
    printf("\n=== ALTA PARTICIPANT ===\n");
    
    printf("ID matrícula: ");
    scanf("%d", &p.id_matricula);
    getchar();
    
    printf("Nom de guerra: ");
    fgets(p.nomdeguerra, MAX_NOM, stdin);
    p.nomdeguerra[strcspn(p.nomdeguerra, "\n")] = '\0';
    
    if (participant_existeix(p.id_matricula, p.nomdeguerra)) {
        printf("\nError: El participant ja està inscrit!\n");
        return;
    }
    
    printf("Sexe (H/D): ");
    scanf(" %c", &p.sexe);
    
    printf("Cicle: ");
    scanf("%d", &p.cicle);
    
    p.partidesjugades = 0;
    
    f = fopen("participants.dat", "ab");
    if (f == NULL) {
        printf("Error obrint l'arxiu\n");
        return;
    }
    
    fwrite(&p, sizeof(p), 1, f);
    fclose(f);
    
    printf("\nParticipant inscrit correctament!\n");
}

Tparticipant* buscar_participant(int id_matricula) {
    FILE *f;
    static Tparticipant p;
    
    f = fopen("participants.dat", "rb");
    if (f == NULL) return NULL;
    
    while (fread(&p, sizeof(p), 1, f) == 1) {
        if (p.id_matricula == id_matricula) {
            fclose(f);
            return &p;
        }
    }
    
    fclose(f);
    return NULL;
}

void actualitzar_partides_jugades(int id_matricula) {
    FILE *f;
    Tparticipant p;
    
    f = fopen("participants.dat", "r+b");
    if (f == NULL) return;
    
    while (fread(&p, sizeof(p), 1, f) == 1) {
        if (p.id_matricula == id_matricula) {
            p.partidesjugades++;
            fseek(f, -1*sizeof(p), SEEK_CUR);
            fwrite(&p, sizeof(p), 1, f);
            fseek(f, 0, SEEK_CUR);
            break;
        }
    }
    
    fclose(f);
}

int comptar_records() {
    FILE *f;
    Trecord r;
    int count = 0;
    
    f = fopen("records.dat", "rb");
    if (f == NULL) return 0;
    
    while (fread(&r, sizeof(r), 1, f) == 1) {
        count++;
    }
    
    fclose(f);
    return count;
}

void inserir_record(char *nomdeguerra, int durada, Tdata data) {
    FILE *f;
    Trecord records[TOP_TEN + 1];
    int num_records = 0;
    int i, j;
    
    f = fopen("records.dat", "rb");
    if (f != NULL) {
        while (fread(&records[num_records], sizeof(Trecord), 1, f) == 1 && num_records < TOP_TEN) {
            num_records++;
        }
        fclose(f);
    }
    
    strcpy(records[num_records].nomdeguerra, nomdeguerra);
    records[num_records].duradapartida = durada;
    records[num_records].data = data;
    num_records++;
    
    for (i = 0; i < num_records - 1; i++) {
        for (j = i + 1; j < num_records; j++) {
            if (records[i].duradapartida < records[j].duradapartida) {
                Trecord temp = records[i];
                records[i] = records[j];
                records[j] = temp;
            }
        }
    }
    
    if (num_records > TOP_TEN) {
        num_records = TOP_TEN;
    }
    
    f = fopen("records.dat", "wb");
    if (f != NULL) {
        fwrite(records, sizeof(Trecord), num_records, f);
        fclose(f);
    }
}

int es_top_ten(int durada) {
    FILE *f;
    Trecord r;
    int count = 0;
    int min_durada = 0;
    
    f = fopen("records.dat", "rb");
    if (f == NULL) return 1;
    
    while (fread(&r, sizeof(r), 1, f) == 1) {
        count++;
        if (count == 1 || r.duradapartida < min_durada) {
            min_durada = r.duradapartida;
        }
    }
    
    fclose(f);
    
    if (count < TOP_TEN) return 1;
    
    return (durada > min_durada);
}

void jugar_partida() {
    FILE *f;
    Tpartida partida;
    Tparticipant *p;
    
    printf("\n=== JUGAR PARTIDA ===\n");
    
    printf("ID matrícula: ");
    scanf("%d", &partida.id_matricula);
    
    p = buscar_participant(partida.id_matricula);
    
    if (p == NULL) {
        printf("\nError: El participant no està inscrit!\n");
        return;
    }
    
    if (p->partidesjugades >= MAX_PARTIDES) {
        printf("\nError: Ja has jugat el màxim de %d partides!\n", MAX_PARTIDES);
        return;
    }
    
    printf("\nData de la partida:\n");
    llegir_data(&partida.data);
    
    printf("Durada de la partida (segons): ");
    scanf("%d", &partida.duradapartida);
    
    f = fopen("partides.dat", "ab");
    if (f == NULL) {
        printf("Error obrint l'arxiu\n");
        return;
    }
    
    fwrite(&partida, sizeof(partida), 1, f);
    fclose(f);
    
    actualitzar_partides_jugades(partida.id_matricula);
    
    if (es_top_ten(partida.duradapartida)) {
        printf("\n¡FELICITATS! Estàs al TOP TEN!\n");
        inserir_record(p->nomdeguerra, partida.duradapartida, partida.data);
    }
    
    printf("\nPartida registrada correctament!\n");
    printf("Partides jugades: %d/%d\n", p->partidesjugades + 1, MAX_PARTIDES);
}

void generar_millors_per_sexe() {
    FILE *f_records, *f_participants, *f_topman, *f_topwoman;
    Trecord r;
    Tparticipant p;
    int trobat;
    
    printf("\n=== GENERAR MILLORS PER SEXE ===\n");
    
    f_records = fopen("records.dat", "rb");
    if (f_records == NULL) {
        printf("Error: No hi ha records!\n");
        return;
    }
    
    f_topman = fopen("topman.dat", "wb");
    f_topwoman = fopen("topwoman.dat", "wb");
    
    if (f_topman == NULL || f_topwoman == NULL) {
        printf("Error creant arxius\n");
        if (f_topman) fclose(f_topman);
        if (f_topwoman) fclose(f_topwoman);
        fclose(f_records);
        return;
    }
    
    while (fread(&r, sizeof(r), 1, f_records) == 1) {
        f_participants = fopen("participants.dat", "rb");
        trobat = 0;
        
        while (fread(&p, sizeof(p), 1, f_participants) == 1) {
            if (strcmp(p.nomdeguerra, r.nomdeguerra) == 0) {
                if (p.sexe == 'H' || p.sexe == 'h') {
                    fwrite(&p, sizeof(p), 1, f_topman);
                } else if (p.sexe == 'D' || p.sexe == 'd') {
                    fwrite(&p, sizeof(p), 1, f_topwoman);
                }
                trobat = 1;
                break;
            }
        }
        
        fclose(f_participants);
    }
    
    fclose(f_records);
    fclose(f_topman);
    fclose(f_topwoman);
    
    printf("Arxius generats: topman.dat i topwoman.dat\n");
}

void llistar_participants() {
    FILE *f;
    Tparticipant p;
    
    printf("\n=== LLISTAT DE PARTICIPANTS ===\n");
    
    f = fopen("participants.dat", "rb");
    if (f == NULL) {
        printf("No hi ha participants\n");
        return;
    }
    
    printf("%-10s %-20s %-5s %-6s %-10s\n", "ID", "Nom Guerra", "Sexe", "Cicle", "Partides");
    printf("----------------------------------------------------------------\n");
    
    while (fread(&p, sizeof(p), 1, f) == 1) {
        printf("%-10d %-20s %-5c %-6d %-10d\n", 
               p.id_matricula, p.nomdeguerra, p.sexe, p.cicle, p.partidesjugades);
    }
    
    fclose(f);
}

void llistar_partides() {
    FILE *f;
    Tpartida p;
    
    printf("\n=== LLISTAT DE PARTIDES ===\n");
    
    f = fopen("partides.dat", "rb");
    if (f == NULL) {
        printf("No hi ha partides\n");
        return;
    }
    
    printf("%-10s %-12s %-10s\n", "ID", "Data", "Durada(s)");
    printf("----------------------------------------\n");
    
    while (fread(&p, sizeof(p), 1, f) == 1) {
        printf("%-10d ", p.id_matricula);
        mostrar_data(p.data);
        printf(" %-10d\n", p.duradapartida);
    }
    
    fclose(f);
}

void llistar_records() {
    FILE *f;
    Trecord r;
    int posicio = 1;
    
    printf("\n=== TOP TEN RECORDS ===\n");
    
    f = fopen("records.dat", "rb");
    if (f == NULL) {
        printf("No hi ha records\n");
        return;
    }
    
    printf("%-5s %-20s %-12s %-10s\n", "Pos", "Nom Guerra", "Data", "Durada(s)");
    printf("----------------------------------------------------\n");
    
    while (fread(&r, sizeof(r), 1, f) == 1) {
        printf("%-5d %-20s ", posicio++, r.nomdeguerra);
        mostrar_data(r.data);
        printf(" %-10d\n", r.duradapartida);
    }
    
    fclose(f);
}

void mostrar_menu() {
    printf("\n==============================\n");
    printf("    RETROFAK'85 - TETRIS\n");
    printf("==============================\n");
    printf("1. Alta participant\n");
    printf("2. Jugar partida\n");
    printf("3. Generar millors per sexe\n");
    printf("4. Llistar participants\n");
    printf("5. Llistar partides\n");
    printf("6. Llistar records (Top Ten)\n");
    printf("7. Sortir\n");
    printf("==============================\n");
    printf("Opció: ");
}

int main() {
    int opcio;
    
    do {
        mostrar_menu();
        scanf("%d", &opcio);
        getchar();
        
        switch(opcio) {
            case 1:
                alta_participant();
                break;
            case 2:
                jugar_partida();
                break;
            case 3:
                generar_millors_per_sexe();
                break;
            case 4:
                llistar_participants();
                break;
            case 5:
                llistar_partides();
                break;
            case 6:
                llistar_records();
                break;
            case 7:
                printf("\nFins aviat!\n");
                break;
            default:
                printf("\nOpció incorrecta!\n");
        }
        
    } while(opcio != 7);
    
    return 0;
}