/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package practicantmap;

/**
 *
 * @author h
 */
import java.util.HashMap;
import java.util.Map;

public class Ex1 {
    public static void main(String[] args) {
        System.out.println("=== EXERCICI 1: MAP IMMUTABLE I OPERACIONS ===\n");
        
        System.out.println("--- Creant Map immutable amb Map.of() ---");
        Map<Integer, String> mapImmutable = Map.of(
            1, "Un",
            2, "Dos",
            3, "Tres",
            4, "Quatre",
            5, "Cinc"
        );
        
        System.out.println("Map creat: " + mapImmutable);
        System.out.println("Nombre d'elements: " + mapImmutable.size());
        
        System.out.println("\n--- Mostrant elements amb keySet() ---");
        System.out.println("Claus del map:");
        for (Integer clau : mapImmutable.keySet()) {
            System.out.println("  Clau: " + clau + " -> Valor: " + mapImmutable.get(clau));
        }
        
        System.out.println("\n--- Intentant inserir un nou element ---");
        try {
            mapImmutable.put(6, "Sis");
            System.out.println("Element afegit correctament.");
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: No es pot afegir! El Map és IMMUTABLE.");
            System.out.println("Exception: " + e.getClass().getSimpleName());
        }
        
        System.out.println("\n--- Mostrant elements amb values() ---");
        System.out.println("Valors del map:");
        for (String valor : mapImmutable.values()) {
            System.out.println("  - " + valor);
        }
        
        System.out.println("\n--- Intentant eliminar el segon element (clau 2) ---");
        try {
            mapImmutable.remove(2);
            System.out.println("Element eliminat correctament.");
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: No es pot eliminar! El Map és IMMUTABLE.");
            System.out.println("Exception: " + e.getClass().getSimpleName());
        }
        
        System.out.println("\n--- Mostrant elements amb entrySet() ---");
        System.out.println("Entrades del map (parelles clau-valor):");
        for (Map.Entry<Integer, String> entrada : mapImmutable.entrySet()) {
            System.out.println("  Clau: " + entrada.getKey() + " -> Valor: " + entrada.getValue());
        }
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("SOLUCIÓ: Si volem afegir/eliminar elements, hem de crear un Map MUTABLE");
        System.out.println("=".repeat(70));
        
        System.out.println("\n--- Creant HashMap mutable a partir del Map immutable ---");
        HashMap<Integer, String> mapMutable = new HashMap<>(mapImmutable);
        System.out.println("HashMap creat: " + mapMutable);
        
        System.out.println("\n--- Afegint nou element (clau 6, valor 'Sis') ---");
        mapMutable.put(6, "Sis");
        System.out.println("Element afegit correctament!");
        System.out.println("Map actualitzat: " + mapMutable);
        
        System.out.println("\n--- Comprovant si la clau 6 existeix ---");
        if (mapMutable.containsKey(6)) {
            System.out.println(" La clau 6 existeix en el map.");
            System.out.println("  Valor associat: " + mapMutable.get(6));
        } else {
            System.out.println(" La clau 6 NO existeix en el map.");
        }
        
        System.out.println("\n--- Eliminant l'element amb clau 6 ---");
        String valorEliminat = mapMutable.remove(6);
        System.out.println("Element eliminat: Clau 6 -> Valor '" + valorEliminat + "'");
        System.out.println("Map actualitzat: " + mapMutable);
        
        System.out.println("\n--- Comprovant si la clau 6 encara existeix ---");
        if (mapMutable.containsKey(6)) {
            System.out.println(" La clau 6 existeix en el map.");
        } else {
            System.out.println(" La clau 6 NO existeix en el map.");
        }
        
        System.out.println("\n--- Mostrant tots els elements del HashMap mutable ---");
        for (Map.Entry<Integer, String> entrada : mapMutable.entrySet()) {
            System.out.println("  Clau: " + entrada.getKey() + " -> Valor: " + entrada.getValue());
        }
    }
}