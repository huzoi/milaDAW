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

public enum Techniques {
    ESCANEIG_PORTS("Escaneig de ports oberts"),
    ENUMERACIO_SERVEIS("Enumeració de serveis actius"),
    IDENTIFICACIO_SO("Identificació del sistema operatiu"),
    ENUMERACIO_DNS("Enumeració de registres DNS"),
    ENGINYERIA_SOCIAL("Obtenció d'informació per enginyeria social"),
    MAPEIG_XARXA("Mapeig de la xarxa interna");
    
    private final String description;
    
    private Techniques(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    
    public static Techniques getRandomValue() {
        Techniques[] values = Techniques.values();
        Random rand = new Random();
        return values[rand.nextInt(values.length)];
    }
    
    @Override
    public String toString() {
        return description;
    }
}