/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xacobeo;

import java.util.*;
import java.time.*;
import java.io.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
/**
 *
 * @author h
 */
public class GestorParticipants {

    private Map<String, Participant> participants = new TreeMap<>();
    private int dorsalCounter = 1;

    public void alta(Scanner sc) {
        try {
            System.out.print("DNI: ");
            String dni = sc.nextLine();
            Utils.validarDNI(dni);

            if (participants.containsKey(dni)) {
                System.out.println("Ja existeix");
                return;
            }

            System.out.print("Nom: ");
            String nom = sc.nextLine();

            System.out.print("Data (yyyy-mm-dd): ");
            LocalDate data = LocalDate.parse(sc.nextLine());

            System.out.print("Equip: ");
            String equip = sc.nextLine();

            System.out.print("Sexe (M/F): ");
            char sexe = sc.nextLine().toUpperCase().charAt(0);

            participants.put(dni, new Participant(dorsalCounter++, dni, nom, data, equip, sexe));

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void consultar(Scanner sc) {
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        System.out.println(participants.getOrDefault(dni, null));
    }

    public void eliminarDNI(Scanner sc) {
        System.out.print("DNI: ");
        participants.remove(sc.nextLine());
    }

    public void eliminarDorsal(Scanner sc) {
        System.out.print("Dorsal: ");
        int d = sc.nextInt(); sc.nextLine();
        participants.values().removeIf(p -> p.getDorsal() == d);
    }

    public void modificar(Scanner sc) {
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        Participant p = participants.get(dni);

        if (p != null) {
            System.out.print("Nou nom: ");
            p.setNom(sc.nextLine());

            System.out.print("Nou equip: ");
            p.setEquip(sc.nextLine());
        }
    }

    public void llistarPerDorsal() {
        participants.values().stream()
                .sorted(Comparator.comparingInt(Participant::getDorsal))
                .forEach(System.out::println);
    }

    public void llistarPerEdat() {
        participants.values().stream()
                .sorted(Comparator.comparing(Participant::getDataNaixement).reversed())
                .forEach(System.out::println);
    }

    public Collection<Participant> getTots() {
        return participants.values();
    }

    public void guardar() {
    try (Writer w = new FileWriter("corredors-inscrits.json")) {

        List<ParticipantJSON> l = new ArrayList<>();

        for (Participant p : participants.values()) {

            ParticipantJSON pj = new ParticipantJSON();

            pj.dorsal = p.getDorsal();
            pj.nom = p.getNom();
            pj.dni = p.getDni();

            if (p.getTemps() != null) {
                String[] t = p.getTemps().split(":");
                pj.hores = Integer.parseInt(t[0]);
                pj.minuts = Integer.parseInt(t[1]);
                pj.segons = Integer.parseInt(t[2]);
            }

            pj.dia = p.getDataNaixement().getDayOfMonth();
            pj.mes = p.getDataNaixement().getMonthValue();
            pj.any = p.getDataNaixement().getYear();

            pj.categoria = String.valueOf(p.getCategoria());
            pj.sexe = String.valueOf(p.getSexe());
            pj.equip = p.getEquip();

            l.add(pj);
        }

        new GsonBuilder().setPrettyPrinting().create().toJson(l, w);

        System.out.println("JSON guardat correctament");

    } catch(Exception e) {
        System.out.println("Error guardant JSON");
        }
    }

    public void carregar() {
    try (Reader r = new FileReader("corredors-inscrits.json")) {

        Gson gson = new Gson();
        List<ParticipantJSON> l = gson.fromJson(r,
                new com.google.gson.reflect.TypeToken<List<ParticipantJSON>>(){}.getType());

        participants.clear();

        for (ParticipantJSON pj : l) {

            if (participants.containsKey(pj.dni)) {
                System.out.println("DNI duplicat ignorat: " + pj.dni);
                continue;
            }

            String temps = String.format("%02d:%02d:%02d",
                    pj.hores, pj.minuts, pj.segons);

            Participant p = new Participant(
                    pj.dorsal,
                    pj.dni,
                    pj.nom,
                    java.time.LocalDate.of(pj.any, pj.mes, pj.dia),
                    pj.equip,
                    pj.sexe.charAt(0)
            );

            p.setTemps(temps);

            participants.put(p.getDni(), p);

            if (pj.dorsal >= dorsalCounter) {
                dorsalCounter = pj.dorsal + 1;
            }
        }

        System.out.println("JSON carregat correctament");

    } catch(Exception e) {
        System.out.println("Error carregant JSON: " + e.getMessage());
    }
}
}