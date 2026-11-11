package co.edu.uniquindio.poo.ejc4;

import co.edu.uniquindio.poo.tree.ArbolBinarioBusqueda;

public class Main {

    public static void main(String[] args) {
        ArbolBinarioBusqueda<Integer> equipos = new ArbolBinarioBusqueda<>();
        equipos.insertar(50);
        equipos.insertar(30);
        equipos.insertar(70);
        equipos.insertar(20);
        equipos.insertar(40);
        equipos.insertar(60);
        equipos.insertar(80);
        equipos.insertar(55);
        equipos.insertar(65);

        int cantidad = Laboratorio.contarEquiposEnRango(equipos.getRaiz(), 40, 65);

        System.out.println("Equipos con código entre 40 y 65: " + cantidad);
    }
}
