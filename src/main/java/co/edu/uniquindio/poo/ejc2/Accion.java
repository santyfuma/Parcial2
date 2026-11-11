package co.edu.uniquindio.poo.ejc2;

public class Accion {
    private String codigo;

    public Accion(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return codigo;
    }
}
