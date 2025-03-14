package Model;

public class Textil extends Producte{
    String composicio;

    public Textil(String nom, float preu, String codi_barres, String composicio) {
        super(nom, preu, codi_barres);
        this.composicio = composicio;
    }

    @Override
    public double calcularPreu() {
        return preu;
    }
}
