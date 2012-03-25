package ohtu;

import ohtu.verkkokauppa.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/spring-context.xml");
        //Kirjanpito kirjanpito = new Kirjanpito_laMaestro();
        //Kauppa kauppa = new Kauppa(new Varasto_Espoo(kirjanpito), new Pankki_Nordea(kirjanpito), new ViitegeneraattoriDeluxe() );
        //Kauppa kauppa = new Kauppa();
        Kauppa kauppa = ctx.getBean(Kauppa.class);
        Kirjanpito kirjanpito = ctx.getBean(Kirjanpito_laMaestro.class);
        // kauppa hoitaa yhden asiakkaan kerrallaan seuraavaan tapaan:
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(3);
        kauppa.lisaaKoriin(3);
        kauppa.poistaKorista(1);
        kauppa.tilimaksu("Pekka Mikkola", "1234-12345");

        // seuraava asiakas
        kauppa.aloitaAsiointi();
        for (int i = 0; i < 24; i++) {
            kauppa.lisaaKoriin(5);
        }

        kauppa.tilimaksu("Arto Vihavainen", "3425-1652");

        // kirjanpito
        for (String tapahtuma : kirjanpito.getTapahtumat()) {
            System.out.println(tapahtuma);
        }
    }
}
