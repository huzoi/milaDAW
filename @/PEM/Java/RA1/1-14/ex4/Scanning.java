import java.util.Scanner;

public class Scanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introdueix el nom de l'alumne: ");
        String nom = scanner.nextLine();
        
        System.out.print("Introdueix el grup (A o B): ");
        char grup = scanner.next().charAt(0);
        
        System.out.print("Introdueix l'edat: ");
        int edat = scanner.nextInt();
        
        System.out.print("Introdueix el telèfon: ");
        String telefon = scanner.next();
        
        System.out.print("Introdueix la nota mitjana: ");
        double notaMitjana = scanner.nextDouble();
        
        System.out.println("Nom: " + nom);
        System.out.println("Grup: " + grup);
        System.out.println("Edat: " + edat);
        System.out.println("Telèfon: " + telefon);
        System.out.println("Nota mitjana: " + notaMitjana);
        
        scanner.close();
    }
}