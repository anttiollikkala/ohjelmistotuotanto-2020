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
public class Pelitehdas {
    
    public static KiviPaperiSakset PvP(Scanner scanner, Tuomari tuomari){
        return new KPSPelaajaVsPelaaja(scanner, tuomari);
    }
    
    public static KiviPaperiSakset Tekoaly(Scanner scanner, Tuomari tuomari, Tekoaly tekoaly){
        return new KPSTekoaly(scanner, tuomari, tekoaly);
    }
    
}
