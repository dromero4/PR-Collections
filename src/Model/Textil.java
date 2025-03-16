package Model;

public class Textil extends Producte{
    String composicio;

    public Textil(String nom, float preu, String codi_barres, String composicio) {
        super(nom, preu, codi_barres);
        this.composicio = composicio;
    }

    public String getComposicio() {
        return composicio;
    }

    @Override
    public double calcularPreu() {
        return preu;
    }

    @Override
    public int compareTo(Producte o) {
        if (o instanceof Textil){
            return this.composicio.compareTo(((Textil) o).getComposicio());
        }

        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " Composició: " + getComposicio();
    }
}
