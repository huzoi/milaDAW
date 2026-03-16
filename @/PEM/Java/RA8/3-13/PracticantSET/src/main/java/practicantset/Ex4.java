/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package practicantset;

/**
 *
 * @author h
 */
import java.util.LinkedHashSet;
import java.util.Random; 
import java.util.Set;
import java.util.TreeSet;

public class Ex4 { //aquest l'he intentat jo, ja que m'enrecordava de classe però no em sortia i la IA me l'ha corretgit
    public static void main(String[] args) {
        System.out.println("--- EXERCICI 4: LINKEDHASHSET VS TREESET AMB NÚMEROS ALEATORIS ---\n");
        
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        
        Random random = new Random();
        
        System.out.println("Generant 15 números aleatoris entre 0 i 100:");
        System.out.println("(mostrant ordre d'inserció)\n");
        
        for (int i = 1; i <= 15; i++) {
            int numero = random.nextInt(101);
            linkedHashSet.add(numero);
            treeSet.add(numero);
            System.out.println("Número " + i + ": " + numero);
        }
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("LINKEDHASHSET - Manté ordre d'inserció");
        System.out.println("=".repeat(60));
        System.out.println("Elements: " + linkedHashSet);
        System.out.println("Mida: " + linkedHashSet.size() + " elements únics");
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("TREESET - Ordre natural (ascendent)");
        System.out.println("=".repeat(60));
        System.out.println("Elements: " + treeSet);
        System.out.println("Mida: " + treeSet.size() + " elements únics");
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("SUBSET del TreeSet: elements entre 25 i 50 (ambdós inclosos)");
        System.out.println("=".repeat(60));
        
        Set<Integer> subset = treeSet.subSet(25, true, 50, true);
        
        if (subset.isEmpty()) {
            System.out.println("No hi ha elements entre 25 i 50.");
        } else {
            System.out.println("Elements del subset:");
            for (Integer num : subset) {
                System.out.println("  - " + num);
            }
            System.out.println("\nTotal elements en el subset: " + subset.size());
        }
    }
}
