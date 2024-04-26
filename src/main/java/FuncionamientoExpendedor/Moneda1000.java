package FuncionamientoExpendedor;

/**
 * Representa una moneda de 1000 unidades.
 * Extiende la clase base Moneda.
 */
public class Moneda1000 extends Moneda {

    /**
     * Constructor por defecto para la moneda de 1000 unidades.
     * Llama al constructor de la clase base Moneda.
     */
    public Moneda1000() {
        super();
    }

    /**
     * Obtiene el valor de la moneda (1000 unidades).
     *
     * @return El valor de la moneda (1000).
     */
    public int getValor() {
        return 1000;
    }
}
