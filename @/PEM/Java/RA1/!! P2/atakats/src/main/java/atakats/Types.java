/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package atakats;

/**
 *
 * @author h
 */
import java.util.Random;

public enum Types {
    RANSOMWARE("Ransomware: segrest de dades", 8),
    SPYWARE("Spyware: robatori d'informació", 2),
    ADWARE("Adware: publicitat intrusiva", 0),
    DOS("DoS: denegació de servei", 6),
    STEALER("Stealer: robatori de credencials", 7);
    
    private final String description;
    private final int extraForce;
    
    private Types(String description, int extraForce) {
        this.description = description;
        this.extraForce = extraForce;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getExtraForce() {
        return extraForce;
    }
    
    public static Types getRandomValue() {
        Types[] values = Types.values();
        Random rand = new Random();
        return values[rand.nextInt(values.length)];
    }
    
    @Override
    public String toString() {
        return description;
    }
}
