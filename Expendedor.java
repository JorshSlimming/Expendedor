class Expendedor {
    private Deposito<Producto.Bebida> depositoBebidas;
    private Deposito<Producto.Snack> depositoSnacks;
    private Deposito<Moneda> monedasVuelto;

    public Expendedor(int numBebidas, int numSnacks) {
        depositoBebidas = new Deposito<>();
        depositoSnacks = new Deposito<>();
        monedasVuelto = new Deposito<>();

        for (int i = 0; i < numBebidas; i++) {
            depositoBebidas.addObject(Producto.Bebida.COCA);
            depositoBebidas.addObject(Producto.Bebida.SPRITE);
        }

        for (int i = 0; i < numSnacks; i++) {
            depositoSnacks.addObject(Producto.Snack.PAPAS);
            depositoSnacks.addObject(Producto.Snack.CHOCOLATE);
        }
    }

    public Producto comprarProducto(Moneda m, int numeroDeposito, Producto producto) {
        if (m == null) {
            monedasVuelto.addObject(new Moneda0());
            return null;
        }

        Deposito<Producto> deposito;
        switch (producto) {
            case BEBIDA:
                deposito = depositoBebidas;
                break;
            case SNACK:
                deposito = depositoSnacks;
                break;
            default:
                return null;
        }

        if (m.getValor() >= producto.getPrecio()) {
            return deposito.getObject();
        } else {
            monedasVuelto.addObject(m);
            return null;
        }
    }

    public Moneda getVuelto() {
        return monedasVuelto.getObject();
    }
}
