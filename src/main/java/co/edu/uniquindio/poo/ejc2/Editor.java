package co.edu.uniquindio.poo.ejc2;

import co.edu.uniquindio.poo.stack.Stack;

public class Editor {

    /**
     * Retorna una nueva pila con las acciones comprendidas entre las posiciones
     * inicio y fin (ambas incluidas), contadas desde el tope empezando en 1.
     * La acción en la posición inicio queda en el tope del resultado.
     * La pila original no se modifica.
     */
    public static Stack<Accion> obtenerSegmento(Stack<Accion> pila, int inicio, int fin) {
        Stack<Accion> resultado = new Stack<>();

        if (inicio < 1 || inicio > fin || fin > pila.getSize()) {
            return resultado;
        }

        // Se trabaja sobre un clon para que la pila original quede intacta
        Stack<Accion> copia = pila.clone();
        Stack<Accion> auxiliar = new Stack<>();

        // Se recorren las posiciones 1..fin y se guardan las que están desde inicio
        for (int posicion = 1; posicion <= fin; posicion++) {
            Accion actual = copia.pop();
            if (posicion >= inicio) {
                auxiliar.push(actual);
            }
        }

        // La auxiliar tiene la posición inicio abajo; se invierte para dejarla en el tope
        while (!auxiliar.isEmpty()) {
            resultado.push(auxiliar.pop());
        }

        return resultado;
    }
}
