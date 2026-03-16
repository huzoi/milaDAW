/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package practicantset;

/**
 *
 * @author h
 */
import java.util.HashSet;

public class Ex2 { //fet per IA, no m'amago
    public static void main(String[] args) {
        System.out.println("--- EXERCICI 2: HASHSET AMB ALUMNES (SENSE EQUALS/HASHCODE) ---\n");
        
        HashSet<Alumne> alumnes = new HashSet<>();
        
        alumnes.add(new Alumne(1, "Joan", "García Martínez"));
        alumnes.add(new Alumne(2, "Maria", "López Sánchez"));
        alumnes.add(new Alumne(3, "Pere", "Fernández Vila"));
        alumnes.add(new Alumne(4, "Anna", "Rodríguez Pons"));
        alumnes.add(new Alumne(5, "Carles", "Martín Roca"));
        
        System.out.println("Primer llistat d'alumnes (" + alumnes.size() + " alumnes):");
        for (Alumne a : alumnes) {
            System.out.println("  " + a);
        }
        
        System.out.println("\n--- Afegint un alumne amb les MATEIXES dades que l'alumne 1 ---");
        alumnes.add(new Alumne(1, "Joan", "García Martínez"));
        
        System.out.println("\nSegon llistat d'alumnes (" + alumnes.size() + " alumnes):");
        for (Alumne a : alumnes) {
            System.out.println("  " + a);
        }
    }
}
