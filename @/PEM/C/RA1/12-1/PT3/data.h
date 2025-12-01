#ifndef DATA_H
#define DATA_H

#include <stdbool.h>

typedef struct data{
    int dia;
    int mes;
    int any;
}Tdata;

bool es_any_traspas(int any);
bool es_data_valida(int dia, int mes, int any);
int get_any(Tdata data);
int get_mes(Tdata data);
int get_dia(Tdata data);
bool set_any(Tdata *data, int any);
bool set_mes(Tdata *data, int mes);
bool set_dia(Tdata *data, int dia);
bool modificar_data(int dia, int mes, int any, Tdata *data);
float llegirinterval(float min, float max);
int arrodonir(float x);
void llegirdata(Tdata *data);
void escriuredata(Tdata data);
Tdata llegir_cadena_a_data();
bool cadena_a_data(char datacadena[11], Tdata *data);
bool data_a_cadena(char datacadena[11], Tdata data);
long int data_a_dies(Tdata data);
int dies_a_data(long totaldies, Tdata *data);
int datadif(Tdata data1, Tdata data2);
void data_sistema(char datas[11]);

#endif