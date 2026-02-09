/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package personatgesjoc.armes;

/**
 *
 * @author h
 */

public class Dagga extends Arma {
    
    public Dagga(String nom) {
        super(nom, 6);
    }
    
    public Dagga() {
        super(null, 6);
    }
    
    @Override
    public String toString() {
        if (nom != null) {
            return "Dagga [Nom=" + nom + ", Força=" + forca + "]";
        } else {
            return "Dagga [Sense nom, Força=" + forca + "]";
        }
    }
}
