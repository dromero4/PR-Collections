package Model;

import java.time.LocalDateTime;
import java.util.Map;

public class Tiquet {
    private LocalDateTime data;
    private Map<Producte, Integer> productesComprats;
    private double preuTotal;

    public Tiquet(Map<Producte, Integer> productesComprats, double preuTotal){
        this.data = LocalDateTime.now();
        this.productesComprats = productesComprats;
        this.preuTotal = calcularPreuTotal();
    }

    private double calcularPreuTotal(){
        double total = 0;

        for (Map.Entry<Producte, Integer> entry : productesComprats.entrySet()){
            Producte p = entry.getKey();
            int quantitat = entry.getValue();

            total += p.calcularPreu() * quantitat;
        }

        return total;
    }

    public void imprimirTiquet() {
        System.out.println("-----------------------");
        System.out.println("Sapamercat");
        System.out.println("-----------------------");
        System.out.println("Data: " + data);
        System.out.println("-----------------------");
        for (Map.Entry<Producte, Integer> entry : productesComprats.entrySet()) {
            Producte p = entry.getKey();
            int quantitat = entry.getValue();
            double preuUnitari = p.calcularPreu();
            double preuTotal = preuUnitari * quantitat;

            System.out.printf("%10s x%2d %.2f€ %.2f€ \n", p, quantitat, preuUnitari, preuTotal);

        }

        System.out.println("Preu total carrito: " + calcularPreuTotal() + "€");
    }

}
