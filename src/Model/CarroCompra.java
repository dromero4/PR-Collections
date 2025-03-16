package Model;

import java.util.*;

public class CarroCompra {
    private static TreeMap<Producte, Integer> productes = new TreeMap<>();
    private static List<Tiquet> historialTiquets = new ArrayList<>();

    public static void afegirProducte(Producte producte) {
        if (!productes.containsKey(producte)){
            productes.put(producte, productes.getOrDefault(producte, 0) + 1);
        }

    }

    public static void mostrarCarro() {
        System.out.println(" --- Carro de la compra --- ");
        if (productes.isEmpty()){
            System.out.println("No hi ha cap producte a la cesta");
            return;
        }
        for (Map.Entry<Producte, Integer> entry : productes.entrySet()) {
            System.out.println(entry.getKey() + " - Quantitat: " + entry.getValue());
        }
    }

    public static void mostrarCarroCaducitat() {
        productes.keySet().stream()
                .filter(producte -> producte instanceof Alimentacio)
                .sorted()
                .forEach(System.out::println);
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

    public static Producte buscarCodiBarres(String codi_barres){
        return productes.keySet().stream()
                .filter(p -> p.getCodi_barres().equals(codi_barres))
                .findFirst()
                .orElse(null);
    }
}
