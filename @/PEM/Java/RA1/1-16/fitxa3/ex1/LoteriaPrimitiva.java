import java.util.Random;

public class LoteriaPrimitiva {
    public static void main(String[] args) {
        Random random = new Random();
        int[] boles = new int[6];
        int comptador = 0;
        
        System.out.println("LOTERIA PRIMITIVA - 6 nombres entre 1 i 49\n");
        
        while (comptador < 6) {
            int numero = random.nextInt(49) + 1;
            boolean repetit = false;
            
            for (int i = 0; i < comptador; i++) {
                if (boles[i] == numero) {
                    repetit = true;
                    break;
                }
            }
            
            if (!repetit) {
                boles[comptador] = numero;
                comptador++;
            }
        }
        
        System.out.print("Números sorteats: ");
        for (int i = 0; i < boles.length; i++) {
            System.out.print(boles[i]);
            if (i < boles.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}