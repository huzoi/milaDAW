public class TaulaParaules {
    public static void main(String[] args) {
        String[] paraules = {"web", "IP", "switch", "if/else"};
        
        System.out.println("\n   PARAULES DE LA TAULA   \n");
        for (int i = 0; i < paraules.length; i++) {
            System.out.println(paraules[i]);
        }
        
        System.out.println("\n   CARÀCTER 2 DE LA PRIMERA PARAULA   \n");
        System.out.println("El caràcter 2 de '" + paraules[0] + "' és: " + paraules[0].charAt(2));

        //els indexs en Java comencen a 0 (es a dir; 0 = w / 1 = e / 2 = b)
    }
}