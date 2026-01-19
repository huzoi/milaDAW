import java.util.Scanner;

    public class ExtraureCadena {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s = "Posa els mitjons a la rentadora";

            System.out.println("Text Original: " + s);
            System.out.println("Introdueix el numero de caracters des del final: ");
            int numCaracters = sc.nextInt();

            if (numCaracters > 0 && numCaracters <= s.length()) {
                String subs = s.substring(s.length() - numCaracters);
                System.out.println("Subcadena (Ultims " + numCaracters + " caracters): " + subs);
            } else {
                System.out.println("Numero de caracters no valid");
            }

            sc.close();
        }
    }