/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provajson;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author h
 */
public class MainJsonAnimal {
    
    public static void main() {
        String fitxer = "animal.json";
        Animal animalLlegit;

        Animal al = new Animal(1, "Bobby", "gos", 12.5, 4);

        JsonUtils.escriureAnimal(al, fitxer);
        animalLlegit = JsonUtils.llegirAnimal(fitxer);

        System.out.println("Nom: "+ animalLlegit.getNom());
        System.out.println("Edat: "+ animalLlegit.getPes());
        
        //p2
        
        String fitxer2 = "animal2.json";
        
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal(1, "Bobby", "gos", 12.5, 4));
        animals.add(new Animal(2, "Mishi", "gat", 4.3, 4));
        animals.add(new Animal(3, "Rocky", "gos", 20.0, 4));
        animals.add(new Animal(4, "Piolin", "ocell", 0.5, 2));
        animals.add(new Animal(5, "Sombragris", "cavall", 400, 4));
        animals.add(new Animal(6, "'Os Yogui", "os", 400, 4));
        
        JsonUtils.escriureAnimals(animals, fitxer2);
        
        List<Animal> animalsLlegits = JsonUtils.llegirAnimals(fitxer2);
        for (Animal a : animalsLlegits) {
            System.out.println(a);
        }
    }
}

