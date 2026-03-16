package març_setze;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author h
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ProgramaQuatrePotes {
    public static void main(String[] args) {
        List<QuatrePotes> animals = new ArrayList<>();
        Random random = new Random();
        
        String[] tipus = {"Lleó", "Gat", "Gos", "Elefant"};
        
        System.out.println("=== GENERANT 10.000 ANIMALS ALEATORIS ===\n");
        
        for (int i = 1; i <= 10000; i++) {
            String tipusAnimal = tipus[random.nextInt(tipus.length)];
            animals.add(new QuatrePotes(i, tipusAnimal));
        }
        
        System.out.println("Total animals generats: " + animals.size());
        
        System.out.println("\n=== ANIMALS AMB ID MÚLTIPLE DE 1000 ===\n");
        
        for (QuatrePotes animal : animals) {
            if (animal.getIdAnimal() % 1000 == 0) {
                System.out.println(animal);
            }
        }
        
        System.out.println("\n=== ORDENANT ANIMALS PER TIPUS PER FER RECOMPTE ===\n");
        
        animals.sort(Comparator.comparing(QuatrePotes::getTipus));
        
        System.out.println("=== RESUM D'ANIMALS PER TIPUS ===\n");
        
        int comptadorLleo = 0;
        int comptadorGat = 0;
        int comptadorGos = 0;
        int comptadorElefant = 0;
        
        for (QuatrePotes animal : animals) {
            switch (animal.getTipus()) {
                case "Lleó":
                    comptadorLleo++;
                    break;
                case "Gat":
                    comptadorGat++;
                    break;
                case "Gos":
                    comptadorGos++;
                    break;
                case "Elefant":
                    comptadorElefant++;
                    break;
            }
        }
        
        System.out.println("Lleons:   " + comptadorLleo + " animals");
        System.out.println("Gats:     " + comptadorGat + " animals");
        System.out.println("Gossos:   " + comptadorGos + " animals");
        System.out.println("Elefants: " + comptadorElefant + " animals");
        System.out.println("─".repeat(40));
        System.out.println("TOTAL:    " + (comptadorLleo + comptadorGat + comptadorGos + comptadorElefant) + " animals");
        
        double percentatgeLleo = (comptadorLleo / 10000.0) * 100;
        double percentatgeGat = (comptadorGat / 10000.0) * 100;
        double percentatgeGos = (comptadorGos / 10000.0) * 100;
        double percentatgeElefant = (comptadorElefant / 10000.0) * 100;
        
        System.out.println("\n=== PERCENTATGES ===\n");
        System.out.printf("Lleons:   %.2f%%\n", percentatgeLleo);
        System.out.printf("Gats:     %.2f%%\n", percentatgeGat);
        System.out.printf("Gossos:   %.2f%%\n", percentatgeGos);
        System.out.printf("Elefants: %.2f%%\n", percentatgeElefant);
        
        System.out.println("\nNOTA: Com que la generació és aleatòria, els percentatges haurien");
        System.out.println("de ser aproximadament 25% per cada tipus d'animal.");
    }
}
