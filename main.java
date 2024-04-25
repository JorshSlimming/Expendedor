/**
 * La clase principal que contiene el método main para ejecutar el programa de compra de productos.
 */
public class main {

    /**
     * El método principal que inicia el programa.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        // Crear un expendedor con 10 bebidas y 10 snacks
        Expendedor expendedor = new Expendedor(10, 10);

        // Crear instancias de monedas
        Moneda moneda1000 = new Moneda1000();
        Moneda moneda500 = new Moneda500();
        Moneda moneda100 = new Moneda100();

        // Comprar una bebida con moneda de $1000 y depósito 1
        Comprador comprador1 = new Comprador(moneda1000, 1, expendedor);
        System.out.println("Comprador 1: Producto adquirido: " + comprador1.queConsumiste() + ", vuelto: " + comprador1.cuantoVuelto());

        // Comprar un snack con moneda de $500 y depósito 3
        Comprador comprador2 = new Comprador(moneda500, 3, expendedor);
        System.out.println("Comprador 2: Producto adquirido: " + comprador2.queConsumiste() + ", vuelto: " + comprador2.cuantoVuelto());

        // Intentar comprar un snack con moneda de $100 y depósito 2 (debería lanzar una PagoIncorrectoException)
        Comprador comprador3 = new Comprador(moneda100, 2, expendedor); // Error: PagoIncorrectoException

        // Intentar comprar un producto con moneda null y depósito 1 (debería lanzar una PagoIncorrectoException)
        Comprador comprador4 = new Comprador(null, 1, expendedor); // Error: PagoIncorrectoException

        // Intentar comprar un producto con depósito incorrecto (debería lanzar una NoHayProductoException)
        Comprador comprador5 = new Comprador(moneda1000, 5, expendedor); // Error: NoHayProductoException

        // Intentar comprar un producto con una moneda de valor suficiente pero depósito inexistente (debería lanzar una NoHayProductoException)
        Comprador comprador6 = new Comprador(moneda1000, 20, expendedor); // Error: NoHayProductoException

        // Intentar comprar un producto con una moneda de valor insuficiente y depósito inexistente (debería lanzar una NoHayProductoException)
        Comprador comprador7 = new Comprador(moneda100, 20, expendedor); // Error: NoHayProductoException

        // Intentar comprar un producto con una moneda null y depósito inexistente (debería lanzar una PagoIncorrectoException)
        Comprador comprador8 = new Comprador(null, 20, expendedor); // Error: PagoIncorrectoException
    }
}
