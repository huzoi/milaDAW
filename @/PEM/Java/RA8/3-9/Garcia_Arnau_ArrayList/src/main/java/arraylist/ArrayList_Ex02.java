/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package arraylist;

/**
 *
 * @author h
 */
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList_Ex02 {
    
    public static Persona cercarPersonaPerDNI(ArrayList<Persona> llista, String dni) {
        for (Persona persona : llista) {
            if (persona.getDni().equalsIgnoreCase(dni)) {
                return persona;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Persona> persones = new ArrayList<>();
        
        System.out.println("=== REGISTRE DE PERSONES ===");
        
        persones.add(new Persona("Joan", "García Martínez", "12345678A", 25));
        persones.add(new Persona("Maria", "López Sánchez", "87654321B", 30));
        persones.add(new Persona("Pere", "Fernández Vila", "11223344C", 45));
        persones.add(new Persona("Anna", "Rodríguez Pons", "55667788D", 28));
        persones.add(new Persona("Carles", "Martín Roca", "99887766E", 35));
        
        System.out.println("S'han registrat " + persones.size() + " persones:");
        for (Persona p : persones) {
            System.out.println("  - " + p);
        }
        
        System.out.println("\n=== CERCA PER DNI ===");
        System.out.print("Introdueix el DNI a cercar: ");
        String dniBuscat = scanner.nextLine();
        
        Persona trobada = cercarPersonaPerDNI(persones, dniBuscat);
        
        if (trobada != null) {
            System.out.println("\nPersona trobada:");
            System.out.println(trobada);
        } else {
            System.out.println("\nNo s'ha trobat cap persona amb el DNI: " + dniBuscat);
        }
        
        scanner.close();
    }
}
