import java.util.Scanner;

public class Persona {
    private String nom;
    private String dni;
    private int edat;
    private String telefon;
    private char sexe;
    private double pes;
    private double alcada;
    
    public Persona() {
        this.nom = "";
        this.dni = "";
        this.edat = 0;
        this.telefon = "";
        this.sexe = 'H';
        this.pes = 0;
        this.alcada = 0;
    }
    
    public Persona(String nom, String dni, int edat) {
        this.nom = nom;
        this.dni = dni;
        this.edat = edat;
        this.telefon = "";
        this.sexe = 'H';
        this.pes = 0;
        this.alcada = 0;
    }
    
    public Persona(String nom, String dni, int edat, String telefon) {
        this.nom = nom;
        this.dni = dni;
        this.edat = edat;
        this.telefon = telefon;
        this.sexe = 'H';
        this.pes = 0;
        this.alcada = 0;
    }
    
    public Persona(String nom, String dni, int edat, char sexe, double alcada) {
        this.nom = nom;
        this.dni = dni;
        this.edat = edat;
        this.telefon = "";
        comprovarSexe(sexe);
        this.pes = 0;
        this.alcada = alcada;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getDni() {
        return dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public int getEdat() {
        return edat;
    }
    
    public void setEdat(int edat) {
        this.edat = edat;
    }
    
    public String getTelefon() {
        return telefon;
    }
    
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
    public char getSexe() {
        return sexe;
    }
    
    public void setSexe(char sexe) {
        comprovarSexe(sexe);
    }
    
    public double getPes() {
        return pes;
    }
    
    public void setPes(double pes) {
        this.pes = pes;
    }
    
    public double getAlcada() {
        return alcada;
    }
    
    public void setAlcada(double alcada) {
        this.alcada = alcada;
    }
    
    public int aniversari(int edat) {
        this.edat = edat + 1;
        return this.edat;
    }
    
    public int calcularIMC() {
        if (alcada == 0) {
            return 0;
        }
        double imc = pes / (alcada * alcada);
        if (imc < 20) {
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        } else {
            return 1;
        }
    }
    
    public boolean esMajorEdat() {
        return edat >= 18;
    }
    
    private void comprovarSexe(char sexe) {
        if (sexe == 'H' || sexe == 'D') {
            this.sexe = sexe;
        } else {
            this.sexe = 'H';
        }
    }
    
    public void visualitzar() {
        System.out.println("Nom: " + nom);
        System.out.println("DNI: " + dni);
        System.out.println("Edat: " + edat);
        System.out.println("Telèfon: " + telefon);
        System.out.println("Sexe: " + sexe);
        System.out.println("Pes: " + pes + " kg");
        System.out.println("Alçada: " + alcada + " m");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== CREAR NOVA PERSONA ===\n");
        
        System.out.print("Nom: ");
        String nom = sc.nextLine();
        
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        
        System.out.print("Edat: ");
        int edat = sc.nextInt();
        
        System.out.print("Sexe (H/D): ");
        char sexe = sc.next().charAt(0);
        
        System.out.print("Pes (kg): ");
        double pes = sc.nextDouble();
        
        System.out.print("Alçada (m): ");
        double alcada = sc.nextDouble();
        
        Persona persona = new Persona(nom, dni, edat, sexe, alcada);
        persona.setPes(pes);
        
        System.out.println("\n=== DADES DE LA PERSONA ===");
        persona.visualitzar();
        
        System.out.println("\n=== INFORMACIÓ ADDICIONAL ===");
        if (persona.esMajorEdat()) {
            System.out.println("És major d'edat: Sí");
        } else {
            System.out.println("És major d'edat: No");
        }
        
        int imc = persona.calcularIMC();
        System.out.print("IMC: ");
        if (imc == -1) {
            System.out.println("Per sota del pes ideal");
        } else if (imc == 0) {
            System.out.println("Pes ideal");
        } else {
            System.out.println("Per sobre del pes ideal");
        }
        
        sc.close();
    }
}