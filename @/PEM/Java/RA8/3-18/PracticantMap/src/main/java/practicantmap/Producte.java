/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicantmap;

/**
 *
 * @author h
 */
public class Producte {
    private String nom;
    private String categoria;
    private double preu;
    
    public Producte(String nom, String categoria, double preu) {
        this.nom = nom;
        this.categoria = categoria;
        this.preu = preu;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public double getPreu() {
        return preu;
    }
    
    public void setPreu(double preu) {
        this.preu = preu;
    }
    
    @Override
    public String toString() {
        return "Producte{nom='" + nom + "', categoria='" + categoria + "', preu=" + preu + "€}";
    }
}