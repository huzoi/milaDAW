/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package figures;

/**
 *
 * @author h
 */

public abstract class GeometricFigure {
    protected int sides;
    protected Color color;
    
    public GeometricFigure(int sides, Color color) {
        this.sides = sides;
        this.color = color;
    }
    
    public int getSides() {
        return sides;
    }
    
    public void setSides(int sides) {
        this.sides = sides;
    }
    
    public Color getColor() {
        return color;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    public abstract double surface();
    
    @Override
    public String toString() {
        return "Costats=" + sides + ", Color=" + color + ", Àrea=" + String.format("%.2f", surface());
    }
}
