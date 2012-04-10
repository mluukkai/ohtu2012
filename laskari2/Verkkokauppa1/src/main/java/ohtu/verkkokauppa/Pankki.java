package ohtu.verkkokauppa;

public interface Pankki {

    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
}
