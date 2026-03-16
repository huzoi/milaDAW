package març_setze;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author h
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcio;
        
        do {
            mostrarMenu();
            opcio = llegirOpcio(scanner);
            processarOpcio(opcio);
            
            if (opcio != 0) {
                System.out.println("\nPrem Enter per continuar...");
                scanner.nextLine();
            }
            
        } while (opcio != 0);
        
        System.out.println("\nAdéu!");
        scanner.close();
    }
    
    private static void mostrarMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("EXERCICIS: HOTELS I ANIMALS");
        System.out.println("=".repeat(60));
        System.out.println("1. Programa Hotels - HashSet i TreeSet amb filtratge");
        System.out.println("2. Programa QuatrePotes - 10.000 animals amb recompte");
        System.out.println("0. Sortir");
        System.out.println("=".repeat(60));
        System.out.print("Selecciona una opció: ");
    }
    
    private static int llegirOpcio(Scanner scanner) {
        try {
            int opcio = Integer.parseInt(scanner.nextLine());
            return opcio;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private static void processarOpcio(int opcio) {
        System.out.println();
        
        switch (opcio) {
            case 1:
                ProgramaHotels.main(new String[]{});
                break;
            case 2:
                ProgramaQuatrePotes.main(new String[]{});
                break;
            case 0:
                break;
            default:
                System.out.println("Opció no vàlida.");
        }
    }
}
