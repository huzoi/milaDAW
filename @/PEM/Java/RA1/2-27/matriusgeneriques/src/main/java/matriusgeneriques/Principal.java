/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package matriusgeneriques;

/**
 *
 * @author h
 */
public class Principal {
    public static void main(String[] args) {
        
        System.out.println("=== PROVES AMB MATRIUS D'ENTERS ===\n");
        
        Integer[][] matriuEnters1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        Integer[][] matriuEnters2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        Integer[][] matriuEnters3 = {
            {1, 2},
            {3, 4}
        };
        
        Matrix<Integer> m1 = new Matrix<>(matriuEnters1);
        Matrix<Integer> m2 = new Matrix<>(matriuEnters2);
        Matrix<Integer> m3 = new Matrix<>(matriuEnters3);
        
        System.out.println("Matriu 1:");
        m1.mostraMatriu();
        
        System.out.println("Matriu 2:");
        m2.mostraMatriu();
        
        System.out.println("Matriu 3:");
        m3.mostraMatriu();
        
        System.out.println("--- Comparació d'igualtat ---");
        System.out.println("M1 equals M2? " + m1.equals(m2));
        System.out.println("M1 equals M3? " + m1.equals(m3));
        
        System.out.println("\n--- Comparació de mida ---");
        System.out.println("M1 compareTo M2: " + m1.compareTo(m2) + " (0 = iguals)");
        System.out.println("M1 compareTo M3: " + m1.compareTo(m3) + " (positiu = M1 més gran)");
        System.out.println("M3 compareTo M1: " + m3.compareTo(m1) + " (negatiu = M3 més petit)");
        
        System.out.println("\n--- Proves amb getValorPos i setValorPos ---");
        System.out.println("Valor a la posició [1,1] de M1: " + m1.getValorPos(1, 1));
        System.out.println("Canviant el valor de [1,1] a 99...");
        m1.setValorPos(1, 1, 99);
        System.out.println("Nou valor a [1,1]: " + m1.getValorPos(1, 1));
        m1.mostraMatriu();
        
        System.out.println("Intentant accedir fora de rang [5,5]:");
        m1.getValorPos(5, 5);
        
        System.out.println("\n=== PROVES AMB MATRIUS DE CARÀCTERS ===\n");
        
        Character[][] matriuCaracters1 = {
            {'A', 'B', 'C'},
            {'D', 'E', 'F'}
        };
        
        Character[][] matriuCaracters2 = {
            {'A', 'B', 'C'},
            {'D', 'E', 'F'}
        };
        
        Character[][] matriuCaracters3 = {
            {'X', 'Y', 'Z'},
            {'A', 'B', 'C'}
        };
        
        Matrix<Character> mc1 = new Matrix<>(matriuCaracters1);
        Matrix<Character> mc2 = new Matrix<>(matriuCaracters2);
        Matrix<Character> mc3 = new Matrix<>(matriuCaracters3);
        
        System.out.println("Matriu Caràcters 1:");
        mc1.mostraMatriu();
        
        System.out.println("Matriu Caràcters 2:");
        mc2.mostraMatriu();
        
        System.out.println("Matriu Caràcters 3:");
        mc3.mostraMatriu();
        
        System.out.println("--- Comparació d'igualtat ---");
        System.out.println("MC1 equals MC2? " + mc1.equals(mc2));
        System.out.println("MC1 equals MC3? " + mc1.equals(mc3));
        
        System.out.println("\n--- Comparació de mida ---");
        System.out.println("MC1 compareTo MC2: " + mc1.compareTo(mc2));
        System.out.println("MC1 compareTo MC3: " + mc1.compareTo(mc3));
        
        System.out.println("\n=== PROVES AMB MATRIUS DE BOOLEANS ===\n");
        
        Boolean[][] matriuBooleans = {
            {true, false, true},
            {false, true, false}
        };
        
        Matrix<Boolean> mb = new Matrix<>(matriuBooleans);
        
        System.out.println("Matriu Booleans:");
        mb.mostraMatriu();
        
        System.out.println("\n=== PROVES AMB MATRIUS DE DOUBLES ===\n");
        
        Double[][] matriuDoubles = {
            {1.5, 2.7, 3.9},
            {4.1, 5.3, 6.8}
        };
        
        Matrix<Double> md = new Matrix<>(matriuDoubles);
        
        System.out.println("Matriu Doubles:");
        md.mostraMatriu();
        
        System.out.println("\n=== RESUM FINAL ===\n");
        System.out.println(m1);
        System.out.println(m3);
        System.out.println(mc1);
        System.out.println(mb);
        System.out.println(md);
        
        System.out.println("\n=== COMPARACIONS ENTRE DIFERENTS TIPUS ===\n");
        System.out.println("Matriu enters 3x3 vs Matriu caràcters 2x3:");
        if (m1.getTotalCaselles() > mc1.getTotalCaselles()) {
            System.out.println("La matriu d'enters és més gran");
        } else if (m1.getTotalCaselles() < mc1.getTotalCaselles()) {
            System.out.println("La matriu de caràcters és més gran");
        } else {
            System.out.println("Tenen la mateixa quantitat de caselles");
        }
    }
}