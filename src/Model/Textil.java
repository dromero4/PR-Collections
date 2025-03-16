package Model;

import Exceptions.customExceptions.*;
import java.util.Objects;

public class Textil extends Producte {
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

    // compareTo per ordenar per composició (alfabèticament)
    @Override
    public int compareTo(Producte o) {
        if (o instanceof Textil) {
            return this.composicio.compareTo(((Textil) o).getComposicio());
        }
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " Composició: " + getComposicio();
    }

    // equals: considera igual dos productes tèxtils si tenen el mateix codi de barres i la mateixa composició
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Textil textil = (Textil) o;
        return getCodi_barres() == textil.getCodi_barres() &&
                Objects.equals(composicio, textil.composicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodi_barres(), composicio);
    }
}
