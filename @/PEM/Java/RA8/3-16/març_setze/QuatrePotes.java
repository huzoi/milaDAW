package març_setze;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author h
 */
public class QuatrePotes {
    private int idAnimal;
    private String tipus;
    
    public QuatrePotes(int idAnimal, String tipus) {
        this.idAnimal = idAnimal;
        this.tipus = tipus;
    }
    
    public int getIdAnimal() {
        return idAnimal;
    }
    
    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }
    
    public String getTipus() {
        return tipus;
    }
    
    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
    
    @Override
    public String toString() {
        return "QuatrePotes{id=" + idAnimal + ", tipus='" + tipus + "'}";
    }
}
