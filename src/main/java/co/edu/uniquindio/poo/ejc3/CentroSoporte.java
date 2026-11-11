package co.edu.uniquindio.poo.ejc3;

import co.edu.uniquindio.poo.queue.Queue;

public class CentroSoporte {

    /**
     * Retorna una nueva cola con las solicitudes seleccionadas para la jornada y las
     * retira de la cola de pendientes. Primero se consideran las de prioridad ALTA y
     * luego las NORMAL, cada grupo en su orden de llegada. Una solicitud se selecciona
     * solo si cabe en el tiempo restante; si no, sigue pendiente.
     */
    public static Queue<Solicitud> seleccionarSolicitudes(Queue<Solicitud> pendientes, int minutosDisponibles) {
        Queue<Solicitud> seleccionadas = new Queue<>();

        // Sin tiempo disponible: cola vacía y pendientes intactas
        if (minutosDisponibles <= 0) {
            return seleccionadas;
        }

        int restante = minutosDisponibles;

        // Primero se evalúan las ALTA y después las NORMAL
        Prioridad[] orden = {Prioridad.ALTA, Prioridad.NORMAL};

        for (Prioridad prioridadActual : orden) {
            // Se da una vuelta completa a la cola: lo que no se selecciona se reencola,
            // así las pendientes conservan su orden de llegada relativo
            int total = pendientes.getSize();
            for (int i = 0; i < total; i++) {
                Solicitud solicitud = pendientes.desencolar();

                if (solicitud.getPrioridad() == prioridadActual && solicitud.getDuracion() <= restante) {
                    seleccionadas.encolar(solicitud);
                    restante -= solicitud.getDuracion();
                } else {
                    pendientes.encolar(solicitud);
                }
            }
        }

        return seleccionadas;
    }
}
