package Model;

import java.time.LocalDate;
import java.util.*;

class Tiquet {
    private List<Producte> productes;
    private LocalDate dataCompra;

    public Tiquet(List<Producte> productes) {
        this.productes = new ArrayList<>(productes);
        this.dataCompra = LocalDate.now();
    }

    public void mostrarTiquet() {
        System.out.println("Supermercat SAPAMERCAT");
        System.out.println("Data de la compra: " + dataCompra);
        double total = 0;
        Map<String, Integer> comptador = new HashMap<>();
        for (Producte p : productes) {
            comptador.put(p.getCodi_barres(), comptador.getOrDefault(p.getCodi_barres(), 0) + 1);
        }
        for (Producte p : productes) {
            if (comptador.containsKey(p.getCodi_barres())) {
                int quantitat = comptador.get(p.getCodi_barres());
                double preuUnitari = p.calcularPreu();
                System.out.println(p.getNom() + " x" + quantitat + " - " + preuUnitari * quantitat + "€");
                total += preuUnitari * quantitat;
                comptador.remove(p.getCodi_barres());
            }
        }
        System.out.println("Total a pagar: " + total + "€");
    }
}