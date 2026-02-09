/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package personatgesjoc.armes;

/**
 *
 * @author h
 */

public class Arc extends Arma {
    private int fletxes;
    
    public Arc(String nom) {
        super(nom, 8);
        this.fletxes = 5;
    }
    
    public Arc() {
        super(null, 8);
        this.fletxes = 5;
    }
    
    public int getFletxes() {
        return fletxes;
    }
    
    public void setFletxes(int fletxes) {
        this.fletxes = fletxes;
    }
    
    @Override
    public boolean potUtilitzar() {
        return fletxes > 0;
    }
    
    public void utilitzar() {
        if (fletxes > 0) {
            fletxes--;
        }
    }
    
    @Override
    public String toString() {
        if (nom != null) {
            return "Arc [Nom=" + nom + ", Força=" + forca + ", Fletxes=" + fletxes + "]";
        } else {
            return "Arc [Sense nom, Força=" + forca + ", Fletxes=" + fletxes + "]";
        }
    }
}
