public class main {
    public static void main(String[] args) {
        Expendedor expendedor = new Expendedor(2, 2);
        Moneda moneda100 = new Moneda100();
        Moneda moneda500 = new Moneda500();
        Moneda moneda1000 = new Moneda1000();

        Comprador comprador1 = new Comprador(moneda1000, Producto.BEBIDA, 1, expendedor);
        System.out.println("Bebida comprada: " + comprador1.queBebiste());
        System.out.println("Vuelto total: " + comprador1.cuantoVuelto());

        Comprador comprador2 = new Comprador(moneda100, Producto.SNACK, 1, expendedor);
        System.out.println("Snack comprado: " + comprador2.queBebiste());
        System.out.println("Vuelto total: " + comprador2.cuantoVuelto());

    }
}

class PagoIncorrectoException extends Exception {
    public PagoIncorrectoException(String message) {
        super(message);
    }
}

class NoHayProductoException extends Exception {
    public NoHayProductoException(String message) {
        super(message);
    }
}