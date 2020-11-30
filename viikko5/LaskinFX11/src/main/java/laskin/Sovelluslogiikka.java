package laskin;

public class Sovelluslogiikka {
 
    private int tulos;
    
    protected Integer edellinen = null;
 
    public void plus(int luku) {
        this.edellinen = this.tulos;
        tulos += luku;
    }
     
    public void miinus(int luku) {
        this.edellinen = this.tulos;
        tulos -= luku;
    }
 
    public void nollaa() {
        this.edellinen = this.tulos;
        tulos = 0;
    }
    
    public void undo() {
        if (this.edellinen != null) {
            tulos = this.edellinen;
        }
    }
 
    public int tulos() {
        return tulos;
    }
}