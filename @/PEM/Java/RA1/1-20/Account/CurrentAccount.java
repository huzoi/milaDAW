public class CurrentAccount {
    String id;
    public String name;
    private double balance;
    private AccountManager manager;
    public static String bankName;
    
    public CurrentAccount(String id) {
        this.id = id;
        this.name = "";
        this.balance = 0;
        this.manager = null;
    }
    
    public CurrentAccount(String id, String name) {
        this.id = id;
        this.name = name;
        this.balance = 0;
        this.manager = null;
    }
    
    public CurrentAccount(String id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.manager = null;
    }
    
    public CurrentAccount(String id, String name, double balance, AccountManager manager) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.manager = manager;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        if (id.length() == 9) {
            this.id = id;
        } else {
            System.out.println("Error: El DNI ha de tenir 9 caràcters");
        }
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if (name.length() > 3) {
            this.name = name;
        } else {
            System.out.println("Error: El nom ha de tenir més de 3 caràcters");
        }
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public AccountManager getManager() {
        return manager;
    }
    
    public void setManager(AccountManager manager) {
        this.manager = manager;
    }
    
    public static String getBankName() {
        return bankName;
    }
    
    public static void setBankName(String bankName) {
        CurrentAccount.bankName = bankName;
    }
    
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Saldo insuficient per retirar " + amount + " euros, ves a fer hores");
            return false;
        }
    }
    
    public void deposit(double amount) {
        balance += amount;
    }
    
    public void statement() {
        System.out.println("\n=== EXTRACTE DEL COMPTE ===");
        System.out.println("Banc: " + bankName);
        System.out.println("DNI: " + id);
        System.out.println("Titular: " + name);
        System.out.println("Saldo: " + balance + " euros");
        
        if (manager != null) {
            System.out.println("\nInformació del Gestor:");
            manager.displayInfo();
        } else {
            System.out.println("Sense gestor assignat");
        }
    }
}