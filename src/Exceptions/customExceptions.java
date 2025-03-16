package Exceptions;

// Classe principal que conté totes les excepcions personalitzades
public class customExceptions {

    // LimitProductesException: Es llança quan es supera un límit de productes
    public static class LimitProductesException extends Exception {
        public LimitProductesException(String missatge) {
            super(missatge);
        }
    }

    // DataCaducitatException: Es llança quan hi ha un problema amb la data de caducitat
    public static class DataCaducitatException extends Exception {
        public DataCaducitatException(String missatge) {
            super(missatge);
        }
    }

    // NegatiuException: Es llança quan es detecta un valor negatiu
    public static class NegatiuException extends Exception {
        public NegatiuException(String missatge) {
            super(missatge);
        }
    }

    // LimitCaracteresException: Es llança quan un text supera el límit de caràcters permès
    public static class LimitCaracteresException extends Exception {
        public LimitCaracteresException(String missatge) {
            super(missatge);
        }
    }

    // EnumFailException: Es llança quan hi ha un error relacionat amb un Enum
    public static class NotAvailableProduct extends Exception {
        public NotAvailableProduct(String missatge) {
            super(missatge);
        }
    }
}
