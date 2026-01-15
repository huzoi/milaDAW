import java.util.Scanner;

public class NumerosFinsZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[100];
        int contador = 0;
        int numero;
        
        System.out.println("Introdueix numeros (0 per acabar):");
        
        do {
            System.out.print("Numero: ");
            numero = scanner.nextInt();
            
            if (numero != 0) {
                numeros[contador] = numero;
                contador++;
            }
        } while (numero != 0);

        System.out.println("\n   NUMEROS   ");
        for (int i = contador - 1; i >= 0; i--) {
            System.out.println(numeros[i]);
        }
        
        scanner.close();
    }
}