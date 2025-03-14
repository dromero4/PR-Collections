package Model;

import java.util.HashMap;

public class CarroCompra {
    private static HashMap<Producte, Integer> productes;

    public CarroCompra(){
        productes = new HashMap<>(100);
    }

    public static void afegirProducte(Producte producte){
        productes.put(producte, productes.getOrDefault(producte, 0) + 1);
    }
}
