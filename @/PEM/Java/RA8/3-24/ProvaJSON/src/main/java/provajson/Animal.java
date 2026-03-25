/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provajson;

/**
 *
 * @author h
 */
public class Animal {
    private int codi;
    private String nom;
    private String especie;
    private double pes;
    private int potes;
    
    public Animal(int codi, String nom, String especie, double pes, int potes) {
        this.codi = codi;
        this.nom = nom;
        this.especie = especie;
        this.pes = pes;
        this.potes = potes;
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
    
    public String getEspecie() {
        return especie;
    }
    
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    
    public double getPes() {
        return pes;
    }
    
    public void setPes(double pes) {
        this.pes = pes;
    }
    
    public int getPotes() {
        return potes;
    }
    
    public void setPotes(int potes) {
        this.potes = potes;
    }
    
    @Override
    public String toString() {
        return "Animal{codi=" + codi + ", nom='" + nom + "', especie='" + especie + "', pes=" + pes + " kg}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Animal animal = (Animal) obj;
        return codi == animal.codi;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(codi);
    }
}
