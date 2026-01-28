/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P87654321.uf4.account;

import java.util.Objects;
/**
 *
 * @author Usuari
 */
public class CurrentAccount {
    String id;
    public String name;
    private double balance;
    AccountManager manager;
    
    static private String bankName;
    
    public CurrentAccount(String id) {
        this.id = id;
        this.balance = 0;
    }

    public CurrentAccount(String id, String name) {
        this(id);
        this.name = name;
    }

    public CurrentAccount(String id, String name, double balance) {
        this(id,name);
        this.balance = balance;
    }

    public CurrentAccount(String id, String name, double balance, AccountManager manager) {
        this(id,name,balance);
        this.manager = manager;
    }
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public static String getBankName() {
        return bankName;
    }
    
    public void setId(String id) {
        if(id.length() == 9){
            this.id = id;
        }
    }

    public void setName(String name) {
        if(name.length() > 3){
            this.name = name;
        }
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void setBankName(String bankName) {
        CurrentAccount.bankName = bankName;
    }

    public void setManager(AccountManager manager) {
        this.manager = manager;
    }
    
    void deposit (double quantity){
        balance = balance + quantity;
    }
    
    boolean withdraw (double quantity){
        boolean operationAllowed;
        
        if(balance >= quantity){
            balance = balance - quantity;
            operationAllowed = true;
        } else {
            System.out.println("Not enough money!");
            operationAllowed = false;
        }
        return operationAllowed;
    }
    
    void showStatement (){
        System.out.print("Name: " + name);
        System.out.print(" Id: " + id);
        System.out.println(" Balance: " + balance + " euros");
        
        if (manager != null){
            manager.showInfo();
            
        }
    }
    
    @Override
    public String toString(){
        String resultat;
        
        resultat = "Name: " + name + "\n Id: " + id +"\n Balance: " + balance + " euros"; 
        
        return resultat;
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(id,name);
    }
    
    @Override
    public boolean equals (Object CurrentAccount) {
        if (this == CurrentAccount) {
            return true;
        }
        if (CurrentAccount == null || CurrentAccount.getClass() != this.getClass()) {
            return false;
        }
        CurrentAccount aux = (CurrentAccount) CurrentAccount;
        return id.equals(aux.id);
    }
}
