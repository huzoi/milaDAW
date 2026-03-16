/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package arraylist;

/**
 *
 * @author h
 */
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;

public class ProvaArrayList {
    public static void main(String[] args) {
        
        //Llista de qualsevol tipus d'objecte
        ArrayList x1;
        x1 = new ArrayList();
        x1.add(10);
        x1.add("Hola");
        x1.add(45.423F);
        x1.add(new Date(2000 - 1900, 4 - 1, 30));
        x1.add(425.32521);
        x1.add(BigInteger.valueOf(142094214324L));
        
        System.out.println("Llista x1: ");
        
       //Altra manera de fer-ho
        System.out.println("\tAmb un foreach: ");
        for (Object o : x1) {
            System.out.println("\t\t" + o);
        }
        System.out.println("\tCalcul dels quadrats dels valors: ");
        for (Object o : x1) {
            //Com que el compilador no sap que hi ha a la llista....
            //no ens deixa escriure:
            //System.out.prinln(o*o);
            //Hem de fer cast quan estem segurs que es pot fer
            
            if (o instanceof Byte || o instanceof Short || o instanceof Long || o instanceof Integer || o instanceof BigInteger) {
                BigInteger x = BigInteger.valueOf(((Number) o).longValue());
                System.out.println("\t\t" + o + " => " + x.multiply(x));    
            }
            else if (o instanceof Float) {
                Float x = Float.valueOf(((Number) o).floatValue());
                System.out.println("\t\t" + o + "=> " + x * x);
            }
            else if (o instanceof Double || o instanceof BigDecimal) {
                BigDecimal x = BigDecimal.valueOf(((Number) o).doubleValue());
                System.out.println("\t\t" + o + "=> " + x.multiply(x));
            }
            System.out.println("\t\t" + o + "=> No es pot calcular el quadrat");
        }
    }
}