import java.util.Scanner;

public class Scan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Grup: " + sc.next());
        System.out.println("Edat: " + sc.nextInt());
        System.out.println("Telefon: " + sc.nextLine());
        System.out.println("Nota Mitjana: " + sc.nextFloat());

        sc.close();
    }
}