public class main {
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(7,1000);
        Moneda m = null;
        Comprador c = null;
        m = new Moneda1500();
        c = new Comprador(m,Expendedor.SPRITE,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
    }
}