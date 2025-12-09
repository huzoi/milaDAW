#include <stdio.h>
#include <ctype.h>

int es_vocal(char c){
    c = tolower(c);
    return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
            c == 'á' || c == 'é' || c == 'í' || c == 'ó' || c == 'ú');
}

int main(){
    FILE *pelis;
    char caracter;
    int total_vocals = 0;
    
    pelis = fopen("pelis.txt", "r");
    
    if (pelis == NULL){
        printf("Error: No s'ha pogut obrir l'arxiu pelis.txt\n");
        return 1;
    }
    
    while ((caracter = fgetc(pelis)) != EOF){
        if (es_vocal(caracter)){
            total_vocals++;
        }
    }
    
    fclose(pelis);
    
    printf("L'arxiu 'pelis.txt' conté %d vocals.\n", total_vocals);
    
    return 0;
}