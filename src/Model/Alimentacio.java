package Model;

import java.time.LocalDate;

public class Alimentacio extends Producte{
    private LocalDate data_caducitat;

    public Alimentacio(String nom, int preu, int codi_barres, LocalDate data_caducitat) {
        super(nom, preu, codi_barres);
        this.data_caducitat = data_caducitat;
    }

    @Override
    public double calcularPreu() {
        long diesRestants = LocalDate.now().until(data_caducitat).getDays();
        return preu - preu * (1.0 / (diesRestants + 1)) + (preu * 0.1);
    }
}
