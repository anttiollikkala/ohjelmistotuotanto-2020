package ohtu.kivipaperisakset;

import java.util.HashMap;
import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tuomari tuomari = new Tuomari();
        
        HashMap valinnat = new HashMap<String,KiviPaperiSakset>();
        valinnat.put("a", Pelitehdas.PvP(scanner, tuomari));
        valinnat.put("b", Pelitehdas.Tekoaly(scanner, tuomari, new TekoalyTavallinen()));
        valinnat.put("c", Pelitehdas.Tekoaly(scanner, tuomari, new TekoalyParannettu(20)));
        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            KiviPaperiSakset peli = (KiviPaperiSakset) valinnat.get(vastaus);
            if (valinnat.get(vastaus) != null) {
                peli.pelaa();
            } else {
                break;
            }
        }

    }
}
