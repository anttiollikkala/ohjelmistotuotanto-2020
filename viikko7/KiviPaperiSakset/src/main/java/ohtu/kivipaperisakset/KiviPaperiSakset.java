/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author anttiollikkala
 */
public abstract class KiviPaperiSakset {

    protected Tuomari tuomari;
    protected Scanner scanner;

    public KiviPaperiSakset(Scanner scanner, Tuomari tuomari) {
        this.tuomari = tuomari;
        this.scanner = scanner;
    }

    // tämä on ns template metodi
    public void pelaa() {
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        while (true) {
            String ekanSiirto = this.ensimmaisenSiirto();
            String tokanSiirto = this.toisenSiirto();
            if (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
                tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
                System.out.println(tuomari);
                System.out.println();
            } else {
                break;
            }
        }
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    protected String ensimmaisenSiirto() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        return scanner.nextLine();
    }

    // tämä on abstrakti metodi sillä sen toteutus vaihtelee eri pelityypeissä
    abstract protected String toisenSiirto();

    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

}
