package co.edu.uniquindio.poo.ejc1;

public class Operacion {

    private String codigo;
    private Estado estado;

    public Operacion(String codigo, Estado estado) {
        this.codigo = codigo;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public Estado getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return codigo + " (" + estado + ")";
    }
}
