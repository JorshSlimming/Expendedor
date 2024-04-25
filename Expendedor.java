class Expendedor {
    private Deposito<Producto.Bebida> bebidas;
    private Deposito<Producto.Snack> snacks;
    private Deposito<Moneda> vuelto;

    public Expendedor(int numBebidas, int numSnacks) {
        bebidas = new Deposito<>();
        snacks = new Deposito<>();
        vuelto = new Deposito<>();

        for (int i = 0; i < numBebidas; i++) {
            bebidas.addObject(Producto.Bebida.COCA);
            bebidas.addObject(Producto.Bebida.SPRITE);
            snacks.addObject(Producto.Snack.PAPAS);
            snacks.addObject(Producto.Snack.CHOCOLATE);
        }
    }

    public Producto comprarProducto(Moneda moneda, int numeroDeposito, Producto producto) throws PagoIncorrectoException, NoHayProductoException {
        switch (producto) {
            case BEBIDA:
                switch (numeroDeposito) {
                    case 1:
                        return comprarBebida(moneda, bebidas, Producto.Bebida.COCA);
                    case 2:
                        return comprarBebida(moneda, bebidas, Producto.Bebida.SPRITE);
                    default:
                        throw new NoHayProductoException();
                }
            case SNACK:
                switch (numeroDeposito) {
                    case 1:
                        return comprarSnack(moneda, snacks, Producto.Snack.PAPAS);
                    case 2:
                        return comprarSnack(moneda, snacks, Producto.Snack.CHOCOLATE);
                    default:
                        throw new NoHayProductoException();
                }
            default:
                throw new NoHayProductoException();
        }
    }

    private Producto comprarBebida(Moneda moneda, Deposito<Producto.Bebida> deposito, Producto.Bebida bebida) throws PagoIncorrectoException, NoHayProductoException {
        int precio = bebida.getPrecio();
        if (moneda == null) {
            throw new PagoIncorrectoException();
        }
        if (moneda.getValor() >= precio) {
            deposito.getObject(); // Sacar la bebida del depósito
            getVuelto(moneda.getValor() - precio);
            return Producto.BEBIDA;
        } else {
            throw new PagoIncorrectoException();
        }
    }

    private Producto comprarSnack(Moneda moneda, Deposito<Producto.Snack> deposito, Producto.Snack snack) throws PagoIncorrectoException, NoHayProductoException {
        int precio = snack.getPrecio();
        if (moneda == null) {
            throw new PagoIncorrectoException();
        }
        if (moneda.getValor() >= precio) {
            deposito.getObject();
            getVuelto(moneda.getValor() - precio);
            return Producto.SNACK;
        } else {
            throw new PagoIncorrectoException();
        }
    }

    private void getVuelto(int cambio) {
        while (cambio >= 100) {

            }
        }

        class PagoIncorrectoException extends Exception {
            public PagoIncorrectoException() {
                super("Pago incorrecto");
            }
        }
        
        class NoHayProductoException extends Exception {
            public NoHayProductoException() {
                super("No hay producto disponible");
            }
        }


}
