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

public enum Channels {
    EMAIL("Correu electrònic fraudulent", 55),
    VISHING("Trucada de veu", 10),
    SMISHING("Missatgeria sms", 15),
    XARXES_SOCIALS("Missatgeria en xarxes socials", 20);
    
    private final String description;
    private final int percentage;
    
    private Channels(String description, int percentage) {
        this.description = description;
        this.percentage = percentage;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getPercentage() {
        return percentage;
    }
    
    public static Channels getRandomValue() {
        Random rand = new Random();
        int random = rand.nextInt(100);
        
        if (random < 55) {
            return EMAIL;
        } else if (random < 75) {
            return XARXES_SOCIALS;
        } else if (random < 90) {
            return SMISHING;
        } else {
            return VISHING;
        }
    }
    
    @Override
    public String toString() {
        return description;
    }
}