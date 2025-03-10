package Model;

public class Textil extends Producte{
    String composicio;

    public Textil(String nom, int preu, int codi_barres, String composicio) {
        super(nom, preu, codi_barres);
        this.composicio = composicio;
    }
}
