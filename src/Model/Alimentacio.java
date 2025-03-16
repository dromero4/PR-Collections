package Model;

import java.time.LocalDate;

public class Alimentacio extends Producte {
    private LocalDate data_caducitat;

    public Alimentacio(String nom, float preu, String codi_barres, LocalDate data_caducitat) {
        super(nom, preu, codi_barres);
        this.data_caducitat = data_caducitat;
    }

    @Override
    public double calcularPreu() {
        long diesRestants = LocalDate.now().until(data_caducitat).getDays();
        return Math.round(preu - preu * (1.0 / (diesRestants + 1)) + (preu * 0.1)) / 100.0;
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
