public class Trim {
    public static void main(String[] args) {
        String s = "   Hola bona tarda   ";
        int inici = 0;
        int fi = s.length() - 1;
        
        while (inici <= fi && s.charAt(inici) == ' ') {
            inici++;
        }
        
        while (fi >= inici && s.charAt(fi) == ' ') {
            fi--;
        }
        
        String resultat;
        if (inici > fi) {
            resultat = "";
        } else {
            resultat = s.substring(inici, fi + 1);
        }
        
        System.out.println("Text original: '" + s + "'");
        System.out.println("Text sense espais: '" + resultat + "'");
    }
}