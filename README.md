# Supermercat SAPAMERCAT - Aplicació de Gestió de Compres

## Descripció

La multinacional **SAPAMERCAT** ens ha encarregat el disseny d'una aplicació revolucionària que permeti gestionar el carro de la compra, mostrant en temps real el preu dels productes que es vagin afegint. L'aplicació ha de ser capaç de gestionar productes en les categories **alimentació**, **tèxtil** i **electrònica**, amb certes característiques específiques per a cada tipus de producte.

### Característiques Comunes dels Productes:
Cada producte té les següents característiques comunes:
- **Preu**: El valor del producte.
- **Nom**: El nom del producte.
- **Codi de barres**: Un identificador únic per a cada producte.

### Característiques Específiques de Cada Tipus de Producte:

#### Alimentació:
- **Data de caducitat**: Aquesta informació és important per calcular el preu del producte. El preu d'aquest tipus de producte varia segons els dies restants fins a la seva caducitat. La fórmula per calcular-ho és la següent:
``preu = preu - (preu * (1 / (dataCaducitat - dataActual + 1))) + (preu * 0.1)``

#### Tèxtil:
- **Composició Tèxtil**: Un text que indica la composició del producte, que s'ha d'utilitzar per ordenar els productes.

#### Electrònica:
- **Dies de garantia**: Nombre de dies de garantia del producte. El preu d'aquest tipus de producte varia segons els dies de garantia, utilitzant la següent fórmula:
``preu = preu + (preu * (diesGarantia / 365) * 0.1)``

## Funcionalitats de l'Aplicació

### Menú Principal

L'aplicació ha de tenir un menú amb les següents opcions:

1. **Gestió Magatzem i Compres**:
 - **Consulta de productes per caducitat**: Llistar productes segons la seva data de caducitat (els més propers a caducar han de ser processats primer).
 - **Historial de tiquets de compra**: Mantenir un registre de les compres realitzades.
 - **Consulta de productes tèxtils**: Ordenar productes segons la seva composició tèxtil.
 - **Tornar al menú principal**.

2. **Introduir producte**:
 - Permetre a l'usuari afegir productes de diferents tipus:
   - **Alimentació**: Introduir dades d'un producte alimentari.
   - **Tèxtil**: Introduir dades d'un producte tèxtil.
   - **Electrònica**: Introduir dades d'un producte electrònic.
 - **Tornar al menú principal**.

3. **Passar per caixa**:
 - Generar un tiquet de compra que mostri:
   - Dades del supermercat.
   - Detall del producte (nom, unitats, preu unitari, preu total).
   - El total a pagar.
 - Si hi ha productes repetits (mateix codi de barres i preu), mostrar només una vegada amb la quantitat total.
 - Buidar el carro de la compra després de passar per caixa.

4. **Mostrar carro de la compra**:
 - Mostrar tots els productes al carro, indicant la seva descripció i quantitat. Els productes repetits han d'aparèixer amb la mateixa quantitat.

5. **Sortir**: Tancar l'aplicació.

## Requisits Tècnics

### Ús de Col·leccions
Es faran servir **Collections** per gestionar els productes. Es pot utilitzar **List** per emmagatzemar els productes, i dins d'això, **Map** serà útil per identificar productes únics pel seu codi de barres. Es poden utilitzar expressions lambda per recórrer i buscar elements a les col·leccions.

### Interfícies i Comparadors
- Implementar la interfície **Comparable** en una classe que necessiti una ordenació natural.
- Implementar la interfície **Comparator** per permetre comparar productes de diferents maneres (per exemple, per data de caducitat, per preu, etc.).

### Excepcions

#### Excepcions Estàndard:
- **InputMismatchException**: Per gestionar entrades incorrectes de dades.
- **FileNotFoundException**: Per gestionar errors en intentar accedir a arxius.

#### Excepcions Personalitzades:
A continuació, s'han de definir excepcions personalitzades per gestionar certs errors específics a l'aplicació:

- **LimitProductesException**: Es llançarà quan es superi el límit de productes.
- **DataCaducitatException**: Es llançarà quan hi hagi un problema amb la data de caducitat d'un producte.
- **NegatiuException**: Es llançarà quan es detecti un valor negatiu en algun dada.
- **LimitCaracteresException**: Es llançarà quan un text superi el límit de caràcters permès.
- **NotAvailableProduct**: Es llençarà quan no hi hagi un producte disponible.

## Conclusió

L'aplicació dissenyada per **SAPAMERCAT** ha de ser capaç de gestionar de manera eficient el carro de la compra, processant productes de diferents categories, generant tiquets i oferint funcionalitats addicionals com l'ordenació de productes per caducitat, composició tèxtil i gestió de garanties. Tot això amb una sòlida base en l'ús de col·leccions, excepcions i estructures de dades eficients.

