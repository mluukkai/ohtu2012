package ohtu.verkkokauppa;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: juho
 * Date: 3/25/12
 * Time: 8:45 PM
 * To change this template use File | Settings | File Templates.
 */



public class Kirjanpito_laMaestro implements Kirjanpito {

    private ArrayList<String> tapahtumat;

    public Kirjanpito_laMaestro() {
        tapahtumat = new ArrayList<String>();
    }

    public void lisaaTapahtuma(String tapahtuma) {
        tapahtumat.add(tapahtuma);
    }

    public ArrayList<String> getTapahtumat() {
        return tapahtumat;
    }
}
