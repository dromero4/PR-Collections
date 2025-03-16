import Model.*;
import View.view;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

            do {
                try{
                view.mostrarMenuPrincipal();
                view.mostrarMissatge("Quina opcio vols?: ", true);
                int opcio = scan.nextInt();
                scan.nextLine();  // Consumir el salto de línea pendiente

                switch (opcio) {
                    case 0:
                        view.mostrarMissatge("Fins un altra!! :)", false);
                        System.exit(0);
                        break;
                    case 1:
                        view.mostrarMenuMagatzem();

                        int menu = scan.nextInt();

                        if (menu == 1){
                            CarroCompra.mostrarCarroCaducitat();
                        } else if (menu == 2){
                            view.mostrarMissatge("--- HISTORIAL DE TIQUETS --- ", false);
                            if (CarroCompra.getHistorialTiquets().isEmpty()) {
                                view.mostrarMissatge("Encara no s'han generat tiquets.", false);
                            }  else {
                                for (Tiquet t : CarroCompra.getHistorialTiquets()) {
                                    t.imprimirTiquet();
                                }
                            }
                        } else if (menu == 3){
                            CarroCompra.ordreComposicio();
                        }

                        break;
                    case 2:
                        view.mostrarMenuIntroduïrProducte();

                        int tipus = scan.nextInt();
                        scan.nextLine();  // Consumir el salto de línea pendiente

                        view.mostrarMissatge("Nom: ", true);
                        String nom = scan.nextLine();

                        view.mostrarMissatge("Preu: ", true);
                        float preu = scan.nextFloat();
                        scan.nextLine();  // Consumir el salto de línea pendiente

                        view.mostrarMissatge("Codi de barres: ", true);
                        String codi = scan.nextLine();

                        if (tipus == 1) {
                            view.mostrarMissatge("Data de caducitat (YYYY-MM-DD): ", true);
                            LocalDate dataCaducitat = LocalDate.parse(scan.nextLine());
                            CarroCompra.afegirProducte(new Alimentacio(nom, preu, codi, dataCaducitat));
                        } else if (tipus == 2) {
                            view.mostrarMissatge("Composició: ", true);
                            String composicio = scan.nextLine();
                            CarroCompra.afegirProducte(new Textil(nom, preu, codi, composicio));
                        } else if (tipus == 3) {
                            view.mostrarMissatge("Dies de garantia: ", true);
                            int garantia = scan.nextInt();
                            scan.nextLine();  // Consumir el salto de línea pendiente
                            CarroCompra.afegirProducte(new Electronica(nom, preu, codi, garantia));
                        } else {
                            view.mostrarMenuPrincipal();
                        }

                        break;
                    case 3:
                        Tiquet tiquet = CarroCompra.passarPerCaixa();
                        if (tiquet == null){
                            view.mostrarMissatge("El carro està buit, no es pot generar un tiquet", false);
                        } else {
                            tiquet.imprimirTiquet();
                        }
                        break;
                    case 4:
                        CarroCompra.mostrarCarro();
                        break;
                    case 5:
                        view.mostrarMissatge("Buscar per un codi de barres: ", true);
                        String codi_barres = scan.next();

                        Producte producte = CarroCompra.buscarCodiBarres(codi_barres);

                        if (producte == null){
                            view.mostrarMissatge("El codi de barres no existeix", false);
                        } else {
                            System.out.println(producte);
                        }
                        break;
                }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Entrada no vàlida. Assegura't d'introduir números on sigui necessari.");
                    scan.nextLine();
                } catch (DateTimeParseException e) {
                    System.out.println("Error: Format de data incorrecte. Usa YYYY-MM-DD.");
                } catch (Exception e) {
                    System.out.println("S'ha produït un error inesperat: " + e.getMessage());
                }
            } while (true);

    }
}
