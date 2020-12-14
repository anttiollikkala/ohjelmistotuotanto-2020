package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends KiviPaperiSakset {

    private Scanner scanner;
    private Tuomari tuomari;
    private Tekoaly tekoaly;
    
    public KPSTekoaly(Scanner scanner,Tuomari tuomari, Tekoaly tekoaly) {
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