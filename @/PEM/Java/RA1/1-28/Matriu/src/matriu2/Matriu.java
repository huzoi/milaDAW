package matriu2;

import java.util.Random;

public class Matriu {
    private int numFiles;
    private int numColumnes;
    private int[][] matriu;
    
    public Matriu() {
        this.numFiles = 4;
        this.numColumnes = 4;
        this.matriu = new int[numFiles][numColumnes];
    }
    
    public Matriu(int mida) {
        this.numFiles = mida;
        this.numColumnes = mida;
        this.matriu = new int[numFiles][numColumnes];
    }
    
    public Matriu(int files, int columnes) {
        this.numFiles = files;
        this.numColumnes = columnes;
        this.matriu = new int[numFiles][numColumnes];
    }
    
    public int getNumFiles() {
        return numFiles;
    }
    
    public int getNumColumnes() {
        return numColumnes;
    }
    
    public int[][] getMatriu() {
        return matriu;
    }
    
    public int getValor(int fila, int columna) {
        if (fila >= 0 && fila < numFiles && columna >= 0 && columna < numColumnes) {
            return matriu[fila][columna];
        }
        return -1;
    }
    
    public void ompleMatriuAleatoria(int num) {
        Random random = new Random();
        for (int i = 0; i < numFiles; i++) {
            for (int j = 0; j < numColumnes; j++) {
                matriu[i][j] = random.nextInt(num + 1);
            }
        }
    }
    
    public void mostraMatriu() {
        System.out.println("\nMatriu " + numFiles + "x" + numColumnes + ":");
        for (int i = 0; i < numFiles; i++) {
            for (int j = 0; j < numColumnes; j++) {
                System.out.printf("%4d ", matriu[i][j]);
            }
            System.out.println();
        }
    }
    
    public void mostraMatriuInvertida() {
        System.out.println("\nMatriu invertida " + numColumnes + "x" + numFiles + ":");
        for (int j = 0; j < numColumnes; j++) {
            for (int i = 0; i < numFiles; i++) {
                System.out.printf("%4d ", matriu[i][j]);
            }
            System.out.println();
        }
    }
    
    public boolean assignaValorPosicio(int fila, int columna, int num) {
        if (fila >= 0 && fila < numFiles && columna >= 0 && columna < numColumnes) {
            matriu[fila][columna] = num;
            return true;
        }
        return false;
    }
    
    public double calculaMitjana() {
        int suma = 0;
        int totalElements = numFiles * numColumnes;
        
        for (int i = 0; i < numFiles; i++) {
            for (int j = 0; j < numColumnes; j++) {
                suma += matriu[i][j];
            }
        }
        
        return (double) suma / totalElements;
    }
    
    public boolean cercaNum(int num) {
        for (int i = 0; i < numFiles; i++) {
            for (int j = 0; j < numColumnes; j++) {
                if (matriu[i][j] == num) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public int comptaNum(int num) {
        int contador = 0;
        for (int i = 0; i < numFiles; i++) {
            for (int j = 0; j < numColumnes; j++) {
                if (matriu[i][j] == num) {
                    contador++;
                }
            }
        }
        return contador;
    }
}