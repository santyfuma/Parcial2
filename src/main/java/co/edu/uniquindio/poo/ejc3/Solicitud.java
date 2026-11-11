package co.edu.uniquindio.poo.ejc3;

public class Solicitud {
    private String codigo;
    private Prioridad prioridad;
    private int duracion; // minutos, entero positivo

    public Solicitud(String codigo, Prioridad prioridad, int duracion) {
        this.codigo = codigo;
        this.prioridad = prioridad;
        this.duracion = duracion;
    }

    public String getCodigo() {
        return codigo;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return codigo + " (" + prioridad + ", " + duracion + " min)";
    }
}