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
public class Summa extends Komento {

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        Integer arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        this.sovellus.plus(arvo);
        Integer laskunTulos = this.sovellus.tulos();
        this.syotekentta.setText("");
        this.tuloskentta.setText("" + laskunTulos);
        if (laskunTulos == 0) {
            this.nollaa.disableProperty().set(true);
        } else {
            this.nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }

}
