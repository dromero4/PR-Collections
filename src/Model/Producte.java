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

    public boolean equals(Object o){
        if (this == o) return false;
        if (getClass() != o.getClass()) return false;
        Producte producte = (Producte) o;
        return Objects.equals(codi_barres, producte.codi_barres);
    }

    public int hashCode(){
        return Objects.hash(codi_barres);
    }

    @Override
    public String toString() {
        return nom + " (" + codi_barres + ") - " + calcularPreu() + "€";
    }


}
