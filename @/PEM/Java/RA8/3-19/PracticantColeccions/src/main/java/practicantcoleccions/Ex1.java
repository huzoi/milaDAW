import java.util.ArrayList;
import java.util.Iterator;
 
public class Ex1 {
    public static void main(String[] args) {
        System.out.println("=== EXERCICI 1: MÈTODE REMOVE ===\n");
        
        System.out.println("--- Provant SENSE Iterator (INCORRECTE) ---\n");
        
        ArrayList<Integer> llistaSenseIterator = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            llistaSenseIterator.add(i);
        }
        
        System.out.println("Llista inicial: " + llistaSenseIterator);
        System.out.println("Intentant eliminar els números parells...\n");
        
        try {
            for (int i = 0; i < llistaSenseIterator.size(); i++) {
                if (llistaSenseIterator.get(i) % 2 == 0) {
                    System.out.println("Eliminant: " + llistaSenseIterator.get(i));
                    llistaSenseIterator.remove(i);
                }
            }
            System.out.println("\nLlista final: " + llistaSenseIterator);
            System.out.println("\nPROBLEMA: Alguns parells NO s'han eliminat!");
            System.out.println("Raó: Quan elimines un element, els índexs canvien.");
            
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        System.out.println("--- Provant AMB Iterator (CORRECTE) ---\n");
        
        ArrayList<Integer> llistaAmbIterator = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            llistaAmbIterator.add(i);
        }
        
        System.out.println("Llista inicial: " + llistaAmbIterator);
        System.out.println("Eliminant els números parells amb Iterator...\n");
        
        Iterator<Integer> iterator = llistaAmbIterator.iterator();
        while (iterator.hasNext()) {
            Integer numero = iterator.next();
            if (numero % 2 == 0) {
                System.out.println("Eliminant: " + numero);
                iterator.remove();
            }
        }
        
        System.out.println("\nLlista final: " + llistaAmbIterator);
        System.out.println("\n CORRECTE: Tots els parells s'han eliminat!");
        
        System.out.println("\n" + "=".repeat(70));
    }
}