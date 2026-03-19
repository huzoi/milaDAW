/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package practicantmap;

/**
 *
 * @author h
 */
import java.util.HashMap;
import java.util.Map;

public class Ex2 {
    public static void main(String[] args) {
        System.out.println("=== EXERCICI 2: HASHMAP AMB PRODUCTES ===\n");
        
        HashMap<Integer, Producte> productes = new HashMap<>();
        
        System.out.println("--- Afegint 5 productes amb put() ---\n");
        
        productes.put(100, new Producte("Portàtil", "Informàtica", 899.99));
        System.out.println("Afegit: 100 -> " + productes.get(100));
        
        productes.put(101, new Producte("Ratolí", "Informàtica", 25.50));
        System.out.println("Afegit: 101 -> " + productes.get(101));
        
        productes.put(102, new Producte("Teclat", "Informàtica", 45.00));
        System.out.println("Afegit: 102 -> " + productes.get(102));
        
        productes.put(103, new Producte("Monitor", "Informàtica", 199.99));
        System.out.println("Afegit: 103 -> " + productes.get(103));
        
        productes.put(104, new Producte("Webcam", "Informàtica", 65.00));
        System.out.println("Afegit: 104 -> " + productes.get(104));
        
        System.out.println("\n--- Mostrant TOTS els productes (clau i valor) ---\n");
        for (Map.Entry<Integer, Producte> entrada : productes.entrySet()) {
            System.out.println("Codi " + entrada.getKey() + ": " + entrada.getValue());
        }
        
        System.out.println("\n--- Recuperant producte amb clau 103 amb get() ---\n");
        Producte producte103 = productes.get(103);
        if (producte103 != null) {
            System.out.println("✓ Producte trobat amb clau 103:");
            System.out.println("  " + producte103);
        } else {
            System.out.println("✗ No s'ha trobat cap producte amb clau 103");
        }
        
        System.out.println("\n--- Recuperant producte amb clau 120 amb get() ---\n");
        Producte producte120 = productes.get(120);
        if (producte120 != null) {
            System.out.println("✓ Producte trobat amb clau 120:");
            System.out.println("  " + producte120);
        } else {
            System.out.println("✗ No s'ha trobat cap producte amb clau 120");
            System.out.println("  (La clau 120 no existeix al map)");
        }
        
        System.out.println("\n--- Afegint producte 100 amb la clau 110 ---\n");
        Producte producte100 = productes.get(100);
        System.out.println("Producte original amb clau 100: " + producte100);
        
        productes.put(110, producte100);
        System.out.println("Afegit el MATEIX producte amb clau 110");
        System.out.println("\nARA tenim:");
        System.out.println("  Clau 100: " + productes.get(100));
        System.out.println("  Clau 110: " + productes.get(110));
        System.out.println("\nOBSERVACIÓ: És el MATEIX objecte Producte amb dues claus diferents!");
        
        System.out.println("\n--- Afegint un NOU producte amb la clau 101 ---\n");
        System.out.println("Producte ACTUAL amb clau 101: " + productes.get(101));
        
        Producte nouProducte = new Producte("Auriculars", "Àudio", 89.99);
        Producte producteAntic = productes.put(101, nouProducte);
        
        System.out.println("\nS'ha SOBREESCRIT la clau 101:");
        System.out.println("  Producte antic (retornat per put): " + producteAntic);
        System.out.println("  Producte nou (ara a la clau 101): " + productes.get(101));
        System.out.println("\nIMPORTANT: put() amb clau existent SUBSTITUEIX el valor anterior!");
        
        System.out.println("\n--- Mostrant TOTS els productes finals (clau i valor) ---\n");
        System.out.println("Total de productes: " + productes.size());
        System.out.println();
        for (Map.Entry<Integer, Producte> entrada : productes.entrySet()) {
            System.out.println("Codi " + entrada.getKey() + ": " + entrada.getValue());
        }
    }
}