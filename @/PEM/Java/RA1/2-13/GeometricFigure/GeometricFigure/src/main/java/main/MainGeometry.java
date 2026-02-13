/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package main;

/**
 *
 * @author h
 */

import figures.GeometricFigure;
import figures.Rectangle;
import figures.Triangle;
import figures.Circle;
import figures.Color;

public class MainGeometry {
    public static void main(String[] args) {
        
        System.out.println("=== CREACIÓ DE FIGURES GEOMÈTRIQUES ===\n");
        
        Rectangle r1 = new Rectangle(5.0, 10.0, Color.RED);
        Triangle t1 = new Triangle(6.0, 8.0, Color.BLUE);
        Circle c1 = new Circle(7.0, Color.GREEN);
        
        System.out.println(r1);
        System.out.println(t1);
        System.out.println(c1);
        
        System.out.println("\n=== CREANT MÉS FIGURES ===\n");
        
        Rectangle r2 = new Rectangle(12.5, 4.3, Color.BLACK);
        Triangle t2 = new Triangle(10.0, 5.5, Color.WHITE);
        Circle c2 = new Circle(3.2, Color.RED);
        
        System.out.println(r2);
        System.out.println(t2);
        System.out.println(c2);
        
        System.out.println("\n=== ARRAY DE FIGURES ===\n");
        
        GeometricFigure[] figures = new GeometricFigure[6];
        figures[0] = r1;
        figures[1] = t1;
        figures[2] = c1;
        figures[3] = r2;
        figures[4] = t2;
        figures[5] = c2;
        
        for (int i = 0; i < figures.length; i++) {
            System.out.println("Figura " + (i + 1) + ": " + figures[i]);
        }
        
        System.out.println("\n=== CÀLCUL DE L'ÀREA TOTAL ===\n");
        
        double areaTotal = 0;
        for (GeometricFigure figura : figures) {
            areaTotal += figura.surface();
        }
        
        System.out.printf("Àrea total de totes les figures: %.2f%n", areaTotal);
        
        System.out.println("\n=== FIGURES PER COLOR ===\n");
        
        System.out.println("Figures vermelles:");
        for (GeometricFigure figura : figures) {
            if (figura.getColor() == Color.RED) {
                System.out.println("  " + figura);
            }
        }
        
        System.out.println("\nFigures blaves:");
        for (GeometricFigure figura : figures) {
            if (figura.getColor() == Color.BLUE) {
                System.out.println("  " + figura);
            }
        }
    }
}