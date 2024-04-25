abstract class Moneda implements Comparable<Moneda> {
    public Moneda() {}

    public abstract int getValor();

    @Override
    public int compareTo(Moneda o) {
        return Integer.compare(this.getValor(), o.getValor());
    }
}