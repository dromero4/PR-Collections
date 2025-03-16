package View;


public class view {
    public static void mostrarMenuPrincipal(){
        System.out.println("--- SAPAMERCAT ---");
        System.out.println("1. Gestió de magatzem i compres");
        System.out.println("2. Introduïr producte");
        System.out.println("3. Passar per caixa");
        System.out.println("4. Mostrar el carro de la compra");
        System.out.println("5. Buscar per codi de barres");
        System.out.println("0. Sortir");
    }

    public static void mostrarMenuMagatzem(){
        System.out.println("Magatzem i compres");
        System.out.println("1. Caducitat");
        System.out.println("2. Tiquets de compra");
        System.out.println("3. Composició tèxtil");
        System.out.println("0. Tornar");
    }

    public static void mostrarMenuIntroduïrProducte() {
        System.out.println("Introduïr producte");
        System.out.println("1. Alimentació");
        System.out.println("2. Tèxtil");
        System.out.println("3. Electrònica");
        System.out.println("0. Tornar");
    }

    public static void mostrarMissatge(String missatge, boolean line) {
        if (line) {
            System.out.print(missatge);
        } else {
            System.out.println(missatge);
        }

    }

}
