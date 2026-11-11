package co.edu.uniquindio.poo.ejc3;

import co.edu.uniquindio.poo.queue.Queue;

public class Main {

    public static void main(String[] args) {
        // Cola de pendientes del ejemplo (en orden de llegada)
        Queue<Solicitud> pendientes = new Queue<>();
        pendientes.encolar(new Solicitud("S1", Prioridad.NORMAL, 10));
        pendientes.encolar(new Solicitud("S2", Prioridad.ALTA, 30));
        pendientes.encolar(new Solicitud("S3", Prioridad.ALTA, 15));
        pendientes.encolar(new Solicitud("S4", Prioridad.NORMAL, 5));

        Queue<Solicitud> seleccionadas = CentroSoporte.seleccionarSolicitudes(pendientes, 25);

        System.out.println("=== Seleccionadas (25 min) ===");
        seleccionadas.print();

        System.out.println("\n=== Pendientes ===");
        pendientes.print();
    }
}
