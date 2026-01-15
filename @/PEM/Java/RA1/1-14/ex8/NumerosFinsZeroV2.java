import javax.swing.JOptionPane;

public class NumerosFinsZeroV2 {
    public static void main(String[] args) {
        int[] numeros = new int[100];
        int contador = 0;
        int numero;
        
        do {
            String entrada = JOptionPane.showInputDialog("Introdueix un número (0 per acabar):");
            numero = Integer.parseInt(entrada);
            
            if (numero != 0) {
                numeros[contador] = numero;
                contador++;
            }
        } while (numero != 0);

        String ordreInvers = "NÚMEROS: \n\n";
        for (int i = contador - 1; i >= 0; i--) {
            ordreInvers += numeros[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, ordreInvers);
    }
}