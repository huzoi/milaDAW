/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package figures;

/**
 *
 * @author h
 */

public class Circle extends GeometricFigure {
    private double radius;
    
    public Circle(double radius, Color color) {
        super(0, color);
        this.radius = radius;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double surface() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public String toString() {
        return "Circle [Radi=" + radius + ", " + super.toString() + "]";
    }
}
