/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package arraylist;

/**
 *
 * @author h
 */
import java.util.ArrayList;

public class ArrayList_Ex01_String {
    public static void main (String[] args) {
        ArrayList<String> ll;
        ll = new ArrayList(100);
        System.out.println("Llargada en punt 1: "+ll.size());
        ll.add("Hola");
        ll.add(null);
        ll.add("Adeu");
        System.out.println("Llargada en punt 2: "+ll.size());
        ll.add(3, "Dema");
        System.out.println("Llargada en punt 3: "+ll.size());
        ll.add(2, "Ara mateix");
        System.out.println("Llargada en punt 4: "+ll.size());
        System.out.println("Contingut de la llista: ");
        for (String s: ll) {
            System.out.println(s);
        }
        System.out.println("Conte adeu? " + ll.contains("adeu"));
        System.out.println("Conte Adeu? " + ll.contains("Adeu"));
        System.out.println("On es adeu? " + ll.indexOf("adeu"));
        System.out.println("On es Adeu? " + ll.indexOf("Adeu"));
        String ss = ll.remove(3);
        System.out.println("Element eliminat: "+ss);
        System.out.println("Contingut de la llisa: ");
        for (String s: ll) {
            System.out.println(s);
        }
        System.out.println("Taula equivalent: ");
        Object t[] = ll.toArray();
        for (Object s: t) {
            System.out.println(s);
        }
    }
}
