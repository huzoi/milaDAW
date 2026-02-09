/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package tester;

/**
 *
 * @author h
 */

import personatgesjoc.personatges.Personatge;
import personatgesjoc.personatges.Guerrer;
import personatgesjoc.personatges.Mag;
import personatgesjoc.personatges.MagAprenent;
import personatgesjoc.personatges.MagSuprem;

import personatgesjoc.armes.Arc;
import personatgesjoc.armes.Espasa;
import personatgesjoc.armes.Dagga;


public class MainPersonatges {
   public static void main(String[] args) {
        
        System.out.println("=== CREACIÓ DE PERSONATGES ===\n");
        
        Personatge p1 = new Personatge("Pere", 100, 15);
        Guerrer g1 = new Guerrer("Amanda", 150, 20, 10);
        Mag m1 = new Mag("Ismael", 80, 12, 50);
        MagAprenent ma1 = new MagAprenent("John Doe", 70, 10, 60);
        MagSuprem ms1 = new MagSuprem("Jane Doe", 120, 15, 80);
        
        System.out.println(p1);
        System.out.println(g1);
        System.out.println(m1);
        System.out.println(ma1);
        System.out.println(ms1);
        
        System.out.println("\n=== EQUIPANT ARMES ===\n");
        
        Espasa excalibur = new Espasa("Excalibur");
        Arc arcLlegendari = new Arc("Destinus Arcum");
        Dagga daggaEnverinada = new Dagga("Dagga Enverinada");
        Espasa espasSenseNom = new Espasa();
        
        g1.agafarArma(excalibur);
        p1.agafarArma(arcLlegendari);
        ma1.agafarArma(daggaEnverinada);
        
        System.out.println("\n=== COMBAT 1: Pere (amb arc) vs Amanda (amb espasa) ===\n");
        p1.atacar(g1);
        g1.atacar(p1);
        
        System.out.println("\n=== COMBAT 2: Pere dispara múltiples fletxes ===\n");
        p1.atacar(g1);
        p1.atacar(g1);
        p1.atacar(g1);
        p1.atacar(g1);
        p1.atacar(g1);
        
        System.out.println("\n=== COMBAT 3: Ismael (sense arma) atac màgic vs Amanda ===\n");
        m1.atacMagic(g1);
        
        System.out.println("\n=== COMBAT 4: John Doe (amb dagga) atacs normals i màgics ===\n");
        ma1.atacar(g1);
        ma1.atacMagic(g1);
        ma1.atacMagic(g1);
        
        System.out.println("\n=== COMBAT 5: Jane Doe (sense arma) atac màgic suprem ===\n");
        ms1.atacMagic(g1);
        
        System.out.println("\n=== COMBAT 6: Amanda agafa una nova espasa ===\n");
        g1.agafarArma(espasSenseNom);
        Guerrer g2 = new Guerrer("Enemic", 100, 10, 3);
        g1.atacar(g2);
        
        System.out.println("\n=== ESTAT FINAL DELS PERSONATGES ===\n");
        System.out.println(p1);
        System.out.println(g1);
        System.out.println(m1);
        System.out.println(ma1);
        System.out.println(ms1);
    }
}