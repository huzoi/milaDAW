package març_setze;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author h
 */
public class Hotel implements Comparable<Hotel> {
    private int idHotel;
    private String zona;
    private int preu;
    
    public Hotel(int idHotel, String zona, int preu) {
        this.idHotel = idHotel;
        this.zona = zona;
        this.preu = preu;
    }
    
    public int getIdHotel() {
        return idHotel;
    }
    
    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }
    
    public String getZona() {
        return zona;
    }
    
    public void setZona(String zona) {
        this.zona = zona;
    }
    
    public int getPreu() {
        return preu;
    }
    
    public void setPreu(int preu) {
        this.preu = preu;
    }
    
    @Override
    public int compareTo(Hotel other) {
        return Integer.compare(this.preu, other.preu);
    }
    
    @Override
    public String toString() {
        return "Hotel{id=" + idHotel + ", zona='" + zona + "', preu=" + preu + "€}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Hotel hotel = (Hotel) obj;
        return idHotel == hotel.idHotel;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(idHotel);
    }
}
