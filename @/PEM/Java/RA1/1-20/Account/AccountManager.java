//he nombrat els objectes en angles, en aquest arxiu i els altres, i en general els prints tambe ja que prefereixo acostumbrar-me (tampoc puc utilitzar accents sense canviar l'entrada al teclat en espanyol)

public class AccountManager {
    public String name;
    private String phone;
    double maxAmount;
    
    public AccountManager(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.maxAmount = 5000;
    }
    
    public AccountManager(String name, String phone, double maxAmount) {
        this.name = name;
        this.phone = phone;
        this.maxAmount = maxAmount;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void displayInfo() {
        System.out.println("  Manager: " + name);
        System.out.println("  Phone Number: " + phone);
        System.out.println("  Maximum authorized amount:  " + maxAmount + "$");
    }
}