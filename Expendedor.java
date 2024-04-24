class Expendedor{
    public static final int  COCA = 1;
    public static final int  SPRITE = 2;

    private Deposito depositoCoca;
    private Deposito depositoSprite;
    private Deposito monedasVuelto;

    private int precioBebida;
    private Bebida bebi;
    
    public Expendedor(int numBebidas, int precioBebidas){
        depositoCoca = new Deposito();
        depositoSprite = new Deposito();
        monedasVuelto = new Deposito();
        precioBebida = precioBebidas;

        for (int i = 100; i < 100 + numBebidas; i++) {
            depositoCoca.addObject(new CocaCola(i));
        }
        for (int i = 200; i < 200 + numBebidas; i++) {
            depositoSprite.addObject(new Sprite(i));
        }
    }

    public Bebida comprarBebida(Moneda m, int n){
        bebi = null;
        if (m == null){
            monedasVuelto.addObject(new Moneda0());
            return null;
        }
        if (n == 1) {
            if (m.getValor() >= precioBebida){
                bebi = (Bebida)depositoCoca.getObject();
            }
        }
        else if (n == 2) {
            if (m.getValor() >= precioBebida){
                bebi = (Bebida)depositoSprite.getObject();
            }
        }
        if (bebi == null){
            monedasVuelto.addObject(m);
            return null;
        }
        for (int i = 0;m.getValor()>precioBebida+i;i += 100){
            monedasVuelto.addObject(new Moneda100());
        }
        return bebi;
    }
    public Moneda getVuelto(){
        return (Moneda) monedasVuelto.getObject();
    }
}