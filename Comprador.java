class Comprador {
    private String sonido;
    private int vueltoTotal;

    public Comprador(Moneda moneda, int numeroDeposito, Expendedor exp) {
        try {
            Producto producto = exp.comprarProducto(moneda, numeroDeposito);
            sonido = consumirProducto(producto);

            Moneda vuelto;
            while ((vuelto = exp.getVuelto()) != null) {
                vueltoTotal += vuelto.getValor();
            }
        } catch (Expendedor.PagoIncorrectoException e) {
            System.out.println("Pago incorrecto: " + e.getMessage());
        } catch (Expendedor.NoHayProductoException e) {
            System.out.println("No hay producto disponible: " + e.getMessage());
        }
    }

    private String consumirProducto(Producto producto) {
        if (producto != null) {
            switch (producto) {
                case BEBIDA:
                    return "Bebida adquirida";
                case SNACK:
                    return "Snack adquirido";
            }
        }
        return null;
    }

    public int cuantoVuelto() {
        return vueltoTotal;
    }

    public String queBebiste() {
        return sonido;
    }
}
