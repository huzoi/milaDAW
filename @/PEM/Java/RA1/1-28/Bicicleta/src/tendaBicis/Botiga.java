package tendaBicis;

public class Botiga {
    private Bicicleta[] llistat;
    private int numBicis;
    private static final int MAX_BICIS = 20;
    
    public Botiga() {
        this.llistat = new Bicicleta[MAX_BICIS];
        this.numBicis = 0;
    }
    
    public void afegirBicicleta(Bicicleta bici) throws ExcepcioBicicleta {
        if (numBicis >= MAX_BICIS) {
            throw new ExcepcioBicicleta("La botiga està plena, no es poden afegir més bicicletes");
        }
        llistat[numBicis] = bici;
        numBicis++;
        System.out.println("Bicicleta afegida correctament!");
    }
    
    public void venBicicleta(int id) {
        boolean trobada = false;
        for (int i = 0; i < numBicis; i++) {
            if (llistat[i] != null && llistat[i].getId() == id) {
                if (llistat[i].isVenuda()) {
                    System.out.println("La bicicleta amb ID " + id + " ja estava venuda!");
                } else {
                    llistat[i].setVenuda(true);
                    System.out.println("Bicicleta amb ID " + id + " venuda correctament!");
                }
                trobada = true;
                break;
            }
        }
        if (!trobada) {
            System.out.println("No s'ha trobat cap bicicleta amb ID " + id);
        }
    }
    
    public void mostraBicicletes() {
        System.out.println("\n=== BICICLETES A LA VENDA ===");
        boolean hiHaBicis = false;
        for (int i = 0; i < numBicis; i++) {
            if (llistat[i] != null && !llistat[i].isVenuda()) {
                System.out.println(llistat[i]);
                hiHaBicis = true;
            }
        }
        if (!hiHaBicis) {
            System.out.println("No hi ha bicicletes disponibles a la venda.");
        }
        System.out.println();
    }
    
    public void mostraVenudes() {
        System.out.println("\n=== BICICLETES VENUDES ===");
        boolean hiHaVenudes = false;
        for (int i = 0; i < numBicis; i++) {
            if (llistat[i] != null && llistat[i].isVenuda()) {
                System.out.println(llistat[i]);
                hiHaVenudes = true;
            }
        }
        if (!hiHaVenudes) {
            System.out.println("No hi ha bicicletes venudes.");
        }
        System.out.println();
    }
    
    public void netejaHistorialVenudes() {
        System.out.println("\n=== NETEJANT HISTORIAL DE VENUDES ===");
        int numVenudes = 0;
        
        // Compactar l'array: moure les no venudes al principi
        int index = 0;
        for (int i = 0; i < numBicis; i++) {
            if (llistat[i] != null && !llistat[i].isVenuda()) {
                llistat[index] = llistat[i];
                index++;
            } else if (llistat[i] != null && llistat[i].isVenuda()) {
                numVenudes++;
            }
        }
        
        // Posar a null les posicions sobrants
        for (int i = index; i < numBicis; i++) {
            llistat[i] = null;
        }
        
        numBicis = index;
        System.out.println("S'han eliminat " + numVenudes + " bicicletes venudes.");
        System.out.println("Bicicletes restants a la botiga: " + numBicis);
    }
    
    public int getNumBicis() {
        return numBicis;
    }
}