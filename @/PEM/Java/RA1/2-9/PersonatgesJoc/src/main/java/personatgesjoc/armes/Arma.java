/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package personatgesjoc.armes;

/**
 *
 * @author h
 */

public class Arma {
    protected String nom;
    protected int forca;
    
    public Arma(String nom, int forca) {
        this.nom = nom;
        this.forca = forca;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public int getForca() {
        return forca;
    }
    
    public void setForca(int forca) {
        this.forca = forca;
    }
    
    public boolean potUtilitzar() {
        return true;
    }
    
    @Override
    public String toString() {
        if (nom != null) {
            return "Arma [Nom=" + nom + ", Força=" + forca + "]";
        } else {
            return "Arma [Sense nom, Força=" + forca + "]";
        }
    }
}