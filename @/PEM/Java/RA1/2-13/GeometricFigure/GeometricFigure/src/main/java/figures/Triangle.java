/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package figures;

/**
 *
 * @author h
 */

public class Triangle extends GeometricFigure {
    private double base;
    private double height;
    
    public Triangle(double base, double height, Color color) {
        super(3, color);
        this.base = base;
        this.height = height;
    }
    
    public double getBase() {
        return base;
    }
    
    public void setBase(double base) {
        this.base = base;
    }
    
    public double getHeight() {
        return height;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }
    
    @Override
    public double surface() {
        return (base * height) / 2;
    }
    
    @Override
    public String toString() {
        return "Triangle [Base=" + base + ", Alçada=" + height + ", " + super.toString() + "]";
    }
}