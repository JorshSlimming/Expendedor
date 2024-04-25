/**
 * Representa un comprador que realiza una transacción de compra en un expendedor.
 */
class Comprador {
    private Producto productoConsumido;
    private int vueltoTotal;
    private int numeroDeposito; // Número de depósito utilizado para la compra

    /**
     * Crea un nuevo comprador que realiza una transacción de compra en el expendedor.
     *
     * @param moneda        La moneda utilizada para la compra.
     * @param numeroDeposito El número de depósito del producto deseado.
     * @param exp           El expendedor donde se realiza la compra.
     */
    public Comprador(Moneda moneda, int numeroDeposito, Expendedor exp) {
        this.numeroDeposito = numeroDeposito; // Asignar numeroDeposito al atributo

        try {
            // Realizar la compra en el expendedor
            productoConsumido = exp.comprarProducto(moneda, numeroDeposito);
            Moneda vuelto;

            // Calcular el vuelto total recibido
            while ((vuelto = exp.getVuelto()) != null) {
                vueltoTotal += vuelto.getValor();
            }
        } catch (Expendedor.PagoIncorrectoException e) {
            System.out.println(e.getMessage());
        } catch (Expendedor.NoHayProductoException e) {
            System.out.println(e.getMessage());
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
