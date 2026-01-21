public class MainAccount {
    public static void main(String[] args) {
        
        System.out.println("a) Crear dos comptes corrents");
        CurrentAccount compte1 = new CurrentAccount("47142368G", "Arnau Garcia");
        CurrentAccount compte2 = new CurrentAccount("12345678A", "Joseba Jartangas", 99000);
        
        System.out.println("b) Operacions bancàries");
        System.out.println("- Ingressar 150 euros al compte 1");
        compte1.deposit(150);
        
        System.out.println("- Retirar 500 euros al compte 1");
        compte1.withdraw(500);
        
        System.out.println("- Ingressar 200 euros al compte 2");
        compte2.deposit(200);
        
        System.out.println("\nc) Mostrar informació dels comptes");
        compte1.statement();
        compte2.statement();
        
        System.out.println("d) Accés directe als atributs:");
        System.out.println("compte1.name (públic): " + compte1.name);
        System.out.println("compte1.id (package): " + compte1.id);
        System.out.println("El saldo (balance) és privat i NO es pot accedir directament");
        System.out.println("Per accedir-hi cal utilitzar getBalance(): " + compte1.getBalance());
        
        System.out.println("\ne) Inicialitzar nom del banc");
        CurrentAccount.setBankName("Caixa Igual (No et Roba) A.D.A");
        
        System.out.println("\nf) Mostrar nom del banc");
        System.out.println("Nom del banc: " + CurrentAccount.getBankName());
        
        System.out.println("\ng) Crear dos gestors");
        AccountManager amanda = new AccountManager("Amanda", "621 23 45 67");
        AccountManager pere = new AccountManager("Pere", "98 765 43 21", 999);
        
        System.out.println("\nh) Associar l'Amanda al compte 1");
        compte1.setManager(amanda);
        
        System.out.println("\ni) Mostrar informació dels comptes amb gestors");
        compte1.statement();
        compte2.statement();
        
        System.out.println("j) Canviar gestor del compte 1 al Pere");
        compte1.setManager(pere);
        
        System.out.println("\nk) Mostrar compte 1 amb el nou gestor");
        compte1.statement();
    }
}