/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package personatgesjoc.personatges;

/**
 *
 * @author h
 */

import personatgesjoc.armes.Arma;
import personatgesjoc.armes.Arc;

public class Personatge {
    protected String nom;
    protected int vida;
    protected int atac;
    protected Arma arma;
    
    public Personatge(String nom, int vida, int atac) {
        this.nom = nom;
        this.vida = vida;
        this.atac = atac;
        this.arma = null;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public int getVida() {
        return vida;
    }
    
    public void setVida(int vida) {
        this.vida = vida;
    }
    
    public int getAtac() {
        return atac;
    }
    
    public void setAtac(int atac) {
        this.atac = atac;
    }
    
    public Arma getArma() {
        return arma;
    }
    
    public void agafarArma(Arma arma) {
        this.arma = arma;
        System.out.println(nom + " ha agafat l'arma: " + arma);
    }
    
    public boolean estaMort() {
        return vida <= 0;
    }
    
    public void atacar(Personatge objectiu) {
        if (this.estaMort()) {
            System.out.println(nom + " està mort i no pot atacar!");
            return;
        }
        
        int forcaTotal = atac;
        boolean ambArma = false;
        
        if (arma != null && arma.potUtilitzar()) {
            forcaTotal += arma.getForca();
            ambArma = true;
            
            if (arma instanceof Arc) {
                ((Arc) arma).utilitzar();
                System.out.println(nom + " dispara amb " + arma + " a " + objectiu.getNom() + " amb força " + forcaTotal);
            } else {
                System.out.println(nom + " ataca amb " + arma + " a " + objectiu.getNom() + " amb força " + forcaTotal);
            }
        } else {
            System.out.println(nom + " ataca a " + objectiu.getNom() + " amb força " + forcaTotal);
        }
        
        objectiu.rebreAtac(forcaTotal);
    }
    
    public void rebreAtac(int dany) {
        vida -= dany;
        System.out.println(nom + " rep " + dany + " de dany. Vida restant: " + vida);
        if (estaMort()) {
            System.out.println(nom + " ha mort!");
        }
    }
    
    @Override
    public String toString() {
        String armaInfo = (arma != null) ? ", Arma=" + arma : ", Sense arma";
        return "Personatge [Nom=" + nom + ", Vida=" + vida + ", Atac=" + atac + armaInfo + "]";
    }
}