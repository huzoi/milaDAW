/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package personatgesjoc.personatges;

/**
 *
 * @author h
 */

import java.util.Random;

public class MagAprenent extends Mag {
    
    public MagAprenent(String nom, int vida, int atac, int energiaMagica) {
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
        
        Random random = new Random();
        boolean exitEncanteri = random.nextBoolean();
        
        if (exitEncanteri) {
            energiaMagica -= 10;
            int danyMagic = atac * 2;
            System.out.println(nom + " (Aprenent) ha aconseguit llençar l'encanteri!");
            System.out.println(nom + " llença un atac màgic a " + objectiu.getNom() + " amb força " + danyMagic + "!");
            System.out.println("Energia màgica restant: " + energiaMagica);
            objectiu.rebreAtac(danyMagic);
        } else {
            System.out.println(nom + " (Aprenent) ha fallat l'encanteri!");
            System.out.println(nom + " fa un atac normal a " + objectiu.getNom() + " amb força " + atac);
            objectiu.rebreAtac(atac);
        }
    }
    
    @Override
    public String toString() {
        return "MagAprenent [Nom=" + nom + ", Vida=" + vida + ", Atac=" + atac + ", Energia Màgica=" + energiaMagica + "]";
    }
}