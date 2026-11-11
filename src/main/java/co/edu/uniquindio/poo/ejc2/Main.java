package co.edu.uniquindio.poo.ejc2;

import co.edu.uniquindio.poo.stack.Stack;

public class Main {

    public static void main(String[] args) {
        // Pila del ejemplo (de fondo a tope): A1, A2, A3, A4, A5, A6
        Stack<Accion> pila = new Stack<>();
        pila.push(new Accion("A1"));
        pila.push(new Accion("A2"));
        pila.push(new Accion("A3"));
        pila.push(new Accion("A4"));
        pila.push(new Accion("A5"));
        pila.push(new Accion("A6"));

        Stack<Accion> segmento = Editor.obtenerSegmento(pila, 2, 4);

        System.out.println("=== Segmento (inicio = 2, fin = 4) ===");
        segmento.print();

        System.out.println("\n=== Pila original ===");
        pila.print();
    }
}
