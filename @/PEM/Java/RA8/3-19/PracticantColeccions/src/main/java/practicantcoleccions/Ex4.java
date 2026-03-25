import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Ex4 {
    public static void main(String[] args) {
        System.out.println("=== EXERCICI 4: MÈTODE REVERSE ===\n");
        
        ArrayList<Integer> numeros = new ArrayList<>();
        Random random = new Random();
        
        System.out.println("--- Generant 10 números aleatoris entre 0 i 24 ---\n");
        
        for (int i = 0; i < 10; i++) {
            int numeroAleatori = random.nextInt(25);
            numeros.add(numeroAleatori);
            System.out.println("Número " + (i + 1) + ": " + numeroAleatori);
        }
        
        System.out.println("\n--- Llista original ---");
        System.out.println(numeros);
        
        System.out.println("\n--- Aplicant Collections.reverse() ---\n");
        Collections.reverse(numeros);
        
        System.out.println("--- Llista invertida ---");
        System.out.println(numeros);
        
        System.out.println("\n--- Comparació visual ---");
        System.out.println("Original:  Primer → Últim");
        System.out.println("Invertida: Últim → Primer");
        
        System.out.println("\n--- Detall de la inversió ---");
        for (int i = 0; i < numeros.size(); i++) {
            System.out.println("Posició " + i + ": " + numeros.get(i));
        }
    }
}