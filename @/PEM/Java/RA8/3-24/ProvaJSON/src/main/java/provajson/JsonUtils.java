/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provajson;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author h
 */
public class JsonUtils {
    
    public static void escriureAnimal (Animal ani, String fitxer) {
        Gson gson = new Gson();
        FileWriter writer;
        
        try {
            writer = new FileWriter(fitxer);
            gson.ToJson(ani, writer);
            System.out.println("Animal guardat en format JSON!");
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static Animal llegirAnimal(String fitxer) {
        Gson gson = new Gson();
        FileReader reader;
        
        try {
            reader = new FileReader(fitxer);
            return gson.FromJson(reader, Animal.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public static void escriureAnimals(List<Animal> animals, String fitxer) {
        Gson gson = new Gson();
        FileWriter writer;
        
        try {
            writer = new FileWriter(fitxer);
            gson.ToJson(animals, writer);
            writer.close();
            System.out.println("Llista d'Animals guardada en format JSON!");
        } catch (IOException e) {
            System.out.println(e.getMessage);
        }
    }
    
    public static List<Animal> llegirAnimals (String fitxer) {
        Gson gson = new Gson();
        FileReader reader;
        
        try {
            reader = new FileReader(fitxer);
            type tipusLlista = new TypeToken<List<Animal>>(){}.getType();
            return gson.FromJson(reader, tipusLlista);
        } catch (IOException e) {
            System.out.println(e.getMessage);
            return null;
        }
    }
}
