
package ohtu.verkkokauppa;

import java.util.ArrayList;

public interface Kirjanpito {

    public void lisaaTapahtuma(String tapahtuma);

    public ArrayList<String> getTapahtumat();
}
