package ohtu.kivipaperisakset;

import java.util.Scanner;

import java.util.Scanner;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KiviPaperiSakset {

    private Tuomari tuomari;
    private Scanner scanner;
    private Tekoaly tekoaly;

    public KPSParempiTekoaly(Scanner scanner, Tuomari tuomari, Tekoaly tekoaly) {
        super(scanner, tuomari);
        this.tekoaly = tekoaly;
        this.tuomari = tuomari;
        this.scanner = scanner;
    }

    @Override
    protected String toisenSiirto() {
        String tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        return tokanSiirto;
    }
}
