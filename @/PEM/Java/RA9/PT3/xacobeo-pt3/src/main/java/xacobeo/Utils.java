/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xacobeo;

/**
 *
 * @author h
 */
public class Utils {

    public static void validarDNI(String dni) throws ExcepcioDNI {
        if (!dni.matches("[0-9]{8}[A-Z]") && !dni.matches("[XYZ][0-9]{7}[A-Z]")) {
            throw new ExcepcioDNI("DNI incorrecte");
        }
    }

    public static boolean validarTemps(String t) {
        return t.matches("\\d{2}:\\d{2}:\\d{2}");
    }
}