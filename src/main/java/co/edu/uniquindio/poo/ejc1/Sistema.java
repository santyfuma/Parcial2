package co.edu.uniquindio.poo.ejc1;

import co.edu.uniquindio.poo.stack.Stack;

public class Sistema {

    /**
     * Retorna una nueva pila con las n operaciones confirmadas más recientes,
     * dejando en el tope la más reciente de ellas. La pila original no se modifica.
     */
    public static Stack<Operacion> obtenerUltimasConfirmadas(Stack<Operacion> historial, int n) {
        Stack<Operacion> resultado = new Stack<>();

        if (n <= 0 || historial.isEmpty()) {
            return resultado;
        }

        // Se trabaja sobre un clon para que el historial original quede intacto
        Stack<Operacion> copia = historial.clone();
        Stack<Operacion> auxiliar = new Stack<>();
        int seleccionadas = 0;

        // De la más reciente a la más antigua, hasta reunir n confirmadas
        while (!copia.isEmpty() && seleccionadas < n) {
            Operacion actual = copia.pop();
            if (actual.getEstado() == Estado.CONFIRMADA) {
                auxiliar.push(actual);
                seleccionadas++;
            }
        }

        // La auxiliar tiene la más reciente abajo; se invierte para dejarla en el tope
        while (!auxiliar.isEmpty()) {
            resultado.push(auxiliar.pop());
        }

        return resultado;
    }
}
