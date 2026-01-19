public class Arrodoniment {
    public static void main(String[] args) {
        double[] valors = {3.2, 3.5, 3.7, -3.2, -3.5, -3.7, 7.14, 9.99};
        
        System.out.println("COMPROVACIÓ D'ARRODONIMENTS\n");
        
        System.out.println("nombre\t\tfloor()\t\tceil()\t\tround()");
        System.out.println("------\t\t-------\t\t------\t\t-------");
        
        for (int i = 0; i < valors.length; i++) {
            double valor = valors[i];
            double floorResultat = Math.floor(valor);
            double ceilResultat = Math.ceil(valor);
            long roundResultat = Math.round(valor);
            
            System.out.println(valor + "\t\t" + floorResultat + "\t\t" + 
                             ceilResultat + "\t\t" + roundResultat);
        }
        
        System.out.println("\nEXPLICACIÓ:");
        System.out.println("- floor(): arrodoneix cap avall (valor enter inferior)");
        System.out.println("- ceil(): arrodoneix cap amunt (valor enter superior)");
        System.out.println("- round(): arrodoneix al valor enter més proper");
    }
}