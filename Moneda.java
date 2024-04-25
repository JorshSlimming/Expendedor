/**
 * La clase abstracta Moneda representa una moneda genérica.
 * Implementa la interfaz Comparable para permitir la comparación entre monedas.
 */
public abstract class Moneda implements Comparable<Moneda> {

    /**
     * Constructor por defecto de la clase Moneda.
     */
    public Moneda() {}

    /**
     * Método abstracto que debe ser implementado por las subclases.
     * Devuelve el valor numérico de la moneda.
     *
     * @return El valor de la moneda.
     */
    public abstract int getValor();

    /**
     * Implementación del método compareTo de la interfaz Comparable.
     * Compara dos monedas basándose en sus valores.
     *
     * @param o La moneda con la que se compara.
     * @return Un valor negativo si esta moneda es menor que la moneda dada,
     *         un valor positivo si es mayor, o cero si son iguales en valor.
     */
    @Override
    public int compareTo(Moneda o) {
        return Integer.compare(this.getValor(), o.getValor());
    }
}
