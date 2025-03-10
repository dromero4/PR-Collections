package Model;

public class Textil extends Producte{
    String composicio;

    public Textil(String nom, int preu, String codi_barres, String composicio) {
        super(nom, preu, codi_barres);
        this.composicio = composicio;
    }

    @Override
    public double calcularPreu() {
        return preu;
    }
}
