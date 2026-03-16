/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicantset;

/**
 *
 * @author h
 */
public class Alumne {
    private int codi;
    private String nom;
    private String cognoms;
    
    public Alumne(int codi, String nom, String cognoms) {
        this.codi = codi;
        this.nom = nom;
        this.cognoms = cognoms;
    }
    
    public int getCodi() {
        return codi;
    }
    
    public void setCodi(int codi) {
        this.codi = codi;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getCognoms() {
        return cognoms;
    }
    
    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }
    
    @Override
    public String toString() {
        return "Alumne{codi=" + codi + ", nom='" + nom + "', cognoms='" + cognoms + "'}";
    }

    public int compareTo (Alumne p) {
        return this.codi - p.codi;
    }
}

