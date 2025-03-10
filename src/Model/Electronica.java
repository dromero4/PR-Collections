package Model;

public class Electronica extends Producte{
    int garantia;

    public Electronica(String nom, int preu, int codi_barres, int garantia) {
        super(nom, preu, codi_barres);
        this.garantia = garantia;
    }
}
