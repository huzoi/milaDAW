public class VocalsConsonants {
    public static void main(String[] args) {
        String text = "Hola, com estàs avui?";
        int vocals = 0;
        int consonants = 0;
        String textMinuscules = text.toLowerCase();
        for (int i = 0; i < textMinuscules.length(); i++) {
            char c = textMinuscules.charAt(i);
            if (Character.isLetter(c)) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                    c == 'à' || c == 'è' || c == 'é' || c == 'í' || c == 'ò' || c == 'ó' || c == 'ú') {
                    vocals++;
                } else {
                    consonants++;
                }
            }
        }
        
        System.out.println("Text: " + text);
        System.out.println("Vocals: " + vocals);
        System.out.println("Consonants: " + consonants);
    }
}