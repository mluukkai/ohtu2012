package ohtu.verkkokauppa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: juho
 * Date: 3/25/12
 * Time: 8:40 PM
 * To change this template use File | Settings | File Templates.
 */


@Component
public class Pankki_Nordea implements Pankki {

    private Kirjanpito kirjanpito;

    @Autowired
    public Pankki_Nordea(Kirjanpito kirjanpito) {
        this.kirjanpito = kirjanpito;
    }

    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }

}
