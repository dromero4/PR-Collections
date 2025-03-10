package Model;

abstract class Producte {
    String nom;
    int preu;
    int codi_barres;

    public Producte(String nom, int preu, int codi_barres) {
        this.nom = nom;
        this.preu = preu;
        this.codi_barres = codi_barres;
    }

    public int getCodi_barres() {return codi_barres;}

    public int getPreu() {return preu;}

    public String getNom() {return nom;}
    public abstract double calcularPreu();
}
