import java.util.Scanner;

public class SubcadenaEsquerra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "Avui he sortit a comprar el pa";
        
        System.out.println("Text original: " + text);
        System.out.print("Introdueix la posicio final: ");
        int posicio = scanner.nextInt();
        
        if (posicio > 0 && posicio <= text.length()) {
            String subcadena = text.substring(0, posicio);
            System.out.println("Subcadena (0 a " + posicio + "): " + subcadena);
        } else {
            System.out.println("Posicio no valida");
        }
        
        scanner.close();
    }
}