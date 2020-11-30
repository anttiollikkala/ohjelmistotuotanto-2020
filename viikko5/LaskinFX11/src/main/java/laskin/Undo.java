/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author anttiollikkala
 */
public class Undo extends Komento {

    public Undo(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        this.sovellus.undo();
        Integer laskunTulos = this.sovellus.tulos();
        this.syotekentta.setText("");
        this.tuloskentta.setText("" + laskunTulos);
        if (laskunTulos == 0) {
            this.nollaa.disableProperty().set(true);
        } else {
            this.nollaa.disableProperty().set(false);
        }
    }

}
