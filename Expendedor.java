/**
 * Clase Expendedor que representa una máquina expendedora de bebidas y snacks.
 */
class Expendedor {
    // Depósitos para las bebidas, snacks y monedas de cambio
    private Deposito<Producto.Bebida> bebidas;
    private Deposito<Producto.Snack> snacks;
    private Deposito<Moneda> vuelto;

    /**
     * Constructor de la clase Expendedor.
     * @param numBebidas Número de bebidas a añadir en el depósito.
     * @param numSnacks Número de snacks a añadir en el depósito.
     */
    public Expendedor(int numBebidas, int numSnacks) {
        // Inicialización de los depósitos
        bebidas = new Deposito<>();
        snacks = new Deposito<>();
        vuelto = new Deposito<>();

        // Añadir productos a los depósitos
        for (int i = 0; i < numBebidas; i++) {
            bebidas.addObject(Producto.Bebida.COCA);
            bebidas.addObject(Producto.Bebida.SPRITE);
            bebidas.addObject(Producto.Bebida.FANTA);
            snacks.addObject(Producto.Snack.PAPAS);
            snacks.addObject(Producto.Snack.CHOCOLATE);
        }
    }

    /**
     * Método para comprar un producto.
     * @param moneda Moneda utilizada para la compra.
     * @param numeroDeposito Número del depósito del producto a comprar.
     * @return Producto comprado.
     * @throws PagoIncorrectoException Si el pago es incorrecto.
     * @throws NoHayProductoException Si no hay producto disponible.
     */
    public Producto comprarProducto(Moneda moneda, int numeroDeposito) throws PagoIncorrectoException, NoHayProductoException {
        Producto producto = null;

        // Selección del producto a comprar
        switch (numeroDeposito) {
            case 1:
                producto = comprarBebida(moneda, Producto.Bebida.COCA);
                break;
            case 2:
                producto = comprarBebida(moneda, Producto.Bebida.SPRITE);
                break;
            case 3:
                producto = comprarSnack(moneda, Producto.Snack.PAPAS);
                break;
            case 4:
                producto = comprarSnack(moneda, Producto.Snack.CHOCOLATE);
                break;
            case 5:
                producto = comprarBebida(moneda, Producto.Bebida.FANTA);
                break;
            default:
                throw new NoHayProductoException();
        }

        return producto;
    }

    /**
     * Método para comprar una bebida.
     * @param moneda Moneda utilizada para la compra.
     * @param bebida Bebida a comprar.
     * @return Producto comprado.
     * @throws PagoIncorrectoException Si el pago es incorrecto.
     * @throws NoHayProductoException Si no hay producto disponible.
     */
    private Producto comprarBebida(Moneda moneda, Producto.Bebida bebida) throws PagoIncorrectoException, NoHayProductoException {
        int precio = bebida.getPrecio();
        if (moneda == null) {
            throw new PagoIncorrectoException();
        }
        if (moneda.getValor() >= precio) {
            bebidas.getObject(); // Sacar la bebida del depósito
            getVuelto(moneda.getValor() - precio);
            return Producto.BEBIDA;
        } else {
            throw new PagoIncorrectoException();
        }
    }

    /**
     * Método para comprar un snack.
     * @param moneda Moneda utilizada para la compra.
     * @param snack Snack a comprar.
     * @return Producto comprado.
     * @throws PagoIncorrectoException Si el pago es incorrecto.
     * @throws NoHayProductoException Si no hay producto disponible.
     */
    private Producto comprarSnack(Moneda moneda, Producto.Snack snack) throws PagoIncorrectoException, NoHayProductoException {
        int precio = snack.getPrecio();
        if (moneda == null) {
            throw new PagoIncorrectoException();
        }
        if (moneda.getValor() >= precio) {
            snacks.getObject();
            getVuelto(moneda.getValor() - precio);
            return Producto.SNACK;
        } else {
            throw new PagoIncorrectoException();
        }
    }

    /**
     * Método para obtener el cambio.
     * @param cambio Cantidad de cambio a devolver.
     */
    private void getVuelto(int cambio) {
        while (cambio >= 100) {
            if (cambio >= 1000) {
                vuelto.addObject(new Moneda1000());
                cambio -= 1000;
            } else if (cambio >= 500) {
                vuelto.addObject(new Moneda500());
                cambio -= 500;
            } else if (cambio >= 100) {
                vuelto.addObject(new Moneda100());
                cambio -= 100;
            }
        }
    }

    /**
     * Método para obtener el cambio.
     * @return Moneda de cambio.
     */
    public Moneda getVuelto() {
        return vuelto.getObject();
    }

    /**
     * Excepción para indicar que el pago es incorrecto.
     */
    public class PagoIncorrectoException extends Exception {
        public PagoIncorrectoException() {
            super("Pago incorrecto");
        }
    }
    
    /**
     * Excepción para indicar que no hay producto disponible.
     */
    public class NoHayProductoException extends Exception {
        public NoHayProductoException() {
           super("No hay producto disponible");
        }
    }
}
