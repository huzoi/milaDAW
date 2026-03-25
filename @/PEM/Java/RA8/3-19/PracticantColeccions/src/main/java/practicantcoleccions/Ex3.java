import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex3 {
    public static void main(String[] args) {
        System.out.println("=== EXERCICI 3: MÈTODE asList ===\n");
        
        System.out.println("--- Creant ArrayList amb Arrays.asList() ---\n");
        
        ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        
        System.out.println("ArrayList creat: " + numeros);
        System.out.println("Mida: " + numeros.size());
        
        System.out.println("\n--- Provant modificacions ---\n");
        
        numeros.add(60);
        System.out.println("Després d'afegir 60: " + numeros);
        
        numeros.remove(Integer.valueOf(30));
        System.out.println("Després d'eliminar 30: " + numeros);
        
        numeros.set(0, 15);
        System.out.println("Després de canviar primer element a 15: " + numeros);
        
        System.out.println("\nEs pot modificar perquè és un ArrayList!");
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        System.out.println("--- IMPORTANT: Diferència amb Arrays.asList() directe ---\n");
        
        List<Integer> llistaFixa = Arrays.asList(100, 200, 300, 400, 500);
        System.out.println("Llista creada amb Arrays.asList(): " + llistaFixa);
        
        System.out.println("\nProvant modificar element (set):");
        llistaFixa.set(0, 150);
        System.out.println("Després de set(0, 150): " + llistaFixa);
        System.out.println("set() funciona!");
        
        System.out.println("\nProvant afegir element (add):");
        try {
            llistaFixa.add(600);
            System.out.println("Element afegit correctament");
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: No es pot afegir!");
            System.out.println("RAÓ: Arrays.asList() retorna una llista de MIDA FIXA");
        }
    }
}