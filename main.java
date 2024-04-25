public class Main {
    public static void main(String[] args) {
        Expendedor expendedor = new Expendedor(10, 10); // Crear un expendedor con 10 bebidas y 10 snacks
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
        Comprador comprador3 = new Comprador(moneda100, 2, expendedor);

        // Intentar comprar un producto con moneda null y depósito 1 (debería lanzar una PagoIncorrectoException)
        Comprador comprador4 = new Comprador(null, 1, expendedor);

        // Intentar comprar un producto con depósito incorrecto (debería lanzar una NoHayProductoException)
        Comprador comprador5 = new Comprador(moneda1000, 5, expendedor);
    }
}