public class MainAccount {
    public static void main(String[] args) {
        
        System.out.println("a) Create two accounts");
        CurrentAccount acc1 = new CurrentAccount("47142368G", "Arnau Garcia");
        CurrentAccount acc2 = new CurrentAccount("12345678A", "Joseba Jartangas", 99000);
        
        System.out.println("b) Bank Operations");
        System.out.println("- Deposit 150$ into Account 1");
        acc1.deposit(150);
        
        System.out.println("- Withdraw 500$ from Account 1");
        acc1.withdraw(500);
        
        System.out.println("- Deposit 200$ into Account 2");
        acc2.deposit(200);
        
        System.out.println("\nc) Show Accounts Information");
        acc1.statement();
        acc2.statement();
        
        System.out.println("d) Access to Properties:");
        System.out.println("acc1.name (public): " + acc1.name);
        System.out.println("acc1.id (package): " + acc1.id);
        System.out.println("Funds (balance) are private and they can not be checked");
        System.out.println("In order to check those, you may use getBalance(): " + acc1.getBalance());
        
        System.out.println("\ne) Initialize bank name");
        CurrentAccount.setBankName("Banc Roig");
        
        System.out.println("\nf) Show bank name");
        System.out.println("Bank name: " + CurrentAccount.getBankName());
        
        System.out.println("\ng) Create two new managers");
        AccountManager amanda = new AccountManager("Amanda", "621 23 45 67");
        AccountManager pere = new AccountManager("Pere", "98 765 43 21", 999);
        
        System.out.println("\nh) Assign manager Amanda to Account 1");
        acc1.setManager(amanda);
        
        System.out.println("\ni) Show accounts information (alongside managers)");
        acc1.statement();
        acc2.statement();
        
        System.out.println("j) Assign new manager Pere to Account 1");
        acc1.setManager(pere);
        
        System.out.println("\nk) Show Account 1 information (alongside it's new manager)");
        acc1.statement();
    }
}