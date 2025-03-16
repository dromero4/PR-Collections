package Model;

import Exceptions.customExceptions.*;

public class Electronica extends Producte{
    int garantia;

    public Electronica(String nom, float preu, int codi_barres, int garantia) throws Exception{
        super(nom, preu, codi_barres);
        if (garantia < 0){
            throw new NegatiuException("El numero no pot ser negatiu!");
        }
        this.garantia = garantia;
    }

    public int getGarantia() {
        return garantia;
    }

    @Override
    public double calcularPreu() {
        return preu + preu*(garantia/365)*0.1;
    }

    @Override
    public int compareTo(Producte o) {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " Garantia: " + getGarantia();
    }
}
