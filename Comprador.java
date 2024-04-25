class Comprador{
    private Expendedor expendedor;
    private String sonido;
    private int vueltoTotal = 0;
    
    public Comprador(Producto producto, Moneda moneda, int numeroDeposito, Expendedor exp){
        expendedor = exp;
        Producto productoComprado = expendedor.comprarProducto(moneda, numeroDeposito, producto);
        for (Moneda i = expendedor.getVuelto(); i != null ; i = expendedor.getVuelto()) {
            vueltoTotal += i.getValor();
        }
        if (productoComprado == null) {
            sonido = null;
        } else {
            sonido = productoComprado.toString();
        }
    }
    public int cuantoVuelto(){
        return vueltoTotal;
    }
    public String queBebiste(){
        return sonido;
    }
}