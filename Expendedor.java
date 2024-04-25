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
            bebidas.addObject(Producto.Bebida.FANTA);
            snacks.addObject(Producto.Snack.PAPAS);
            snacks.addObject(Producto.Snack.CHOCOLATE);
        }
    }

    public Producto comprarProducto(Moneda moneda, int numeroDeposito) throws PagoIncorrectoException, NoHayProductoException {
        Producto producto = null;

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

    public Moneda getVuelto() {
        return vuelto.getObject();
    }

        public class PagoIncorrectoException extends Exception {
            public PagoIncorrectoException() {
                super("Pago incorrecto");
            }
        }
        
        public class NoHayProductoException extends Exception {
            public NoHayProductoException() {
               super("No hay producto disponible");
            }
        }


}
