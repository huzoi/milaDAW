/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package practicantset;

/**
 *
 * @author h
 */
import java.util.LinkedHashSet;

public class Ex3 { //he reciclat els noms de l'exercici anterior però NO està fet per IA
    public static void main(String[] args) {
        System.out.println("--- EXERCICI 3: LINKEDHASHSET AMB ORDRE D'INSERCIÓ ---\n");
        
        LinkedHashSet<Alumne> alumnes = new LinkedHashSet<>();
        
        System.out.println("Afegint alumnes en aquest ordre:");
        
        Alumne a1 = new Alumne(1, "Joan", "García Martínez");
        alumnes.add(a1);
        System.out.println("1. " + a1);
        
        Alumne a2 = new Alumne(2, "Maria", "López Sánchez");
        alumnes.add(a2);
        System.out.println("2. " + a2);
        
        Alumne a3 = new Alumne(3, "Pere", "Fernández Vila");
        alumnes.add(a3);
        System.out.println("3. " + a3);
        
        Alumne a4 = new Alumne(4, "Anna", "Rodríguez Pons");
        alumnes.add(a4);
        System.out.println("4. " + a4);
        
        Alumne a5 = new Alumne(5, "Carles", "Martín Roca");
        alumnes.add(a5);
        System.out.println("5. " + a5);
        
        System.out.println("\n--- Mostrant el llistat d'alumnes ---");
        int contador = 1;
        for (Alumne a : alumnes) {
            System.out.println(contador + ". " + a);
            contador++;
        }
    }
}