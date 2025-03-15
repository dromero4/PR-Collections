package Model;

import java.util.*;

public class CarroCompra {
    private static HashMap<Producte, Integer> productes = new HashMap<>();;

    public static void afegirProducte(Producte producte) {
        // Aquí ya productes está inicializado, así que se puede usar con seguridad
        productes.put(producte, productes.getOrDefault(producte, 0) + 1);
    }

    public static void mostrarCarro(){
        System.out.println(" --- Carro de la compra --- ");
        for (Producte p : productes.keySet()) {
            System.out.println(p + " - Quantitat: " + productes.get(p));
        }
    }

    public static void mostrarCarroCaducitat(){
        List<Producte> aliments = new ArrayList<>();

        for (Producte producte : productes.keySet()){
            if (producte instanceof Alimentacio){
                aliments.add(producte);
            }
        }

        Collections.sort(aliments);
    }

    public void buidarCarro(){
        productes.clear();
    }
}
