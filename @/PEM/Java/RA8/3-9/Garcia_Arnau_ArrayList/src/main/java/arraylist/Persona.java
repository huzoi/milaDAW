/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arraylist;

/**
 *
 * @author h
 */
public class Persona {
    private String nom;
    private String cognoms;
    private String dni;
    private int edat;
    
    public Persona(String nom, String cognoms, String dni, int edat) {
        this.nom = nom;
        this.cognoms = cognoms;
        this.dni = dni;
        this.edat = edat;
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
    
    public String getDni() {
        return dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public int getEdat() {
        return edat;
    }
    
    public void setEdat(int edat) {
        this.edat = edat;
    }
    
    @Override
    public String toString() {
        return "Persona{" +
                "nom='" + nom + '\'' +
                ", cognoms='" + cognoms + '\'' +
                ", dni='" + dni + '\'' +
                ", edat=" + edat +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Persona persona = (Persona) obj;
        return dni.equals(persona.dni);
    }
    
    @Override
    public int hashCode() {
        return dni.hashCode();
    }
}
