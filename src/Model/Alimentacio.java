package Model;

import Exceptions.customExceptions.*;

import java.time.LocalDate;

public class Alimentacio extends Producte {
    private LocalDate data_caducitat;

    public Alimentacio(String nom, float preu, int codi_barres, LocalDate data_caducitat) throws DataCaducitatException, LimitCaracteresException {
        super(nom, preu, codi_barres);
        if (data_caducitat.isBefore(LocalDate.now())){
            throw new DataCaducitatException("El producte està caducat!");
        }
        this.data_caducitat = data_caducitat;
    }

    @Override
    public double calcularPreu() {
        long diesRestants = LocalDate.now().until(data_caducitat).getDays();

        // Asegúrate de no dividir por cero en caso de que el producto haya caducado (diesRestants <= 0)
        if (diesRestants <= 0) {
            return preu * 0.1; // Si ya ha caducado, el precio es solo el 10% del original (o lo que prefieras)
        }

        // Aplicamos el descuento proporcional según los días restantes y sumamos el 10% extra
        double preuDescompte = preu - (preu * (1.0 / (diesRestants + 1))) + (preu * 0.1);

        // Redondeamos a 2 decimales y retornamos el precio final
        return Math.round(preuDescompte * 100.0) / 100.0;
    }


    public LocalDate getData_caducitat() {
        return data_caducitat;
    }

    @Override
    public int compareTo(Producte o) {
        if (o instanceof Alimentacio){
            return this.data_caducitat.compareTo(((Alimentacio) o).getData_caducitat());
        }

        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " Data caducitat: " + getData_caducitat();
    }
}
