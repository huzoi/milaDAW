/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package P87654321.uf4.account;

/**
 *
 * @author Usuari
 */
public class MainAccount {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        // a)
        CurrentAccount titular1, titular2;
        titular1 = new CurrentAccount("12345678Z","Peter");
        titular2 = new CurrentAccount("55555555K","Rita", 1000);
        // b)
        titular1.deposit(100);
        titular1.withdraw(500); // Message: "Not enough money"
        titular2.deposit(200);
        // c)
        titular1.showStatement();
        titular2.showStatement();
        // d)
        System.out.println("Intent accés a id: " + titular1.id); // default access
        System.out.println("Intent accés a name: " + titular1.name); // public access
        //System.out.println("Intent accés a balance: " + titular1.balance); //private access
        // e)
        CurrentAccount.setBankName("Caixa Igual (No et Roba) A.D.A");
        // f)
        System.out.println("Nom del banc: " + CurrentAccount.getBankName());
        // g)
        AccountManager manager1, manager2;
        manager1 = new AccountManager("Bea", "69123456");
        manager2 = new AccountManager("Lucas", "934567890", 10000);
        // h)
        titular1.setManager(manager1); // Bea
        // i)
        titular1.showStatement();
        titular2.showStatement();
        // j)
        titular1.setManager(manager2);
        // k)
        titular1.showStatement();
        System.out.println("********** PROVA del mètode toString()*********");
        System.out.println(titular2);
        System.out.println(manager2);
    }
}
