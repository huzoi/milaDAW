/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package practicantset;

/**
 *
 * @author h
 */
import java.util.Iterator;
import java.util.Set;

public class Ex1 {
    public static void main(String[] args) {
        System.out.println("--- EXERCICI 1: SET IMMUTABLE ---\n");
        
        Set<String> paraules = Set.of("Java", "Python", "Javascript", "Pere", "Ruby", "Amanda");
        
        System.out.println("Nombre d'elements: " + paraules.size());
        
        System.out.println("\n--- Recorregut amb for-each ---");
        for (String paraula : paraules) {
            System.out.println("- " + paraula);
        }
        
        System.out.println("\n--- Recorregut amb Iterator ---");
        Iterator<String> iterator = paraules.iterator();
        while (iterator.hasNext()) {
            String paraula = iterator.next();
            System.out.println("- " + paraula);
        }
    }
}
