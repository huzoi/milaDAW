/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package personatgesjoc.armes;

/**
 *
 * @author h
 */

public class Espasa extends Arma {
    
    public Espasa(String nom) {
        super(nom, 10);
    }
    
    public Espasa() {
        super(null, 10);
    }
    
    @Override
    public String toString() {
        if (nom != null) {
            return "Espasa [Nom=" + nom + ", Força=" + forca + "]";
        } else {
            return "Espasa [Sense nom, Força=" + forca + "]";
        }
    }
}