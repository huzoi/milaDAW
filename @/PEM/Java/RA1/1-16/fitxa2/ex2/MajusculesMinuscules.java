public class MajusculesMinuscules {
    public static void main(String[] args) {
        String text = "Avui he tret a passejar el meu gos Tros";
        
        System.out.println("Text original: " + text);
        System.out.println("Majuscules: " + text.toUpperCase());
        System.out.println("Minuscules: " + text.toLowerCase());
    }
}