/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package personatgesjoc.personatges;

/**
 *
 * @author h
 */

public final class MagSuprem extends Mag {
    
    public MagSuprem(String nom, int vida, int atac, int energiaMagica) {
        super(nom, vida, atac, energiaMagica);
    }
    
    @Override
    public void atacMagic(Personatge objectiu) {
        if (this.estaMort()) {
            System.out.println(nom + " està mort i no pot atacar!");
            return;
        }
        
        if (energiaMagica < 10) {
            System.out.println(nom + " no té suficient energia màgica! (Necessita 10, té " + energiaMagica + ")");
            return;
        }
        
        energiaMagica -= 10;
        int danyMagic = atac * 3;
        System.out.println(nom + " (Mag Suprem) llença un encanteri devastador!");
        System.out.println(nom + " llança un atac màgic suprem a " + objectiu.getNom() + " amb força " + danyMagic + "!");
        System.out.println("Energia màgica restant: " + energiaMagica);
        objectiu.rebreAtac(danyMagic);
    }
    
    @Override
    public String toString() {
        return "MagSuprem [Nom=" + nom + ", Vida=" + vida + ", Atac=" + atac + ", Energia Màgica=" + energiaMagica + "]";
    }
}