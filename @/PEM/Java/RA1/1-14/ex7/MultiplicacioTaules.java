public class MultiplicacioTaules {
    public static void main(String[] args) {
        int[][] taula1 = {
            {2, 3, 4},
            {1, 3, 6}
        };
        
        int[][] taula2 = {
            {2, 5, 1},
            {3, 2, 3}
        };
        
        int files = taula1.length;
        int columnes = taula1[0].length;
        int[][] resultat = new int[files][columnes];
        
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                resultat[i][j] = taula1[i][j] * taula2[i][j];
            }
        }
        
        System.out.println("TAULA 1:");
        mostrarTaula(taula1);
        
        System.out.println("\nTAULA 2:");
        mostrarTaula(taula2);
        
        System.out.println("\nRESULTAT (Taula1 x Taula2):");
        mostrarTaula(resultat);
    }
    
    public static void mostrarTaula(int[][] taula) {
        for (int i = 0; i < taula.length; i++) {
            for (int j = 0; j < taula[i].length; j++) {
                System.out.print(taula[i][j] + "\t");
            }
            System.out.println();
        }
    }
}