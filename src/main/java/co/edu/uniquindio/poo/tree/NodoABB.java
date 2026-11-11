package co.edu.uniquindio.poo.tree;

public class NodoABB<T> {
    private T elemento;
    private NodoABB<T> izquierdo;
    private NodoABB<T> derecho;

    public NodoABB(T elemento) {
        this.elemento = elemento;
        this.izquierdo = null;
        this.derecho = null;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NodoABB<T> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoABB<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoABB<T> getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoABB<T> derecho) {
        this.derecho = derecho;
    }
}
