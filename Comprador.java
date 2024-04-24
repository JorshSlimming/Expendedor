class Comprador{
    private Expendedor expendedor;
    private String sonido;
    private int vueltoTotal = 0;
    
    public Comprador(Moneda m,int cual, Expendedor exp){
        expendedor = exp;
        Bebida bebida = exp.comprarBebida(m, cual);
        for (Moneda i = expendedor.getVuelto(); i != null ; i = expendedor.getVuelto()) {
            vueltoTotal += i.getValor();
        }
        if (bebida == null) {
            sonido = null;
        }
        else sonido = bebida.beber();
    }
    public int cuantoVuelto(){
        return vueltoTotal;
    }
    public String queBebiste(){
        return sonido;
    }
}