import java.util.Scanner;

public class Persona {
    String nom;
    String dni;
    int edat;

    public static void crearPersona(Persona[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nom: ");
        String nomNew = sc.nextLine();

        System.out.println("DNI: ");
        String dniNew = sc.nextLine();

        System.out.println("Edat: ");
        int edatNew = sc.nextInt();
        
        Persona personaNew = new Persona();
        personaNew.nom = nomNew;
        personaNew.dni = dniNew;
        personaNew.edat = edatNew;

        sc.close();

    }
}