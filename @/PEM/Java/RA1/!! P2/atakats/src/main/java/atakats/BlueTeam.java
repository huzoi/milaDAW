/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package atakats;

/**
 *
 * @author h
 */
import java.util.ArrayList;
import java.util.List;

public final class BlueTeam {
    private int systemHealth;
    private List<Attack> attackHistory;
    
    public BlueTeam() {
        this.systemHealth = 100;
        this.attackHistory = new ArrayList<>();
    }
    
    public int getSystemHealth() {
        return systemHealth;
    }
    
    private void setSystemHealth(int systemHealth) {
        this.systemHealth = systemHealth;
        if (this.systemHealth < 0) {
            this.systemHealth = 0;
        }
    }
    
    public void defensa(Attack attack) {
        System.out.println(attack);
        
        if (attack instanceof Impactable) {
            Impactable impactableAttack = (Impactable) attack;
            
            if (attackHistory.contains(attack)) {
                System.out.println("Attack " + attack.getIdentifier() + " aturat!!!!!");
            } else {
                int oldHealth = systemHealth;
                setSystemHealth(systemHealth - impactableAttack.impacte());
                
                if (oldHealth != systemHealth) {
                    System.out.println("Estat de salut actual " + systemHealth);
                }
                
                attackHistory.add(attack);
                
                if (attackHistory.size() > 50) {
                    attackHistory.remove(0);
                }
                
                if (systemHealth <= 0) {
                    System.out.println("\nEl sistema ha caigut després d'un " + attack.getDescription());
                }
            }
        }
    }
}
