package Model;

import java.util.Objects;

abstract class Producte {
    String nom;
    int preu;
    String codi_barres;

    public Producte(String nom, int preu, String codi_barres) {
        this.nom = nom;
        this.preu = preu;
        this.codi_barres = codi_barres;
    }

    public String getCodi_barres() {return codi_barres;}
    public int getPreu() {return preu;}
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
