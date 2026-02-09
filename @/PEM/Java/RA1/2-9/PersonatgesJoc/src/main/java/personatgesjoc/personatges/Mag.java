/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package personatgesjoc.personatges;

/**
 *
 * @author h
 */

public class Mag extends Personatge {
    protected int energiaMagica;
    
    public Mag(String nom, int vida, int atac, int energiaMagica) {
        super(nom, vida, atac);
        this.energiaMagica = energiaMagica;
    }
    
    public int getEnergiaMagica() {
        return energiaMagica;
    }
    
    public void setEnergiaMagica(int energiaMagica) {
        this.energiaMagica = energiaMagica;
    }
    
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
        int danyMagic = atac * 2;
        System.out.println(nom + " llença un atac màgic a " + objectiu.getNom() + " amb força " + danyMagic + "!");
        System.out.println("Energia màgica restant: " + energiaMagica);
        objectiu.rebreAtac(danyMagic);
    }
    
    @Override
    public String toString() {
        String armaInfo = (arma != null) ? ", Arma=" + arma : ", Sense arma";
        return "Mag [Nom=" + nom + ", Vida=" + vida + ", Atac=" + atac + ", Energia Màgica=" + energiaMagica + armaInfo + "]";
    }
}
