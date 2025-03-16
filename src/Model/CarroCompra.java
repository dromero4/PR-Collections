package Model;

import java.util.*;

public class CarroCompra {
    private static HashMap<Producte, Integer> productes = new HashMap<>();
    private static List<Tiquet> historialTiquets = new ArrayList<>();

    public static void afegirProducte(Producte producte) {
        productes.put(producte, productes.getOrDefault(producte, 0) + 1);
    }

    public static void mostrarCarro() {
        System.out.println(" --- Carro de la compra --- ");
        for (Map.Entry<Producte, Integer> entry : productes.entrySet()) {
            System.out.println(entry.getKey() + " - Quantitat: " + entry.getValue());
        }
    }

    public static void mostrarCarroCaducitat() {
        List<Producte> aliments = new ArrayList<>();

        for (Producte producte : productes.keySet()) {
            if (producte instanceof Alimentacio) {
                aliments.add(producte);
            }
        }

        Collections.sort(aliments);

        aliments.forEach(System.out::println);
    }

    public static List<Tiquet> getHistorialTiquets() {
        return historialTiquets;
    }

    public static Tiquet passarPerCaixa() {
        if (productes.isEmpty()) {
            return null; // Retorna null si el carrito está vacío
        }

        Map<Producte, Integer> productesTicket = new HashMap<>();
        double preuTotal = 0.0;

        for (Map.Entry<Producte, Integer> entry : productes.entrySet()) {
            Producte p = entry.getKey();
            int quantitat = entry.getValue();
            double preuFinal = p.calcularPreu() * quantitat;

            productesTicket.put(p, quantitat);
            preuTotal += preuFinal;
        }

        Tiquet tiquet = new Tiquet(productesTicket, preuTotal);
        historialTiquets.add(tiquet);
        buidarCarro(); // Vaciar el carro después de la compra

        return tiquet; // Devolvemos el tiquet para que el controlador lo gestione
    }


    public static void buidarCarro() {
        productes.clear();
    }

    public static void ordreComposicio(){
        List<Textil> llistaComposicio = new ArrayList<>();

        for (Producte p : productes.keySet()){
            if (p instanceof Textil) {
                llistaComposicio.add((Textil) p);
            }
        }

        Collections.sort(llistaComposicio);

        llistaComposicio.forEach(System.out::println);
    }
}
