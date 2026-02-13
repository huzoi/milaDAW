/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package figures;

/**
 *
 * @author h
 */

public class Rectangle extends GeometricFigure {
    private double base;
    private double height;
    
    public Rectangle(double base, double height, Color color) {
        super(4, color);
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
        return base * height;
    }
    
    @Override
    public String toString() {
        return "Rectangle [Base=" + base + ", Alçada=" + height + ", " + super.toString() + "]";
    }
}
