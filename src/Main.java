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
            switch (opcio){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    view.mostrarMenuMagatzem();
                    break;
                case 2:
                    int tipus = view.mostrarMenuIntroduïrProducte(scan);

                    System.out.print("Nom");
                    String nom = scan.nextLine();

                    System.out.print("Preu");
                    float preu = scan.nextFloat();

                    System.out.println("Codi de barres");
                    String codi = scan.next();

                    if (tipus == 1){
                        System.out.print("Data de caducitat: ");
                        LocalDate dataCaducitat = LocalDate.parse(scan.next());
                        CarroCompra.afegirProducte(new Alimentacio(nom, preu, codi, dataCaducitat));
                    } else if (tipus == 2){
                        System.out.print("Composició: ");
                        String composicio = scan.nextLine();
                        CarroCompra.afegirProducte(new Textil(nom, preu, codi, composicio));
                    } else {
                        System.out.print("Dies de garantia: ");
                        int garantia = scan.nextInt();
                        CarroCompra.afegirProducte(new Electronica(nom, preu, codi, garantia));
                    }
                    break;
                case 3:
                    break;
            }
        } while (true);
    }
}