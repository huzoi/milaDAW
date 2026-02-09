/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package personatgesjoc.personatges;

/**
 *
 * @author h
 */

public class Guerrer extends Personatge {
    private int armadura;
    
    public Guerrer(String nom, int vida, int atac, int armadura) {
        super(nom, vida, atac);
        this.armadura = armadura;
    }
    
    public int getArmadura() {
        return armadura;
    }
    
    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }
    
    @Override
    public void rebreAtac(int dany) {
        int danyReal = dany - armadura;
        if (danyReal < 0) {
            danyReal = 0;
        }
        vida -= danyReal;
        System.out.println(nom + " bloqueja " + armadura + " de dany amb l'armadura");
        System.out.println(nom + " rep " + danyReal + " de dany. Vida restant: " + vida);
        if (estaMort()) {
            System.out.println(nom + " ha mort!");
        }
    }
    
    @Override
    public String toString() {
        return "Guerrer [Nom=" + nom + ", Vida=" + vida + ", Atac=" + atac + ", Armadura=" + armadura + "]";
    }
}