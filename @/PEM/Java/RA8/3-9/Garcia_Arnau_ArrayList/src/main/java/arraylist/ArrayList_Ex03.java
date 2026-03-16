/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package arraylist;

/**
 *
 * @author h
 */
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayList_Ex03 {
    
    public static <T> void imprimirArrayList(ArrayList<T> llista) {
        if (llista == null || llista.isEmpty()) {
            System.out.println("La llista està buida o és nul·la.");
            return;
        }
        
        System.out.println("=== Contingut de l'ArrayList ===");
        Iterator<T> iterator = llista.iterator();
        int index = 0;
        
        while (iterator.hasNext()) {
            T element = iterator.next();
            System.out.println("[" + index + "] " + element);
            index++;
        }
        System.out.println("Total elements: " + index);
    }
    
    public static void main(String[] args) {
        
        System.out.println("TEST 1: ArrayList d'Integers");
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(40);
        numeros.add(50);
        imprimirArrayList(numeros);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        System.out.println("TEST 2: ArrayList de Strings");
        ArrayList<String> paraules = new ArrayList<>();
        paraules.add("Hola");
        paraules.add("Món");
        paraules.add("Java");
        paraules.add("ArrayList");
        imprimirArrayList(paraules);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        System.out.println("TEST 3: ArrayList de Persones");
        ArrayList<Persona> persones = new ArrayList<>();
        persones.add(new Persona("Joan", "García", "12345678A", 25));
        persones.add(new Persona("Maria", "López", "87654321B", 30));
        persones.add(new Persona("Pere", "Martínez", "11223344C", 45));
        imprimirArrayList(persones);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        System.out.println("TEST 4: ArrayList de Doubles");
        ArrayList<Double> decimals = new ArrayList<>();
        decimals.add(3.14);
        decimals.add(2.71);
        decimals.add(1.41);
        decimals.add(9.81);
        imprimirArrayList(decimals);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        System.out.println("TEST 5: ArrayList buit");
        ArrayList<String> buit = new ArrayList<>();
        imprimirArrayList(buit);
    }
}
