package Model;

import Exceptions.customExceptions.*;

public class Textil extends Producte{
    String composicio;

    public Textil(String nom, float preu, int codi_barres, String composicio) throws LimitCaracteresException {
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
