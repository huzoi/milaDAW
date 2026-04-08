/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xacobeo;

import java.util.*;
/**
 *
 * @author h
 */
public class XacobeoPt3 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        GestorParticipants gp = new GestorParticipants();
        GestorCursa gc = new GestorCursa();

        int op;
        do {
            System.out.println("1.Mode Inscripció 2.Mode Cursa 0.Sortir");
            op = sc.nextInt(); sc.nextLine();

            switch(op) {
                case 1: menuInscripcio(gp); break;
                case 2: menuCursa(gp, gc); break;
            }
        } while(op != 0);
    }

    static void menuInscripcio(GestorParticipants gp) {
        int op;
        do {
            System.out.println("--- INSCRIPCIÓ ---");
            System.out.println("1.Alta 2.Consultar 3.Eliminar DNI 4.Eliminar Dorsal 5.Modificar 6.Llistar DNI 7.Llistar Dorsal 8.Llistar Edat 9.Guardar 10.Carregar 0.Sortir");
            op = sc.nextInt(); sc.nextLine();

            switch(op) {
                case 1: gp.alta(sc); break;
                case 2: gp.consultar(sc); break;
                case 3: gp.eliminarDNI(sc); break;
                case 4: gp.eliminarDorsal(sc); break;
                case 5: gp.modificar(sc); break;
                case 6: gp.getTots().forEach(System.out::println); break;
                case 7: gp.llistarPerDorsal(); break;
                case 8: gp.llistarPerEdat(); break;
                case 9: gp.guardar(); break;
                case 10: gp.carregar(); break;
            }
        } while(op != 0);
    }

    static void menuCursa(GestorParticipants gp, GestorCursa gc) {
        int op;
        do {
            System.out.println("--- CURSA ---");
            System.out.println("1.Entrar Temps 2.General 3.SM 4.SF 5.VM 6.VF 7.Equips 8.Xacobs 0.Sortir");
            op = sc.nextInt(); sc.nextLine();

            switch(op) {
                case 1: gc.entrarTemps(gp.getTots(), sc); break;
                case 2: gc.classificacioGeneral(gp.getTots()); break;
                case 3: gc.classificacioCategoria(gp.getTots(),'M','S'); break;
                case 4: gc.classificacioCategoria(gp.getTots(),'F','S'); break;
                case 5: gc.classificacioCategoria(gp.getTots(),'M','V'); break;
                case 6: gc.classificacioCategoria(gp.getTots(),'F','V'); break;
                case 7: gc.classificacioEquips(gp.getTots()); break;
                case 8: gc.xacobs(gp.getTots()); break;
            }
        } while(op != 0);
    }
}