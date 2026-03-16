/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xaco;

/**
 *
 * @author h
 */
public class Participant {
    private int dorsal;
    private String dni;
    private String cognom;
    private String nom;
    private int hores;
    private int minuts;
    private int segons;

    public Participant(int dorsal, String dni, String cognom, String nom, int hores, int minuts, int segons) {
        this.dorsal = dorsal;
        this.dni = dni;
        this.cognom = cognom;
        this.nom = nom;
        this.hores = hores;
        this.minuts = minuts;
        this.segons = segons;
    }

    public int getDorsal() {
        return dorsal;
    }

    public String getDni() {
        return dni;
    }

    public String getCognom() {
        return cognom;
    }

    public String getNom() {
        return nom;
    }

    public int getHores() {
        return hores;
    }

    public int getMinuts() {
        return minuts;
    }

    public int getSegons() {
        return segons;
    }

    public int getTempsEnSegons() {
        return hores * 3600 + minuts * 60 + segons;
    }

    @Override
    public String toString() {
        return dorsal + " | " + dni + " | " + cognom + " " + nom + " | " + hores + "h " + minuts + "m " + segons + "s";
    }
}