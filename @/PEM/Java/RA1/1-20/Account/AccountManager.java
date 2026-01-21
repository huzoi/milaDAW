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
        System.out.println("  Gestor: " + name);
        System.out.println("  Telèfon: " + phone);
        System.out.println("  Import màxim autoritzat: " + maxAmount + " euros");
    }
}