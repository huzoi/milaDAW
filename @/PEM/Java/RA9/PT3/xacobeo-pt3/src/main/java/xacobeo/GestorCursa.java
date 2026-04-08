/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xacobeo;

import java.util.*;
import java.util.stream.*;
/**
 *
 * @author h
 */
public class GestorCursa {

    public void entrarTemps(Collection<Participant> p, Scanner sc) {
        System.out.print("Dorsal: ");
        int d = sc.nextInt(); sc.nextLine();

        p.stream().filter(x -> x.getDorsal()==d).findFirst()
                .ifPresentOrElse(x -> {
                    System.out.print("Temps: ");
                    String t = sc.nextLine();
                    if (Utils.validarTemps(t)) x.setTemps(t);
                    else System.out.println("Format incorrecte");
                }, () -> System.out.println("No existeix"));
    }

    public void classificacioGeneral(Collection<Participant> p) {
        p.stream().filter(x->x.getTemps()!=null)
                .sorted(Comparator.comparingInt(Participant::tempsSegons))
                .forEach(System.out::println);
    }

    public void classificacioCategoria(Collection<Participant> p, char s, char c) {
        p.stream()
                .filter(x->x.getTemps()!=null && x.getSexe()==s && x.getCategoria()==c)
                .sorted(Comparator.comparingInt(Participant::tempsSegons))
                .forEach(System.out::println);
    }

    public void classificacioEquips(Collection<Participant> p) {

    Map<String, List<Participant>> equips = p.stream()
            .filter(x -> x.getTemps() != null && x.getEquip() != null && !x.getEquip().isEmpty())
            .collect(Collectors.groupingBy(Participant::getEquip));

    List<Map.Entry<String, Integer>> ranking = new ArrayList<>();

    for (String eq : equips.keySet()) {

        List<Participant> list = equips.get(eq);

        if (list.size() >= 3) {

            int total = list.stream()
                    .sorted(Comparator.comparingInt(Participant::tempsSegons))
                    .limit(3)
                    .mapToInt(Participant::tempsSegons)
                    .sum();

            ranking.add(new AbstractMap.SimpleEntry<>(eq, total));
        }
    }

    ranking.stream()
            .sorted(Map.Entry.comparingByValue())
            .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }

    public void xacobs(Collection<Participant> p) {
        List<Integer> anys = Arrays.asList(1920,1926,1937,1943,1948,1954,1965,1971,1976,1982,1993,1999,2004,2010,2021,2022);

        p.stream()
                .filter(x->x.getTemps()!=null && anys.contains(x.getDataNaixement().getYear()))
                .sorted(Comparator.comparing(Participant::getNom))
                .forEach(System.out::println);
    }
}