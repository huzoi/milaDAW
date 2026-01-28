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
public class AccountManager {
    
    
    public String name;
    private String phone;
    double maxAmount;
    
    final static double MAXIM = 5000;
    
    public AccountManager(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.maxAmount = MAXIM;
    }

    public AccountManager(String name, String phone, double maxAmount) {
        this.name = name;
        this.phone = phone;
        this.maxAmount = maxAmount;
    }

    String getPhone() {
        return phone;
    }
    
    public void showInfo(){
        System.out.print("Name: " + name);
        System.out.print(" Phone: " + phone);
        System.out.println(" Maximum amount: " + maxAmount);
    }

    @Override
    public String toString(){
        String resultat;
        
        resultat = "Name: " + name + "\n Phone: " + phone +"\n Amount: " + maxAmount + " euros"; 
        
        return resultat;
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
    
    @Override
    public boolean equals (Object AccountManager) {
        if (this == AccountManager) {
            return true;
        }
        if (AccountManager == null || AccountManager.getClass() != this.getClass()) {
            return false;
        }
        AccountManager aux = (AccountManager) AccountManager;
        return name.equals(aux.name);
    }
}
