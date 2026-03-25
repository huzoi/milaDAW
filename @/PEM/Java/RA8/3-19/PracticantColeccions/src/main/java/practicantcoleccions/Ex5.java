import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class Ex5 {
    public static void main(String[] args) {
        System.out.println("=== EXERCICI 5: MÈTODE SORT I CONVERSIÓ A SETS ===\n");
        
        ArrayList<Integer> numeros = new ArrayList<>();
        Random random = new Random();
        
        System.out.println("--- PART 1: Generant 10 números aleatoris entre 0 i 24 ---\n");
        
        for (int i = 0; i < 10; i++) {
            int numeroAleatori = random.nextInt(25);
            numeros.add(numeroAleatori);
            System.out.println("Número " + (i + 1) + ": " + numeroAleatori);
        }
        
        System.out.println("\n--- Llista desordenada original ---");
        System.out.println(numeros);
        System.out.println("Mida: " + numeros.size());
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("PART 2: APLICANT Collections.sort()");
        System.out.println("=".repeat(70) + "\n");
        
        Collections.sort(numeros);
        
        System.out.println("--- Llista ordenada (ascendent) ---");
        System.out.println(numeros);
        
        System.out.println("\n--- Detall dels elements ordenats ---");
        for (int i = 0; i < numeros.size(); i++) {
            System.out.println("Posició " + i + ": " + numeros.get(i));
        }
        
        System.out.println("\n--- Ordenació descendent amb Collections.reverseOrder() ---");
        Collections.sort(numeros, Collections.reverseOrder());
        System.out.println(numeros);
        
        System.out.println("\n--- Tornant a ordenar ascendent ---");
        Collections.sort(numeros);
        System.out.println(numeros);
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("PART 3: CONVERSIÓ A DIFERENTS TIPUS DE SETS");
        System.out.println("=".repeat(70) + "\n");
        
        System.out.println("--- Conversió a HashSet ---");
        HashSet<Integer> hashSet = new HashSet<>(numeros);
        System.out.println("HashSet: " + hashSet);
        System.out.println("Mida: " + hashSet.size());
        System.out.println("Característiques:");
        System.out.println("Elimina duplicats automàticament");
        System.out.println("NO garanteix ordre");
        System.out.println("Rendiment O(1) per add/remove/contains");
        
        System.out.println("\n--- Conversió a LinkedHashSet ---");
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(numeros);
        System.out.println("LinkedHashSet: " + linkedHashSet);
        System.out.println("Mida: " + linkedHashSet.size());
        System.out.println("Característiques:");
        System.out.println("Elimina duplicats automàticament");
        System.out.println("MANTÉ ordre d'inserció");
        System.out.println("Rendiment O(1) per add/remove/contains");
        
        System.out.println("\n--- Conversió a TreeSet ---");
        TreeSet<Integer> treeSet = new TreeSet<>(numeros);
        System.out.println("TreeSet: " + treeSet);
        System.out.println("Mida: " + treeSet.size());
        System.out.println("Característiques:");
        System.out.println("  ✓ Elimina duplicats automàticament");
        System.out.println("  ✓ ORDENAT automàticament (ordre natural)");
        System.out.println("  ✓ Rendiment O(log n) per add/remove/contains");
        
        System.out.println("\n--- Conversió a SortedSet (interfície de TreeSet) ---");
        SortedSet<Integer> sortedSet = new TreeSet<>(numeros);
        System.out.println("SortedSet: " + sortedSet);
        System.out.println("Mida: " + sortedSet.size());
        
        if (!sortedSet.isEmpty()) {
            System.out.println("\nMètodes especials de SortedSet:");
            System.out.println("  - first(): " + sortedSet.first() + " (element mínim)");
            System.out.println("  - last(): " + sortedSet.last() + " (element màxim)");
            System.out.println("  - headSet(15): " + sortedSet.headSet(15) + " (elements < 15)");
            System.out.println("  - tailSet(10): " + sortedSet.tailSet(10) + " (elements >= 10)");
        }
    }
}