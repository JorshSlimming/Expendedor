package FuncionamientoExpendedor;

/**
 * Representa un comprador que realiza una transacción de compra en un expendedor.
 */
class Comprador {
    private final Producto productoConsumido;
    private int vueltoTotal;
    private final int numeroDeposito; // Número de depósito utilizado para la compra

    /**
     * Crea un nuevo comprador que realiza una transacción de compra en el expendedor.
     *
     * @param moneda        La moneda utilizada para la compra.
     * @param numeroDeposito El número de depósito del producto deseado.
     * @param exp           El expendedor donde se realiza la compra.
     * @throws Expendedor.PagoIncorrectoException Si el pago es incorrecto.
     * @throws Expendedor.NoHayProductoException Si no hay producto disponible.
     * @throws Expendedor.PagoInsuficienteException Si el pago es insuficiente.
     */
    public Comprador(Moneda moneda, int numeroDeposito, Expendedor exp)
            throws Expendedor.PagoIncorrectoException, Expendedor.NoHayProductoException, Expendedor.PagoInsuficienteException {
        this.numeroDeposito = numeroDeposito; // Asignar numeroDeposito al atributo

        if (moneda == null) {
            throw new Expendedor.PagoIncorrectoException();
        }

        // Verificar si el numeroDeposito está fuera del rango de productos disponibles
        if (numeroDeposito <= 0 || numeroDeposito > exp.obtenerCantidadTotalProductos()) {
            throw new Expendedor.NoHayProductoException();
        }

        // Realizar la compra en el expendedor
        productoConsumido = exp.comprarProducto(moneda, numeroDeposito);
        if (productoConsumido == null) {
            throw new Expendedor.NoHayProductoException(); // Lanzar excepción si no hay producto disponible
        }

        Moneda vuelto;

        // Calcular el vuelto total recibido
        while ((vuelto = exp.getVuelto()) != null) {
            vueltoTotal += vuelto.getValor();
        }
    }

    /**
     * Obtiene el total del vuelto devuelto al comprador.
     *
     * @return El total del vuelto devuelto.
     */
    public int cuantoVuelto() {
        return vueltoTotal;
    }

    /**
     * Método para obtener el vuelto en monedas de 100.
     * Este método devuelve una moneda de 100 cada vez que es llamado, hasta que el vuelto disponible se agota.
     *
     * @return El valor de una moneda de 100 si hay vuelto disponible, de lo contrario devuelve 0.
     */
    public int getVuelto100() {
        if (vueltoTotal >= 100) {
            vueltoTotal = vueltoTotal - 100;
            return 100;
        }
        return 0;
    }

    /**
     * Obtiene una descripción del producto adquirido por el comprador.
     *
     * @return Una cadena que describe el producto adquirido.
     */
    public String queConsumiste() {
        if (productoConsumido != null) {
            if (numeroDeposito <= 3) {
                return Producto.Bebida.values()[numeroDeposito - 1].getNombre();
            } else {
                return Producto.Snack.values()[numeroDeposito - 3].getNombre();
            }
        } else {
            return "Ningún producto adquirido";
        }
    }
}
