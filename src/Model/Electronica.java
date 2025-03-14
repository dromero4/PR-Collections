package Model;

public class Electronica extends Producte{
    int garantia;

    public Electronica(String nom, float preu, String codi_barres, int garantia) {
        super(nom, preu, codi_barres);
        this.garantia = garantia;
    }

    @Override
    public double calcularPreu() {
        return preu + preu*(garantia/365)*0.1;
    }
}
