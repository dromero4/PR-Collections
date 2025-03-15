import Model.Alimentacio;
import Model.CarroCompra;
import Model.Electronica;
import Model.Textil;
import View.view;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            view.mostrarMenuPrincipal();
            System.out.println("Quina opcio vols?");
            int opcio = scan.nextInt();
            scan.nextLine();  // Consumir el salto de línea pendiente

            switch (opcio) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    view.mostrarMenuMagatzem();
                    int menu = scan.nextInt();

                    if (menu == 1){
                        CarroCompra.mostrarCarroCaducitat();
                    }
                    break;
                case 2:
                    view.mostrarMenuIntroduïrProducte();
                    int tipus = scan.nextInt();
                    scan.nextLine();  // Consumir el salto de línea pendiente

                    System.out.print("Nom: ");
                    String nom = scan.nextLine();

                    System.out.print("Preu: ");
                    float preu = scan.nextFloat();
                    scan.nextLine();  // Consumir el salto de línea pendiente

                    System.out.print("Codi de barres: ");
                    String codi = scan.nextLine();

                    if (tipus == 1) {
                        System.out.print("Data de caducitat (YYYY-MM-DD): ");
                        LocalDate dataCaducitat = LocalDate.parse(scan.nextLine());
                        CarroCompra.afegirProducte(new Alimentacio(nom, preu, codi, dataCaducitat));
                    } else if (tipus == 2) {
                        System.out.print("Composició: ");
                        String composicio = scan.nextLine();
                        CarroCompra.afegirProducte(new Textil(nom, preu, codi, composicio));
                    } else if (tipus == 3) {
                        System.out.print("Dies de garantia: ");
                        int garantia = scan.nextInt();
                        scan.nextLine();  // Consumir el salto de línea pendiente
                        CarroCompra.afegirProducte(new Electronica(nom, preu, codi, garantia));
                    } else {
                        view.mostrarMenuPrincipal();
                    }
                    break;
                case 4:
                    CarroCompra.mostrarCarro();
                    break;
            }
        } while (true);
    }
}
