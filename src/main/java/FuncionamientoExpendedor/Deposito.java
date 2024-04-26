package FuncionamientoExpendedor;

import java.util.ArrayList;

/**
 * Representa un depósito genérico que almacena objetos de tipo T.
 *
 * @param <T> El tipo de objeto que se almacenará en el depósito.
 */
class Deposito<T> {
    private ArrayList<T> al; // Lista que almacena los objetos en el depósito

    /**
     * Crea un nuevo depósito vacío.
     */
    public Deposito() {
        al = new ArrayList<>(); // Inicializar la lista
    }

    /**
     * Agrega un objeto al depósito.
     *
     * @param x El objeto a agregar al depósito.
     */
    public void addObject(T x) {
        al.add(x); // Agregar el objeto a la lista
    }

    /**
     * Obtiene y remueve el primer objeto del depósito.
     *
     * @return El primer objeto del depósito, o null si el depósito está vacío.
     */
    public T getObject() {
        if (al.size() == 0) {
            return null; // Devuelve null si el depósito está vacío
        }
        return al.remove(0); // Devuelve y remueve el primer objeto del depósito
    }
}
