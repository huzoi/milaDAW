/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xaco;

/**
 *
 * @author h
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Xacobeo {

    private ArrayList<Participant> participants;

    public Xacobeo() {
        participants = new ArrayList<>();
    }

    public void afegirParticipant(Participant p) {
        participants.add(p);
    }

    public void llistarPerDorsal() {
        Collections.sort(participants, Comparator.comparingInt(Participant::getDorsal));
        System.out.println("Participants ordenats per dorsal:");
        participants.forEach(System.out::println);
    }

    public void llistarPerDNI() {
        Collections.sort(participants, Comparator.comparing(Participant::getDni));
        System.out.println("Participants ordenats per DNI:");
        participants.forEach(System.out::println);
    }

    public void llistarPerNomComplet() {
        Collections.sort(participants, Comparator.comparing((Participant p) -> p.getCognom() + " " + p.getNom()));
        System.out.println("Participants ordenats per cognom i nom:");
        participants.forEach(System.out::println);
    }

    public void llistarPerTemps() {
        Collections.sort(participants, Comparator.comparingInt(Participant::getTempsEnSegons));
        System.out.println("Participants ordenats per temps ascendent:");
        participants.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Xacobeo x = new Xacobeo();

        x.afegirParticipant(new Participant(1, "XXXXXXXXA", "Garcia", "Joan", 2, 30, 15));
        x.afegirParticipant(new Participant(2, "XXXXXXXXB", "Garcia", "Amanda", 2, 25, 30));
        x.afegirParticipant(new Participant(3, "XXXXXXXXC", "Garcia", "Pere", 3, 10, 0));

        x.llistarPerDorsal();
        System.out.println();
        x.llistarPerDNI();
        System.out.println();
        x.llistarPerNomComplet();
        System.out.println();
        x.llistarPerTemps();
    }
}
