/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package arraylist;

/**
 *
 * @author h
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayList_Ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();
        
        System.out.println("=== LECTURA DE VALORS NUMÈRICS ===");
        System.out.println("Introdueix números enters (escriu -99 per acabar):");
        
        int valor;
        do {
            System.out.print("Número: ");
            valor = scanner.nextInt();
            
            if (valor != -99) {
                numeros.add(valor);
            }
        } while (valor != -99);
        
        if (numeros.isEmpty()) {
            System.out.println("\nNo s'han introduït valors.");
            return;
        }
        
        int quantitat = numeros.size();
        int suma = 0;
        
        for (Integer num : numeros) {
            suma += num;
        }
        
        double promig = (double) suma / quantitat;
        
        System.out.println("\n=== RESULTATS ===");
        System.out.println("Quantitat de valors llegits: " + quantitat);
        System.out.println("Suma total: " + suma);
        System.out.println("Promig: " + promig);
        
        int comptadorMajorsQuePromig = 0;
        Iterator<Integer> iterator = numeros.iterator();
        
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            if (num > promig) {
                comptadorMajorsQuePromig++;
            }
        }
        
        System.out.println("\nValors més grans que el promig: " + comptadorMajorsQuePromig);
        
        scanner.close();
    }
}
