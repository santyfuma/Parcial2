package co.edu.uniquindio.poo.stack;

/**
 * Nodo simple genérico para estructuras enlazadas (pila, cola, lista).
 * Almacena un dato de tipo T y una referencia al siguiente nodo.
 */
public class NodeSimple<T> {

    private T data;
    private NodeSimple<T> next;

    /**
     * Constructor de la clase Nodo.
     * Crea un nuevo nodo asignándole el dato recibido.
     * Por defecto, el puntero 'next' queda como null (vacío).
     *
     * @param data El dato de tipo genérico T que va a almacenar este nodo.
     */
    public NodeSimple(T data) {
        this.data = data;
        this.next = null;
    }

    /**
     * Obtiene el dato que almacena el nodo actual.
     *
     * @return El dato de tipo T contenido en el nodo.
     */
    public T getData() {
        return data;
    }

    /**
     * Modifica o actualiza el dato almacenado en el nodo.
     *
     * @param data El nuevo dato de tipo T que reemplazará al anterior.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Obtiene la referencia al siguiente nodo en la secuencia.
     *
     * @return El siguiente NodeSimple<T>, o null si este es el último nodo.
     */
    public NodeSimple<T> getNext() {
        return next;
    }

    /**
     * Enlaza este nodo con el que le sigue en la estructura.
     *
     * @param next El nodo NodeSimple<T> que se posicionará justo después de este.
     */
    public void setNext(NodeSimple<T> next) {
        this.next = next;
    }
}