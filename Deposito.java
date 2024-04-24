import java.util.ArrayList;

class Deposito<T> { 
    private ArrayList<T> al;
    
    public Deposito(){
        al = new ArrayList<>();
    }
    
    public void addObject(T x){ 
        al.add(x);
    }
    
    public T getObject(){
        if (al.size() == 0) {
            return null;
        }
        return al.remove(0);
    }
}