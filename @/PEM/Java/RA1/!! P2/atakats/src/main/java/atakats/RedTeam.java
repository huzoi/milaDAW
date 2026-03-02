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

public final class RedTeam {
    
    private RedTeam() {
    }
    
    public static Attack[] generaAttacks(int n) {
        Attack[] attacks = new Attack[n];
        Random rand = new Random();
        
        for (int i = 0; i < n; i++) {
            int attackType = rand.nextInt(3);
            
            switch (attackType) {
                case 0:
                    attacks[i] = new MalwareAttack();
                    break;
                case 1:
                    attacks[i] = new PhishingAttack();
                    break;
                case 2:
                    attacks[i] = new ReconnaissanceAttack();
                    break;
            }
        }
        
        return attacks;
    }
}
