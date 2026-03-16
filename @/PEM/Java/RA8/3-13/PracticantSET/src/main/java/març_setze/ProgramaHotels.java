package març_setze;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author h
 */
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class ProgramaHotels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        HashSet<Hotel> hotelsDesordenats = new HashSet<>();
        
        String[] zones = {"platja", "muntanya", "rural"};
        
        System.out.println("=== GENERANT 12 HOTELS ALEATORIS ===\n");
        
        for (int i = 1; i <= 12; i++) {
            String zona = zones[random.nextInt(zones.length)];
            int preu = random.nextInt(111) + 40;
            
            Hotel hotel = new Hotel(i, zona, preu);
            hotelsDesordenats.add(hotel);
            System.out.println("Afegit: " + hotel);
        }
        
        System.out.println("\n=== CONJUNT D'HOTELS (SENSE ORDRE GARANTIT) ===");
        for (Hotel h : hotelsDesordenats) {
            System.out.println(h);
        }
        
        System.out.print("\nEn quina zona vols l'hotel? (platja/muntanya/ural): ");
        String zonaSeleccionada = scanner.nextLine().toLowerCase();
        
        TreeSet<Hotel> hotelsOrdenats = new TreeSet<>();
        
        for (Hotel h : hotelsDesordenats) {
            if (h.getZona().equalsIgnoreCase(zonaSeleccionada)) {
                hotelsOrdenats.add(h);
            }
        }
        
        System.out.println("\n=== HOTELS DE LA ZONA '" + zonaSeleccionada.toUpperCase() + 
                         "' ORDENATS PER PREU ===");
        
        if (hotelsOrdenats.isEmpty()) {
            System.out.println("No hi ha hotels en aquesta zona.");
        } else {
            for (Hotel h : hotelsOrdenats) {
                System.out.println(h);
            }
            System.out.println("\nTotal hotels trobats: " + hotelsOrdenats.size());
        }
        
        scanner.close();
    }
}
