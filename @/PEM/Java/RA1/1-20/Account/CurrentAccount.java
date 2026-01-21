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
            System.out.println("Error: ID has to be 9 characters long");
        }
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if (name.length() > 3) {
            this.name = name;
        } else {
            System.out.println("Error: Name has to be more than 3 characters long");
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
            System.out.println("Not enough funds to withdraw " + amount + "$");
            return false;
        }
    }
    
    public void deposit(double amount) {
        balance += amount;
    }
    
    public void statement() {
        System.out.println("\n=== ACCOUNT STATEMENT ===");
        System.out.println("Bank: " + bankName);
        System.out.println("ID: " + id);
        System.out.println("Legal Name: " + name);
        System.out.println("Funds: " + balance + "$");
        
        if (manager != null) {
            System.out.println("\nManager Information: \n");
            manager.displayInfo();
        } else {
            System.out.println("No manager assigned to this account");
        }
    }
}