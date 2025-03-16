package Model;

import Exceptions.customExceptions.*;

import java.util.Objects;

public abstract class Producte implements Comparable<Producte>{
    String nom;
    float preu;
    int codi_barres;

    public Producte(String nom, float preu, int codi_barres) throws LimitCaracteresException {
        this.nom = nom;
        this.preu = preu;
        this.codi_barres = codi_barres;
    }

    public int getCodi_barres() {return codi_barres;}
    public float getPreu() {return preu;}
    public String getNom() {return nom;}

    public abstract double calcularPreu();

    @Override
    public int compareTo(Producte o) {
        if (o == null) {
            return 1; // Si el otro objeto es null, este objeto debe ser "mayor"
        }

        // Comparar por código de barras
        return Integer.compare(this.codi_barres, o.codi_barres);
    }


    //hashCode per ordenacio de productes
    public int hashCode(){
        return Objects.hash(codi_barres);
    }

    @Override
    public String toString() {
        return nom + " (" + codi_barres + ") - " + calcularPreu() + "€";
    }


}
