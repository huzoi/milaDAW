package tendaBicis;

public class Principal {
    public static void main(String[] args) {
        Botiga botiga = new Botiga();
        
        try {
            System.out.println("=== CREANT I AFEGINT BICICLETES ===");

            Bicicleta bici1 = new Bicicleta(1, 21, 29, 'L');
            botiga.afegirBicicleta(bici1);
            
            Bicicleta bici2 = new Bicicleta(2, 18, 26, 'M');
            botiga.afegirBicicleta(bici2);
            
            Bicicleta bici3 = new Bicicleta(3, 24, 27, 'S');
            botiga.afegirBicicleta(bici3);
            
            Bicicleta bici4 = new Bicicleta(4, 21, 29, 'L');
            botiga.afegirBicicleta(bici4);
            
            Bicicleta bici5 = new Bicicleta(5, 6, 20, 'S');
            botiga.afegirBicicleta(bici5);
            
            botiga.mostraBicicletes();
            
            System.out.println("\n=== VENENT BICICLETES ===");
            botiga.venBicicleta(1);
            botiga.venBicicleta(3);
            botiga.venBicicleta(5);

            botiga.venBicicleta(1);

            botiga.venBicicleta(99);

            botiga.mostraBicicletes();

            botiga.mostraVenudes();

            botiga.netejaHistorialVenudes();

            botiga.mostraBicicletes();
            botiga.mostraVenudes();
            
            System.out.println("\n=== AFEGINT MÉS BICICLETES DESPRÉS DE LA NETEJA ===");
            Bicicleta bici6 = new Bicicleta(6, 21, 28, 'M');
            botiga.afegirBicicleta(bici6);
            
            botiga.mostraBicicletes();
            
        } catch (ExcepcioBicicleta e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}