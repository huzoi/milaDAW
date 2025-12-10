#include <stdio.h>
#include <stdbool.h>
#include <time.h>
#include <string.h>
#include "data.h"

bool es_any_traspas(int any){
    if((any % 4 == 0 && any % 100 != 0) || (any % 400 == 0)){
        return true;
    }
    return false;
}

bool es_data_valida(int dia, int mes, int any){
    int diesmesos[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    if(any < 1900 || any > 3000){
        return false;
    }
    
    if(mes < 1 || mes > 12){
        return false;
    }
    
    if(es_any_traspas(any)){
        diesmesos[1] = 29;
    }
    
    if(dia < 1 || dia > diesmesos[mes-1]){
        return false;
    }
    
    return true;
}

int get_any(Tdata data){
    return data.any;
}

int get_mes(Tdata data){
    return data.mes;
}

int get_dia(Tdata data){
    return data.dia;
}

bool set_any(Tdata *data, int any){
    if(any >= 1900 && any <= 3000){
        data->any = any;
        return true;
    }
    return false;
}

bool set_mes(Tdata *data, int mes){
    if(mes >= 1 && mes <= 12){
        data->mes = mes;
        return true;
    }
    return false;
}

bool set_dia(Tdata *data, int dia){
    if(dia >= 1 && dia <= 31){
        data->dia = dia;
        return true;
    }
    return false;
}

bool modificar_data(int dia, int mes, int any, Tdata *data){
    if(es_data_valida(dia, mes, any)){
        data->dia = dia;
        data->mes = mes;
        data->any = any;
        return true;
    }
    return false;
}

float llegirinterval(float min, float max){
    float resultat = 0;
    
    do{
        printf("\nIntrodueix valor: ");
        fflush(stdin);
        scanf("%f", &resultat);
    }while(!(resultat >= min && resultat <= max));
    
    return resultat;
}

int arrodonir(float x){
    return (int)(x + 0.5);
}

void llegirdata(Tdata *data){
    int dia, mes, any;
    
    do{
        printf("Introdueix dia: ");
        scanf("%d", &dia);
        printf("Introdueix mes: ");
        scanf("%d", &mes);
        printf("Introdueix any: ");
        scanf("%d", &any);
        
        if(!es_data_valida(dia, mes, any)){
            printf("Data no valida. Torna-ho a intentar.\n");
        }
    }while(!es_data_valida(dia, mes, any));
    
    data->dia = dia;
    data->mes = mes;
    data->any = any;
}

void escriuredata(Tdata data){
    printf("%02d/%02d/%04d", data.dia, data.mes, data.any);
}

Tdata llegir_cadena_a_data(){
    char datacadena[80] = "00/00/0000";
    int i, pot;
    Tdata data;
    
    do{
        printf("\nIntrodueix cadena 00/00/0000: ");
        fflush(stdin);
        scanf("%s", datacadena);
        data.dia = (datacadena[0]-'0')*10 + datacadena[1]-'0';
        data.mes = (datacadena[3]-'0')*10 + datacadena[4]-'0';
        pot = 1000;
        data.any = 0;
        for(i = 0; i < 4; i++){
            data.any = data.any + (datacadena[i+6]-'0')*pot;
            pot = pot / 10;
        }
    }while(!((es_data_valida(data.dia, data.mes, data.any)) && (strlen(datacadena)==10)));
    
    return data;
}

bool cadena_a_data(char datacadena[11], Tdata *data){
    int i, pot;
    
    if(strlen(datacadena) != 10){
        return false;
    }
    
    data->dia = (datacadena[0]-'0')*10 + datacadena[1]-'0';
    data->mes = (datacadena[3]-'0')*10 + datacadena[4]-'0';
    pot = 1000;
    data->any = 0;
    for(i = 0; i < 4; i++){
        data->any = data->any + (datacadena[i+6]-'0')*pot;
        pot = pot / 10;
    }
    
    if(es_data_valida(data->dia, data->mes, data->any)){
        return true;
    }
    
    return false;
}

bool data_a_cadena(char datacadena[11], Tdata data){
    if(!es_data_valida(data.dia, data.mes, data.any)){
        return false;
    }
    
    sprintf(datacadena, "%02d/%02d/%04d", data.dia, data.mes, data.any);
    return true;
}

long int data_a_dies(Tdata data){
    long int totaldies, i;
    int diesmesos[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    if(es_data_valida(data.dia, data.mes, data.any)){
        totaldies = 0;
        totaldies = 365*(data.any-1) + (data.any/4) - data.any/100 + data.any/400;
        for(i = 0; i < data.mes-1; i++){
            totaldies = totaldies + diesmesos[i];
        }
        totaldies = totaldies + data.dia;
        if(es_any_traspas(data.any) && (data.mes < 3)){
            totaldies = totaldies - 1;
        }
    }
    else{
        totaldies = -1;
    }
    return totaldies;
}

int dies_a_data(long totaldies, Tdata *data){
    int darrerany = 0;
    long dies, dies_any;
    int any, i;
    int diesmesos[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    dies = totaldies;
    
    if(dies > 0 && totaldies < 3000 * 365){
        any = 1;
        while(!(darrerany)){
            if(es_any_traspas(any)){
                dies_any = 366;
            }
            else{
                dies_any = 365;
            }
            if(dies > dies_any){
                dies = dies - dies_any;
                any++;
            }
            else{
                darrerany = 1;
            }
        }
        if(es_any_traspas(any)){
            diesmesos[1] = 29;
        }
        i = 0;
        while(dies > diesmesos[i]){
            dies = dies - diesmesos[i];
            i++;
        }
        if(dies == 0){
            dies = diesmesos[i];
        }
        
        data->any = any;
        data->mes = i + 1;
        data->dia = dies;
        return 1;
    }
    else{
        return 0;
    }
}

int datadif(Tdata data1, Tdata data2){
    long int dies1, dies2;
    
    dies1 = data_a_dies(data1);
    dies2 = data_a_dies(data2);
    
    return (int)(dies1 - dies2);
}

void data_sistema(char datas[11]){
    time_t t;
    struct tm *tm;
    char data[100];
    t = time(NULL);
    tm = localtime(&t);
    strftime(data, 100, "%d/%m/%Y", tm);
    strcpy(datas, data);
}