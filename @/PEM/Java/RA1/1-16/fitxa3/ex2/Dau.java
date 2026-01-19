import java.util.Random;

public class Dau {
    public static void main(String[] args) {
        Random random = new Random();
        int[] estadistiques = new int[6];
        int totalLlancaments = 1000;
        
        System.out.println("SIMULACIÓ DE " + totalLlancaments + " LLANÇAMENTS D'UN DAU\n");
        
        for (int i = 0; i < totalLlancaments; i++) {
            int resultat = random.nextInt(6) + 1;
            estadistiques[resultat - 1]++;
        }
        
        System.out.println("\nESTADÍSTIQUES:\n");
        for (int i = 0; i < estadistiques.length; i++) {
            double percentatge = (estadistiques[i] * 100.0) / totalLlancaments;
            System.out.println("Número " + (i + 1) + ": " + estadistiques[i] + " vegades (" + 
                             String.format("%.2f", percentatge) + "%)");
        }
        
        System.out.println("\nTotal de llançaments: " + totalLlancaments);
    }
}