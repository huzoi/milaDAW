/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package matriusgeneriques;

/**
 *
 * @author h
 */
public class Matrix<T> implements Comparable<Matrix<T>> {
    private int numFiles;
    private int numColumnes;
    private T[][] matriu;

    public Matrix(T[][] matriu) {
        if (matriu == null || matriu.length == 0 || matriu[0].length == 0) {
            throw new IllegalArgumentException("La matriu no pot ser buida o nul·la");
        }
        
        this.matriu = matriu;
        this.numFiles = matriu.length;
        this.numColumnes = matriu[0].length;
    }

    public int getNumFiles() {
        return numFiles;
    }

    public int getNumColumnes() {
        return numColumnes;
    }

    public T[][] getMatriu() {
        return matriu;
    }

    public T getValorPos(int fila, int columna) {
        if (fila < 0 || fila >= numFiles) {
            System.out.println("ERROR: La fila " + fila + " està fora de rang (0-" + (numFiles - 1) + ")");
            return null;
        }
        
        if (columna < 0 || columna >= numColumnes) {
            System.out.println("ERROR: La columna " + columna + " està fora de rang (0-" + (numColumnes - 1) + ")");
            return null;
        }
        
        return matriu[fila][columna];
    }

    public void setValorPos(int fila, int columna, T valor) {
        if (fila < 0 || fila >= numFiles) {
            System.out.println("ERROR: La fila " + fila + " està fora de rang (0-" + (numFiles - 1) + ")");
            return;
        }
        
        if (columna < 0 || columna >= numColumnes) {
            System.out.println("ERROR: La columna " + columna + " està fora de rang (0-" + (numColumnes - 1) + ")");
            return;
        }
        
        matriu[fila][columna] = valor;
    }

    public void mostraMatriu() {
        System.out.println("Matriu " + numFiles + "x" + numColumnes + ":");
        for (int i = 0; i < numFiles; i++) {
            for (int j = 0; j < numColumnes; j++) {
                System.out.print(matriu[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null || !(obj instanceof Matrix)) {
            return false;
        }
        
        Matrix<?> altra = (Matrix<?>) obj;
        
        if (this.numFiles != altra.numFiles || this.numColumnes != altra.numColumnes) {
            return false;
        }
        
        if (this.matriu.getClass().getComponentType() != altra.matriu.getClass().getComponentType()) {
            return false;
        }
        
        for (int i = 0; i < numFiles; i++) {
            for (int j = 0; j < numColumnes; j++) {
                if (!this.matriu[i][j].equals(altra.matriu[i][j])) {
                    return false;
                }
            }
        }
        
        return true;
    }

    @Override
    public int compareTo(Matrix<T> altra) {
        int caselles1 = this.numFiles * this.numColumnes;
        int caselles2 = altra.numFiles * altra.numColumnes;
        
        return Integer.compare(caselles1, caselles2);
    }

    public int getTotalCaselles() {
        return numFiles * numColumnes;
    }

    @Override
    public String toString() {
        return "Matrix [" + numFiles + "x" + numColumnes + ", Total caselles: " + getTotalCaselles() + "]";
    }
}