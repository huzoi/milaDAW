import javax.swing.JOptionPane;

public class NumerosFinsZeroV2 {
    public static void main(String[] args) {
        int[] numeros = new int[100];
        int contador = 0;
        int numero;
        boolean primerZero = false;
        
        do {
            String entrada = JOptionPane.showInputDialog("Introdueix un número (0 per acabar):");
            numero = Integer.parseInt(entrada);
            
            if (numero != 0) {
                numeros[contador] = numero;
                contador++;
            }
        } while (numero != 0);

        if (numero == 0 && contador == 0) {
                primerZero = true;
                JOptionPane.showMessageDialog(null, "El primer nombre ha sigut un 0");
            }

        if (numero == 0 && primerZero == false) {
        String ordreInvers = "NÚMEROS: \n\n";
        for (int i = contador - 1; i >= 0; i--) {
            ordreInvers += numeros[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, ordreInvers);
        }
    }
}