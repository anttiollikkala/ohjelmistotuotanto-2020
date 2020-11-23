package ohtu.intjoukkosovellus;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

public class IntJoukko implements Iterable<Integer> {

    public final static int KAPASITEETTI = 5; // aloitustalukon koko
    public final static int OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] luvut;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kapasiteetti2");
        }
        luvut = new int[kapasiteetti];
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {
        boolean kuuluukoJo = kuuluu(luku);
        if (!kuuluukoJo) {
            luvut[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm == luvut.length) {
                kasvata();
            }
            return true;
        }
        return false;
    }
    
    
    public void lisaa(IntJoukko joukko) {
        for(int luku : joukko) {
            lisaa(luku);
        }
    }

    public void kasvata() {
        luvut = Arrays.copyOf(luvut, alkioidenLkm + kasvatuskoko);
    }
    
    public int luvunSijainti(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == luvut[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean kuuluu(int luku) {
        return this.luvunSijainti(luku) != -1;
    }

    public boolean poista(int luku) {
        int kohta = this.luvunSijainti(luku);
        if (kohta != -1) {
            for (int j = kohta; j < alkioidenLkm - 1; j++) {
                luvut[j] = luvut[j + 1];
            }
            alkioidenLkm--;
            return true;
        }
        return false;
    }
    
    
    public void poista(IntJoukko joukko) {
        for(int luku : joukko) {
            poista(luku);
        }
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        String luvut = Arrays.stream(toIntArray())
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        return "{" + luvut + "}";
    }

    public int[] toIntArray() {
        return Arrays.copyOf(this.luvut, alkioidenLkm);
    }

    public static IntJoukko yhdiste(IntJoukko ensimmainen, IntJoukko toinen) {
        IntJoukko joukko = new IntJoukko();
        joukko.lisaa(ensimmainen);
        joukko.lisaa(toinen);
        return joukko;
    }

    public static IntJoukko leikkaus(IntJoukko ensimmainen, IntJoukko toinen) {
        IntJoukko uusiJoukko = new IntJoukko();
        for (int luku : ensimmainen) {
            if(toinen.kuuluu(luku)) {
                uusiJoukko.lisaa(luku);
            }
        }
        return uusiJoukko;
    }

    public static IntJoukko erotus(IntJoukko ensimmainen, IntJoukko toinen) {
        IntJoukko joukko = new IntJoukko();
        joukko.lisaa(ensimmainen);
        joukko.poista(toinen);
        return joukko;
    }

    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> it = new Iterator<Integer>() {

            private int indeksi = 0;

            @Override
            public boolean hasNext() {
                return indeksi < alkioidenLkm;
            }

            @Override
            public Integer next() {
                return luvut[indeksi++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

}
