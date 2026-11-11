package co.edu.uniquindio.poo.ejc1;

import co.edu.uniquindio.poo.stack.Stack;

public class Main {

    public static void main(String[] args) {
        // Historial del ejemplo (de fondo a tope): O1, O2, O3, O4, O5
        Stack<Operacion> historial = new Stack<>();
        historial.push(new Operacion("O1", Estado.ANULADA));
        historial.push(new Operacion("O2", Estado.CONFIRMADA));
        historial.push(new Operacion("O3", Estado.CONFIRMADA));
        historial.push(new Operacion("O4", Estado.ANULADA));
        historial.push(new Operacion("O5", Estado.CONFIRMADA));

        Stack<Operacion> resultado = Sistema.obtenerUltimasConfirmadas(historial, 2);

        System.out.println("=== Resultado (n = 2) ===");
        resultado.print();

        System.out.println("\n=== Historial original ===");
        historial.print();
    }
}
