package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

public class Main {

    public static void main(String[] args) throws IOException {
        //String studentNr = "12345678";
        String studentNr = "13865371";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats.herokuapp.com/opiskelija/" + studentNr + ".json";

        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        client.executeMethod(method);

        InputStream stream = method.getResponseBodyAsStream();

        String bodyText = IOUtils.toString(stream);

        System.out.println("json-muotoinen data:");
        System.out.println(bodyText);
        
        

        Gson mapper = new Gson();
        Palautukset palautukset = mapper.fromJson(bodyText, Palautukset.class);

        System.out.println("");
        
        System.out.println(palautukset.getPalautukset().get(1).getEtunimi() + " " + palautukset.getPalautukset().get(1).getSukunimi() + " opiskelijanumero " + palautukset.getPalautukset().get(1).getOpiskelijanumero());

        if (palautukset.getPalautukset().get(palautukset.getPalautukset().size() - 1).getEtunimi() == null) {
            System.out.println("Miniprojekti: " + palautukset.getPalautukset().get(palautukset.getPalautukset().size() - 1).getTehtavat() + "\n");
        }

        int tehtyht = 0, tuntyht = 0;
        for (Palautus palautus : palautukset.getPalautukset()) {
            if (palautus.getEtunimi() != null && palautus.getSukunimi() != null) {
                System.out.println("viikko " + palautus.getViikko() + ": " + palautus.getTehtavia() + " teht‰v‰‰ " + palautus.getTehtavat() + "\t\t aikaa kului " + palautus.getTunteja() + " tuntia");
                
                tuntyht += palautus.getTunteja();
                tehtyht += palautus.getTunteja();
            }
            
        }
        System.out.println("\nyhteens‰: " + tehtyht + " teht‰v‰‰ " + tuntyht + " tuntia");
    }
}