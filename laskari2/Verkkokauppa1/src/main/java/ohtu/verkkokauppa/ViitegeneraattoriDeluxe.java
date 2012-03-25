package ohtu.verkkokauppa;

import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: juho
 * Date: 3/25/12
 * Time: 8:48 PM
 * To change this template use File | Settings | File Templates.
 */

@Component
public class ViitegeneraattoriDeluxe implements Viitegeneraattori {

    private int seuraava;

    public ViitegeneraattoriDeluxe(){
        seuraava = 1;
    }

    public int uusi(){
        return seuraava++;
    }
}
