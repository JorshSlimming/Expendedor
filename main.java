package org.example;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(7,1000);
        Moneda m = null;
        Comprador c = null;
        m = new Moneda1500();
        c = new Comprador(m,Expendedor.SPRITE,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
    }
}

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

class Deposito{
    private ArrayList al;
    public Deposito(){
        al = new ArrayList();
    }
    public void addObject(Object x){
        al.add(x);
    }
    public Object getObject(){
        if (al.size() == 0) {
            return null;
        }
        return al.remove(0);
    }
}

abstract class Bebida{
    private int numSerie;
    public Bebida(int x){
        numSerie = x;
    }
    public int getSerie(){
        return numSerie;
    }
    public abstract String beber();
}
class Sprite extends Bebida{
    public Sprite(int x){
        super(x);
    }
    public String beber(){
        return "sprite";
    }
}
class CocaCola extends Bebida{
    public CocaCola(int x){
        super(x);
    }
    public String beber(){
        return "cocacola";
    }
}

abstract class Moneda{
    public Moneda(){

    }
    public Moneda getSerie(){
        return this;
    }
    public abstract int getValor();
}
class Moneda1500 extends Moneda{
    public Moneda1500(){
        super();
    }
    public int getValor(){
        return 1500;
    }
}
class Moneda1000 extends Moneda{
    public Moneda1000(){
        super();
    }
    public int getValor(){
        return 1000;
    }
}
class Moneda500 extends Moneda{
    public Moneda500(){
        super();
    }
    public int getValor(){
        return 500;
    }
}
class Moneda100 extends Moneda{
    public Moneda100(){
        super();
    }
    public int getValor(){
        return 100;
    }
}
class Moneda0 extends Moneda{
    public Moneda0(){
        super();
    }
    public int getValor(){
        return 0;
    }
}

