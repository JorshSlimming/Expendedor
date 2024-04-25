class Comprador {
    private Producto productoConsumido;
    private int vueltoTotal;
    private int numeroDeposito; // Añadir numeroDeposito como atributo

    public Comprador(Moneda moneda, int numeroDeposito, Expendedor exp) {
        this.numeroDeposito = numeroDeposito; // Asignar numeroDeposito al atributo

        try {
            productoConsumido = exp.comprarProducto(moneda, numeroDeposito);
            if (productoConsumido != null) {
                consumirProducto(productoConsumido);
            }

            Moneda vuelto;
            while ((vuelto = exp.getVuelto()) != null) {
                vueltoTotal += vuelto.getValor();
            }
        } catch (Expendedor.PagoIncorrectoException e) {
            System.out.println(e.getMessage());
        } catch (Expendedor.NoHayProductoException e) {
            System.out.println(e.getMessage());
        }
    }

    private void consumirProducto(Producto producto) {
        if (producto != null) {
            System.out.println(" ");
        }
    }

    public int cuantoVuelto() {
        return vueltoTotal;
    }

    public String queConsumiste() {
        if (productoConsumido != null) {
            if (numeroDeposito <= 2) {
                return Producto.Bebida.values()[numeroDeposito - 1].getNombre();
            } else {
                return Producto.Snack.values()[numeroDeposito - 3].getNombre();
            }
        } else {
            return "Ningún producto adquirido";
        }
    }
}