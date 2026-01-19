public class SepararParaules {
    public static void main(String[] args) {
        String text = "Avui fa un bon dia";
        
        System.out.println("Text original: " + text);
        System.out.println("Paraules:");
        
        String textNet = text.replaceAll("[.,;:!?]", "");
        String[] paraules = textNet.split("\\s+");
        
        for (int i = 0; i < paraules.length; i++) {
            if (!paraules[i].isEmpty()) {
                System.out.println((i + 1) + ". " + paraules[i]);
            }
        }
    }
}