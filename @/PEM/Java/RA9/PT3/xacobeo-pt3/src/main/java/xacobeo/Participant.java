/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xacobeo;

import java.time.*;
/**
 *
 * @author h
 */
public class Participant {
    private int dorsal;
    private String dni;
    private String nom;
    private LocalDate dataNaixement;
    private String equip;
    private String temps;
    private char sexe;

    public Participant(int dorsal, String dni, String nom, LocalDate dataNaixement, String equip, char sexe) {
        this.dorsal = dorsal;
        this.dni = dni;
        this.nom = nom;
        this.dataNaixement = dataNaixement;
        this.equip = equip;
        this.sexe = sexe;
    }

    public int getDorsal() { return dorsal; }
    public String getDni() { return dni; }
    public String getNom() { return nom; }
    public LocalDate getDataNaixement() { return dataNaixement; }
    public String getEquip() { return equip; }
    public char getSexe() { return sexe; }
    public String getTemps() { return temps; }

    public void setNom(String nom) { this.nom = nom; }
    public void setEquip(String equip) { this.equip = equip; }
    public void setTemps(String temps) { this.temps = temps; }

    public int getEdat() {
        return Period.between(dataNaixement, LocalDate.now()).getYears();
    }

    public char getCategoria() {
        return getEdat() >= 40 ? 'V' : 'S';
    }

    public int tempsSegons() {
        if (temps == null) return Integer.MAX_VALUE;
        String[] t = temps.split(":");
        return Integer.parseInt(t[0])*3600 + Integer.parseInt(t[1])*60 + Integer.parseInt(t[2]);
    }

    public String toString() {
        return dorsal + " | " + dni + " | " + nom + " | " + getCategoria() + " | " + sexe + " | " + (temps==null?"--":temps) + " | " + equip;
    }
}
