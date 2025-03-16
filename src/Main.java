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
                                //Missatge en cas de que no hi hagi cap producte al carro
                                view.mostrarMissatge("Encara no s'han generat tiquets.", false);
                            }  else {
                                for (Tiquet t : CarroCompra.getHistorialTiquets()) {
                                    //Imprimir el tiquet en cuestion
                                    t.imprimirTiquet();
                                }
                            }
                        } else if (menu == 3){
                            //Funcio per ordenar de manera alfabetica la composicio dels productes textils
                            CarroCompra.ordreComposicio();
                        }

                        break;
                    case 2:
                        //Demanar les dades dels productes al client
                        view.mostrarMenuIntroduïrProducte();

                        int tipus = scan.nextInt();
                        scan.nextLine();

                        view.mostrarMissatge("Nom: ", true);
                        String nom = scan.nextLine();

                        view.mostrarMissatge("Preu: ", true);
                        float preu = scan.nextFloat();
                        scan.nextLine();

                        view.mostrarMissatge("Codi de barres: ", true);
                        int codi = scan.nextInt();
                        scan.nextLine();

                        if (tipus == 1) {
                            //En cas de ser un aliment
                            view.mostrarMissatge("Data de caducitat (YYYY-MM-DD): ", true);
                            LocalDate dataCaducitat = LocalDate.parse(scan.nextLine());
                            CarroCompra.afegirProducte(new Alimentacio(nom, preu, codi, dataCaducitat));
                        } else if (tipus == 2) {
                            //En cas de ser un textil
                            view.mostrarMissatge("Composició: ", true);
                            String composicio = scan.nextLine();
                            CarroCompra.afegirProducte(new Textil(nom, preu, codi, composicio));
                        } else if (tipus == 3) {
                            //En cas de ser electronica
                            view.mostrarMissatge("Dies de garantia: ", true);
                            int garantia = scan.nextInt();
                            scan.nextLine();  // Consumir el salto de línea pendiente
                            CarroCompra.afegirProducte(new Electronica(nom, preu, codi, garantia));
                        } else {
                            //Tornar
                            view.mostrarMenuPrincipal();
                        }

                        break;
                    case 3:
                        //En cas de que el client vulgui passar per caixa
                        Tiquet tiquet = CarroCompra.passarPerCaixa();
                        if (tiquet == null){
                            //Missatge per mostrar que no hi ha cap tiquet generat
                            view.mostrarMissatge("El carro està buit, no es pot generar un tiquet", false);
                        } else {
                            //Mostrar tiquet generat
                            tiquet.imprimirTiquet();
                        }
                        break;
                    case 4:
                        CarroCompra.mostrarCarro();
                        break;
                    case 5:
                        //Buscar un producte del teu carret per codi de barres
                        view.mostrarMissatge("Buscar per un codi de barres: ", true);
                        int codi_barres = scan.nextInt();

                        //Variable del producte de codi de barres
                        Producte producte = CarroCompra.buscarCodiBarres(codi_barres);

                        //Verificar si existeix aquest producte
                        if (producte == null){
                            view.mostrarMissatge("El codi de barres no existeix", false);
                        } else {
                            System.out.println(producte);
                        }
                        break;
                }
                } catch (InputMismatchException e) { //Si introdueix un tipus de dades que no correspon a la que es demana
                    System.out.println("Error: Entrada no vàlida. Assegura't d'introduir números on sigui necessari.");
                    scan.nextLine();
                } catch (DateTimeParseException e) { //Si no ha posat correctament la data de caducitat
                    System.out.println("Error: Format de data incorrecte. Usa YYYY-MM-DD.");
                } catch (Exception e) { //Qualsevol altre error customitzat
                    System.out.println("Error: " + e.getMessage());
                }

                //Demanar de manera seguida el menu d'entrada
                // (ja que ja es controla de manera que si apreta el 0 surt del projecte)
            } while (true);

    }
}
