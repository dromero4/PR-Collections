package Model;

public class Alimentacio extends Producte{
    String data_caducitat;

    public Alimentacio(String nom, int preu, int codi_barres, String data_caducitat) {
        super(nom, preu, codi_barres);
        this.data_caducitat = data_caducitat;
    }
}
