package Model;


import Exceptions.customExceptions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CarroCompra {
    private static TreeMap<Producte, Integer> productes = new TreeMap<>();
    private static List<Tiquet> historialTiquets = new ArrayList<>();

    //Sistema de productes no disponibles
    //L'he implementat per poder utilitzar l'excepcio FileNotFound
    private static boolean productesNoDisponibles(String nom_producte) throws FileNotFoundException {
        File not_available_products_file = new File("src/not_available_products");

        if (!not_available_products_file.exists()){
            throw new FileNotFoundException("No existeix l'arxiu " + not_available_products_file.getAbsoluteFile());
        }

        Scanner reader = new Scanner(not_available_products_file);

        while (reader.hasNext()){
            String[] notAvailableProducts = reader.nextLine().split(", ");

            for (int i = 0; i < notAvailableProducts.length; i++) {
                if (nom_producte.equals(notAvailableProducts[i])){
                    return false;
                }
            }
        }
        return true;
    }

    public static void afegirProducte(Producte producte) throws LimitProductesException, NotAvailableProduct, FileNotFoundException {
        if (productes.size() > 100){
            //En cas de haver 100 productes, no deixa afegir més
            throw new LimitProductesException("Limit de productes superat!");
        }

        if (!productesNoDisponibles(producte.getNom())){
            //Llançem l'error en cas de no haver el producte que el client busca
            throw new NotAvailableProduct("Aquest producte no el tenim actualment.");
        }

        for (Producte p : productes.keySet()) {
            if (p.getCodi_barres() == producte.getCodi_barres()) {
                throw new NotAvailableProduct("Este producto ya ha sido añadido al carro.");
            }
        }

        //Afegir al array de productes el producte seleccionat (en cas d'estar ja, es suma el key)
        productes.put(producte, productes.getOrDefault(producte, 0) + 1);

    }

    public static void mostrarCarro(){
        System.out.println(" --- Carro de la compra --- ");
        if (productes.isEmpty()){
            System.out.println("No hi ha cap producte a la cesta");
            return;
        }
        for (Map.Entry<Producte, Integer> entry : productes.entrySet()) {
            System.out.println(entry.getKey() + " - Quantitat: " + entry.getValue());
        }
    }

    //lambda amb streams, per ordenar el carro per caducitat
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

    public static Producte buscarCodiBarres(int codi_barres){
        return productes.keySet().stream()
                .filter(p -> p.getCodi_barres() == codi_barres)
                .findFirst()
                .orElse(null);
    }
}
