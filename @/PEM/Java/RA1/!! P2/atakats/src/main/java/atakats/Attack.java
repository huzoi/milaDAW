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

public abstract class Attack {
    private String identifier;
    
    public Attack() {
        this.identifier = generateIdentifier();
    }
    
    private String generateIdentifier() {
        Random rand = new Random();
        char letter = (char) ('A' + rand.nextInt(26));
        int digit = rand.nextInt(10);
        return letter + String.valueOf(digit);
    }
    
    public String getIdentifier() {
        return identifier;
    }
    
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    
    public abstract String getDescription();
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + identifier + "){" + getDescription() + "}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Attack attack = (Attack) obj;
        return identifier.equals(attack.identifier);
    }
    
    @Override
    public int hashCode() {
        return identifier.hashCode();
    }
}