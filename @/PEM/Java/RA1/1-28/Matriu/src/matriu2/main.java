package matriu2;

public class main {
    public static void Main(String[] args) {
        
        System.out.println("\n=== TEST 1: Constructor 4x4 ===");
        Matriu m1 = new Matriu();
        m1.ompleMatriuAleatoria(20);
        m1.mostraMatriu();
        
        System.out.println("\n=== TEST 2: Constructor 5x5 ===");
        Matriu m2 = new Matriu(5);
        m2.ompleMatriuAleatoria(50);
        m2.mostraMatriu();
        
        System.out.println("\n=== TEST 3: Constructor 3x6 ===");
        Matriu m3 = new Matriu(3, 6);
        m3.ompleMatriuAleatoria(10);
        m3.mostraMatriu();
        
        System.out.println("\n=== TEST 4: Matriu invertida ===");
        m3.mostraMatriuInvertida();
        
        System.out.println("\n=== TEST 5: Assignar valors ===");
        m1.assignaValorPosicio(0, 0, 99);
        m1.assignaValorPosicio(2, 3, 88);
        System.out.println("Fora de rang: " + m1.assignaValorPosicio(5, 5, 77));
        m1.mostraMatriu();
        
        System.out.println("\n=== TEST 6: Mitjana ===");
        System.out.printf("Mitjana: %.2f%n", m1.calculaMitjana());
        
        System.out.println("\n=== TEST 7: Cercar números ===");
        System.out.println("99 existeix? " + m1.cercaNum(99));
        System.out.println("200 existeix? " + m1.cercaNum(200));
        
        System.out.println("\n=== TEST 8: Comptar aparicions ===");
        Matriu m4 = new Matriu(4, 4);
        m4.ompleMatriuAleatoria(5);
        m4.mostraMatriu();
        for (int i = 0; i <= 5; i++) {
            System.out.println(i + " apareix " + m4.comptaNum(i) + " vegades");
        }
        
        System.out.println("\n=== TEST 9: Demo completa 3x3 ===");
        Matriu demo = new Matriu(3);
        demo.ompleMatriuAleatoria(15);
        demo.mostraMatriu();
        demo.mostraMatriuInvertida();
        System.out.printf("Mitjana: %.2f%n", demo.calculaMitjana());
        demo.assignaValorPosicio(1, 1, 100);
        demo.assignaValorPosicio(0, 2, 100);
        demo.mostraMatriu();
        System.out.println("100 apareix " + demo.comptaNum(100) + " vegades");
        System.out.printf("Nova mitjana: %.2f%n", demo.calculaMitjana());
    }
}
