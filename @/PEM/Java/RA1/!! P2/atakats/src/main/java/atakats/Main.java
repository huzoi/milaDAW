/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package atakats;

/**
 *
 * @author h
 */
public class Main {
    public static void main(String[] args) {
        Attack[] attacks = RedTeam.generaAttacks(20);
        
        BlueTeam blueTeam = new BlueTeam();
        
        for (Attack attack : attacks) {
            blueTeam.defensa(attack);
            
            if (blueTeam.getSystemHealth() <= 0) {
                break;
            }
        }
    }
}