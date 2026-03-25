import java.util.ArrayList;
import java.util.Iterator;

public class Ex2 {
    public static void main(String[] args) {
        System.out.println("=== EXERCICI 2: MÈTODE ADD ===\n");
        
        System.out.println("--- Provant SENSE Iterator ---\n");
        
        ArrayList<String> fruitesSense = new ArrayList<>();
        fruitesSense.add("Poma");
        fruitesSense.add("Plàtan");
        fruitesSense.add("Taronja");
        fruitesSense.add("Maduixa");
        
        System.out.println("Llista inicial: " + fruitesSense);
        System.out.println("\nRecorrent i afegint 'Kiwi' després dels 2 primers:\n");
        
        for (int i = 0; i < fruitesSense.size(); i++) {
            System.out.println("Element " + i + ": " + fruitesSense.get(i));
            
            if (i == 1) {
                System.out.println("  → Afegint 'Kiwi'");
                fruitesSense.add("Kiwi");
            }
        }
        
        System.out.println("\nLlista final: " + fruitesSense);
        System.out.println("Funciona correctament amb for normal");
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        System.out.println("--- Provant AMB Iterator ---\n");
        
        ArrayList<String> fruitesAmb = new ArrayList<>();
        fruitesAmb.add("Poma");
        fruitesAmb.add("Plàtan");
        fruitesAmb.add("Taronja");
        fruitesAmb.add("Maduixa");
        
        System.out.println("Llista inicial: " + fruitesAmb);
        System.out.println("\nRecorrent amb Iterator i intentant afegir 'Kiwi':\n");
        
        try {
            Iterator<String> iterator = fruitesAmb.iterator();
            int comptador = 0;
            
            while (iterator.hasNext()) {
                String fruita = iterator.next();
                System.out.println("Element " + comptador + ": " + fruita);
                
                if (comptador == 1) {
                    System.out.println("Intentant afegir 'Kiwi'...");
                    fruitesAmb.add("Kiwi");
                }
                
                comptador++;
            }
            
            System.out.println("\nLlista final: " + fruitesAmb);
            
        } catch (Exception e) {
            System.out.println("\nERROR: " + e.getClass().getSimpleName());
            System.out.println("Missatge: " + e.getMessage());
            System.out.println("\nRAÓ: No es pot modificar la llista mentre s'està iterant!");
        }
        
        System.out.println("\nLlista actual: " + fruitesAmb);
    }
}