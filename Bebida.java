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